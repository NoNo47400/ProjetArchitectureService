// User page JavaScript code

document.addEventListener('DOMContentLoaded', function() {
    const requestsContainer = document.getElementById('requestsContainer');
    let currentResponseId = null;

    // Retrieve administrator information from localStorage
    const loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));
    if (!loggedInUser) {
        window.location.href = '../html/login.html';
        return;
    }
    const adminId = loggedInUser.id;
    const userName = loggedInUser.username;

    // Set the username in the dashboard header
    document.getElementById('dashboardHeader').textContent = `${userName} Dashboard`;

    // Handle logout
    document.getElementById('logoutButton').addEventListener('click', function() {
        localStorage.removeItem('loggedInUser');
        window.location.href = '../html/login.html';
    });

    function fetchRequests() {
        fetch('http://localhost:8081/administrators/requests')
            .then(response => response.json())
            .then(requests => {
                fetch('http://localhost:8081/administrators/responses')
                    .then(response => response.json())
                    .then(responses => {
                        fetch('http://localhost:8082/users')
                            .then(response => response.json())
                            .then(users => {
                                fetch('http://localhost:8083/volunteers')
                                    .then(response => response.json())
                                    .then(volunteers => {
                                        fetch('http://localhost:8081/administrators/feedbacks')
                                            .then(response => response.json())
                                            .then(feedbacks => {
                                                displayRequests(requests, responses, users, volunteers, feedbacks);
                                            });
                                    });
                            });
                    });
            });
    }

    function displayRequests(requests, responses, users, volunteers, feedbacks) {
        requestsContainer.innerHTML = '';
        const filter = document.querySelector('input[name="requestFilter"]:checked').value;

        requests.forEach(request => {
            if ((filter === 'validated' && !request.validated) || (filter === 'invalidated' && request.validated)) return;

            const user = users.find(user => user.id === request.userId);
            const requestElement = document.createElement('div');
            requestElement.classList.add('request');
            requestElement.innerHTML = `
                <h3>Request: ${request.objectOfRequest}</h3>
                <p>User: <a href="mailto:${user.email}" title="${user.email}"> ${user.username} </a></p>
                <p>Text: ${request.textOfRequest}</p>
                ${!request.validated ? `<button type="button" class="validateButton" data-request-id="${request.id}">Validate</button>` : ''}
                <button type="button" class="deleteRequestButton" data-request-id="${request.id}">Delete Request</button>
            `;

            const responseList = document.createElement('ul');
            responses.forEach(response => {
                if (response.requestId === request.id) {
                    const volunteer = volunteers.find(volunteer => volunteer.id === response.volunteerId);
                    const responseElement = document.createElement('li');
                    responseElement.innerHTML = `
                        <p>${response.textOfResponse}</p>
                        <p>Volunteer: <a href="mailto:${volunteer.email}" title="${volunteer.email}"> ${volunteer.username} </a></p>
                        <button type="button" class="deleteResponseButton" data-response-id="${response.id}">Delete Response</button>
                    `;

                    const feedbackList = document.createElement('ul');
                    feedbacks.forEach(feedback => {
                        if (feedback.responseId === response.id) {
                            const feedbackElement = document.createElement('li');
                            feedbackElement.textContent = feedback.textOfFeedback;
                            feedbackElement.style.color = feedback.validated ? 'green' : 'red';
                            feedbackElement.innerHTML += `<button type="button" class="deleteFeedbackButton" data-feedback-id="${feedback.id}">Delete Feedback</button>`;
                            feedbackList.appendChild(feedbackElement);
                        }
                    });

                    responseElement.appendChild(feedbackList);
                    responseList.appendChild(responseElement);
                }
            });

            requestElement.appendChild(responseList);
            requestsContainer.appendChild(requestElement);
        });

        document.querySelectorAll('.validateButton').forEach(button => {
            button.addEventListener('click', function() {
                const requestId = this.getAttribute('data-request-id');
                validateRequest(requestId);
            });
        });

        document.querySelectorAll('.deleteRequestButton').forEach(button => {
            button.addEventListener('click', function() {
                const requestId = this.getAttribute('data-request-id');
                deleteRequest(requestId);
            });
        });

        document.querySelectorAll('.deleteResponseButton').forEach(button => {
            button.addEventListener('click', function() {
                const responseId = this.getAttribute('data-response-id');
                deleteResponse(responseId);
            });
        });

        document.querySelectorAll('.deleteFeedbackButton').forEach(button => {
            button.addEventListener('click', function() {
                const feedbackId = this.getAttribute('data-feedback-id');
                deleteFeedback(feedbackId);
            });
        });
    }

    function validateRequest(requestId) {
        fetch(`http://localhost:8081/administrators/requests/${requestId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ validated: true })
        })
        .then(response => response.json())
        .then(data => {
            alert('Request validated successfully!');
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to validate request: ' + error);
        });
    }

    function deleteRequest(requestId) {
        fetch(`http://localhost:8081/administrators/requests/${requestId}`, {
            method: 'DELETE'
        })
        .then(response => response.text())
        .then(data => {
            alert('Request deleted successfully!');
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to delete request: ' + error);
        });
    }

    function deleteResponse(responseId) {
        fetch(`http://localhost:8081/administrators/responses/${responseId}`, {
            method: 'DELETE'
        })
        .then(response => response.text())
        .then(data => {
            alert('Response deleted successfully!');
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to delete response: ' + error);
        });
    }

    function deleteFeedback(feedbackId) {
        fetch(`http://localhost:8081/administrators/feedbacks/${feedbackId}`, {
            method: 'DELETE'
        })
        .then(response => response.text())
        .then(data => {
            alert('Feedback deleted successfully!');
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to delete feedback: ' + error);
        });
    }

    document.querySelectorAll('input[name="requestFilter"]').forEach(radio => {
        radio.addEventListener('change', fetchRequests);
    });

    fetchRequests();
});