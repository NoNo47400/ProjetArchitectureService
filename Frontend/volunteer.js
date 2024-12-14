
// Volunteer page JavaScript code

document.addEventListener('DOMContentLoaded', function() {
    const volunteerForm = document.getElementById('volunteer-form');
    const submitButton = document.getElementById('submit-button');
    const successMessage = document.getElementById('success-message');
    const errorMessage = document.getElementById('error-message');

    volunteerForm.addEventListener('submit', function(event) {
        event.preventDefault();
        submitButton.disabled = true;

        const formData = new FormData(volunteerForm);

        fetch('/volunteer', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                successMessage.style.display = 'block';
                errorMessage.style.display = 'none';
                volunteerForm.reset();
            } else {
                successMessage.style.display = 'none';
                errorMessage.style.display = 'block';
            }
            submitButton.disabled = false;
        })
        .catch(error => {
            successMessage.style.display = 'none';
            errorMessage.style.display = 'block';
            submitButton.disabled = false;
        });
    });
});