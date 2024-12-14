let currentRole = 'user';

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    let url;
    if (currentRole === 'admin') {
        url = 'http://localhost:8081/administrators';
    } else if (currentRole === 'user') {
        url = 'http://localhost:8082/users';
    } else if (currentRole === 'volunteer') {
        url = 'http://localhost:8083/volunteers';
    }

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        const user = data.find(user => user.username === username && user.password === password);
        if (user) {
            // Store user information in localStorage
            localStorage.setItem('loggedInUser', JSON.stringify(user));
            if (currentRole === 'admin') {
                window.location.href = '../html/administrator.html';
            } else if (currentRole === 'user') {
                window.location.href = '../html/user.html';
            } else if (currentRole === 'volunteer') {
                window.location.href = '../html/volunteer.html';
            }
        } else {
            document.getElementById('loginErrorMessage').style.display = 'block';
            document.getElementById('loginErrorText').textContent = 'Invalid username or password';
        }
    })
    .catch(error => {
        document.getElementById('loginErrorMessage').style.display = 'block';
        document.getElementById('loginErrorText').textContent = error;
    });
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const newUsername = document.getElementById('newUsername').value;
    const email = document.getElementById('email').value;
    const newPassword = document.getElementById('newPassword').value;

    let url;
    if (currentRole === 'admin') {
        url = 'http://localhost:8081/administrators';
    } else if (currentRole === 'user') {
        url = 'http://localhost:8082/users';
    } else if (currentRole === 'volunteer') {
        url = 'http://localhost:8083/volunteers';
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: newUsername,
            email: email,
            password: newPassword
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            document.getElementById('registerSuccessMessage').style.display = 'block';
            document.getElementById('registerErrorMessage').style.display = 'none';
        } else {
            document.getElementById('registerSuccessMessage').style.display = 'none';
            document.getElementById('registerErrorMessage').style.display = 'block';
            document.getElementById('registerErrorText').textContent = 'This username is already taken';
        }
    })
    .catch(error => {
        document.getElementById('registerSuccessMessage').style.display = 'none';
        document.getElementById('registerErrorMessage').style.display = 'block';
        document.getElementById('registerErrorText').textContent = error;
    });
});

document.getElementById('adminLogin').addEventListener('click', function() {
    currentRole = 'admin';
    document.getElementById('username').placeholder = 'Admin Username';
    document.getElementById('password').placeholder = 'Admin Password';
    document.getElementById('loginForm').classList.add('active');
    document.getElementById('registerForm').classList.remove('active');
});

document.getElementById('userLogin').addEventListener('click', function() {
    currentRole = 'user';
    document.getElementById('username').placeholder = 'User Username';
    document.getElementById('password').placeholder = 'User Password';
    document.getElementById('loginForm').classList.add('active');
    document.getElementById('registerForm').classList.remove('active');
});

document.getElementById('volunteerLogin').addEventListener('click', function() {
    currentRole = 'volunteer';
    document.getElementById('username').placeholder = 'Volunteer Username';
    document.getElementById('password').placeholder = 'Volunteer Password';
    document.getElementById('loginForm').classList.add('active');
    document.getElementById('registerForm').classList.remove('active');
});

document.getElementById('adminRegister').addEventListener('click', function() {
    currentRole = 'admin';
    document.getElementById('newUsername').placeholder = 'Admin Username';
    document.getElementById('email').placeholder = 'Admin Email';
    document.getElementById('newPassword').placeholder = 'Admin Password';
    document.getElementById('registerForm').classList.add('active');
    document.getElementById('loginForm').classList.remove('active');
});

document.getElementById('userRegister').addEventListener('click', function() {
    currentRole = 'user';
    document.getElementById('newUsername').placeholder = 'User Username';
    document.getElementById('email').placeholder = 'User Email';
    document.getElementById('newPassword').placeholder = 'User Password';
    document.getElementById('registerForm').classList.add('active');
    document.getElementById('loginForm').classList.remove('active');
});

document.getElementById('volunteerRegister').addEventListener('click', function() {
    currentRole = 'volunteer';
    document.getElementById('newUsername').placeholder = 'Volunteer Username';
    document.getElementById('email').placeholder = 'Volunteer Email';
    document.getElementById('newPassword').placeholder = 'Volunteer Password';
    document.getElementById('registerForm').classList.add('active');
    document.getElementById('loginForm').classList.remove('active');
});

// Set default placeholders
document.getElementById('username').placeholder = 'User Username';
document.getElementById('password').placeholder = 'User Password';