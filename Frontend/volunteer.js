// volunteer page JavaScript code

document.addEventListener('DOMContentLoaded', function() {
    const requestsContainer = document.getElementById('requestsContainer');
    const createResponseForm = document.getElementById('createResponseForm');
    let currentRequestId = null;

    // Retrieve volunteer information from localStorage
    const loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));
    if (!loggedInUser) {
        window.location.href = 'login.html';
        return;
    }
    const volunteerId = loggedInUser.id;
    const userName = loggedInUser.username;

    // Set the username in the dashboard header
    document.getElementById('dashboardHeader').textContent = `${userName} Dashboard`;

    // Handle logout
    document.getElementById('logoutButton').addEventListener('click', function() {
        localStorage.removeItem('loggedInUser');
        window.location.href = 'login.html';
    });

    function fetchRequests() {
        fetch('http://localhost:8083/volunteers/requests')
            .then(response => response.json())
            .then(requests => {
                fetch('http://localhost:8083/volunteers/responses')
                    .then(response => response.json())
                    .then(responses => {
                        fetch('http://localhost:8082/users')
                            .then(response => response.json())
                            .then(users => {
                                fetch('http://localhost:8083/volunteers')
                                    .then(response => response.json())
                                    .then(volunteers => {
                                        fetch('http://localhost:8083/volunteers/feedbacks')
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

        requests.forEach(request => {
            if (request.validated !== true) return;

            const user = users.find(user => user.id === request.userId);

            const requestElement = document.createElement('div');
            requestElement.classList.add('request');
            requestElement.innerHTML = `
                <h3>Request: ${request.objectOfRequest}</h3>
                <p>User: <a href="mailto:${user.email}" title="${user.email}"> ${user.username} </a></p>
                <p>Text: ${request.textOfRequest}</p>
                <button type="button" class="responseButton" data-request-id="${request.id}">Add Response</button>
            `;

            const responseList = document.createElement('ul');
            responses.forEach(response => {
                if (response.requestId === request.id) {
                    const volunteer = volunteers.find(volunteer => volunteer.id === response.volunteerId);
                    const responseElement = document.createElement('li');
                    responseElement.innerHTML = `
                        <p>${response.textOfResponse}</p>
                        <p>Volunteer: <a href="mailto:${volunteer.email}" title="${volunteer.email}"> ${volunteer.username} </a></p>
                        ${volunteerId === response.volunteerId ? `<button type="button" class="deleteButton" data-response-id="${response.id}">Delete</button>` : ''}
                    `;

                    const feedbackList = document.createElement('ul');
                    feedbacks.forEach(feedback => {
                        if (feedback.responseId === response.id) {
                            const feedbackElement = document.createElement('li');
                            feedbackElement.textContent = feedback.textOfFeedback;
                            feedbackElement.style.color = feedback.validated ? 'green' : 'red';
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

        document.querySelectorAll('.responseButton').forEach(button => {
            button.addEventListener('click', function() {
                currentRequestId = this.getAttribute('data-request-id');
                createResponseForm.style.display = 'block';
                requestsContainer.style.display = 'none';
            });
        });

        document.querySelectorAll('.deleteButton').forEach(button => {
            button.addEventListener('click', function() {
                const responseId = this.getAttribute('data-response-id');
                deleteResponse(responseId);
            });
        });
    }

    function deleteResponse(responseId) {
        fetch(`http://localhost:8083/volunteers/responses/${responseId}`, {
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

    createResponseForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const responseText = document.getElementById('responseText').value;

        fetch('http://localhost:8083/volunteers/responses', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                volunteerId: volunteerId,
                requestId: currentRequestId,
                textOfResponse: responseText
            })
        })
        .then(response => response.json())
        .then(data => {
            alert('Response created successfully!');
            createResponseForm.style.display = 'none';
            requestsContainer.style.display = 'block';
            fetchRequests();
        })
        .catch(error => {
            alert('Failed to create response: ' + error);
        });
    });

    fetchRequests();
});