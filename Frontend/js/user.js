// User page JavaScript code

document.addEventListener('DOMContentLoaded', function() {
    const requestsContainer = document.getElementById('requestsContainer');
    const createRequestForm = document.getElementById('createRequestForm');
    const createFeedbackForm = document.getElementById('createFeedbackForm');
    let currentResponseId = null;

    // Retrieve user information from localStorage
    const loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));
    if (!loggedInUser) {
        window.location.href = '../html/login.html';
        return;
    }
    const userId = loggedInUser.id;
    const userName = loggedInUser.username;

    // Set the username in the dashboard header
    document.getElementById('dashboardHeader').textContent = `${userName} Dashboard`;

    // Handle logout
    document.getElementById('logoutButton').addEventListener('click', function() {
        localStorage.removeItem('loggedInUser');
        window.location.href = '../html/login.html';
    });

    function fetchRequests() {
        fetch('http://localhost:8082/users/requests')
            .then(response => response.json())
            .then(requests => {
                fetch('http://localhost:8082/users/responses')
                    .then(response => response.json())
                    .then(responses => {
                        fetch('http://localhost:8082/users')
                            .then(response => response.json())
                            .then(users => {
                                fetch('http://localhost:8083/volunteers')
                                    .then(response => response.json())
                                    .then(volunteers => {
                                        fetch('http://localhost:8082/users/feedbacks')
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

        if (filter === 'create') {
            createRequestForm.style.display = 'block';
            requestsContainer.style.display = 'none';
            createFeedbackForm.style.display = 'none';
            return;
        } else {
            createRequestForm.style.display = 'none';
            requestsContainer.style.display = 'block';
        }

        requests.forEach(request => {
            if (request.validated !== true) return;
            if (filter === 'mine' && request.userId !== userId) return;

            const user = users.find(user => user.id === request.userId);

            const requestElement = document.createElement('div');
            requestElement.classList.add('request');
            requestElement.innerHTML = `
                <h3>Request: ${request.objectOfRequest}</h3>
                <p>User: <a href="mailto:${user.email}" title="${user.email}"> ${user.username} </a></p>
                <p>Text: ${request.textOfRequest}</p>
                ${userId === request.userId ? `<button type="button" class="deleteButton" data-request-id="${request.id}">Delete</button>` : ''}
            `;

            const responseList = document.createElement('ul');
            responses.forEach(response => {
                if (response.requestId === request.id) {
                    const volunteer = volunteers.find(volunteer => volunteer.id === response.volunteerId);
                    const responseElement = document.createElement('li');
                    responseElement.innerHTML = `
                        <p>${response.textOfResponse}</p>
                        <p>Volunteer: <a href="mailto:${volunteer.email}" title="${volunteer.email}"> ${volunteer.username} </a></p>
                        ${request.userId === userId && !feedbacks.some(feedback => feedback.responseId === response.id) ? `<button type="button" class="feedbackButton" data-response-id="${response.id}">Add Feedback</button>` : ''}
                    `;

                    const feedbackList = document.createElement('ul');
                    feedbacks.forEach(feedback => {
                        if (feedback.responseId === response.id) {
                            const feedbackElement = document.createElement('li');
                            feedbackElement.textContent = feedback.textOfFeedback;
                            feedbackElement.style.color = feedback.validated ? 'green' : 'red';
                            feedbackElement.innerHTML += feedback.userId === userId ? `<button type="button" class="deleteFeedbackButton" data-feedback-id="${feedback.id}">Delete Feedback</button>` : '';
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

        document.querySelectorAll('.feedbackButton').forEach(button => {
            button.addEventListener('click', function() {
                currentResponseId = this.getAttribute('data-response-id');
                createFeedbackForm.style.display = 'block';
                requestsContainer.style.display = 'none';
            });
        });

        document.querySelectorAll('.deleteButton').forEach(button => {
            button.addEventListener('click', function() {
                const requestId = this.getAttribute('data-request-id');
                deleteResponse(requestId);
            });
        });

        document.querySelectorAll('.deleteFeedbackButton').forEach(button => {
            button.addEventListener('click', function() {
                const feedbackId = this.getAttribute('data-feedback-id');
                deleteFeedback(feedbackId);
            });
        });
    }

    function deleteResponse(requestId) {
        fetch(`http://localhost:8082/users/requests/${requestId}`, {
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
        fetch(`http://localhost:8082/users/feedbacks/${feedbackId}`, {
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

    createRequestForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const requestObject = document.getElementById('requestObject').value;
        const requestText = document.getElementById('requestText').value;

        fetch('http://localhost:8082/users/requests', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userId: userId,
                objectOfRequest: requestObject,
                textOfRequest: requestText,
                validated: false
            })
        })
        .then(response => response.json())
        .then(data => {
            alert('Request created successfully!');
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to create request: ' + error);
        });
    });

    document.getElementById('validateFeedback').addEventListener('click', function() {
        submitFeedback(true);
    });

    document.getElementById('invalidateFeedback').addEventListener('click', function() {
        submitFeedback(false);
    });

    function submitFeedback(validated) {
        const feedbackText = document.getElementById('feedbackText').value;

        fetch('http://localhost:8082/users/feedbacks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userId: userId,
                responseId: currentResponseId,
                textOfFeedback: feedbackText,
                validated: validated
            })
        })
        .then(response => response.json())
        .then(data => {
            alert('Feedback created successfully!');
            createFeedbackForm.style.display = 'none';
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to create feedback: ' + error);
        });
    }

    fetchRequests();
});