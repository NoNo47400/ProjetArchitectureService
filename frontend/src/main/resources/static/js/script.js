// URL de base des services
const adminServiceUrl = 'http://localhost:8082/api/admins';
const userServiceUrl = 'http://localhost:8081/ws';

// Fonction pour charger les administrateurs
function loadAdmins() {
    fetch(adminServiceUrl)
        .then(response => response.json())
        .then(admins => {
            const tbody = document.querySelector('#adminTable tbody');
            tbody.innerHTML = '';
            admins.forEach(admin => {
                tbody.innerHTML += `
                    <tr>
                        <td>${admin.username}</td>
                        <td>${admin.email}</td>
                        <td>${admin.role}</td>
                    </tr>
                `;
            });
        })
        .catch(error => console.error('Error:', error));
}

// Fonction pour créer un administrateur
function createAdmin(adminData) {
    fetch(adminServiceUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(adminData)
    })
    .then(response => response.json())
    .then(data => {
        loadAdmins();
        document.getElementById('adminForm').reset();
    })
    .catch(error => console.error('Error:', error));
}

// Fonction pour créer un utilisateur via SOAP
function createUser(userData) {
    const soapRequest = `<?xml version="1.0" encoding="UTF-8"?>
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:user="http://microservices.com/user">
            <soapenv:Header/>
            <soapenv:Body>
                <user:createUserRequest>
                    <user:user>
                        <user:username>${userData.username}</user:username>
                        <user:email>${userData.email}</user:email>
                        <user:password>${userData.password}</user:password>
                    </user:user>
                </user:createUserRequest>
            </soapenv:Body>
        </soapenv:Envelope>`;

    fetch(userServiceUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text/xml;charset=UTF-8',
            'SOAPAction': ''
        },
        body: soapRequest
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => {
                throw new Error(text);
            });
        }
        return response.text();
    })
    .then(str => {
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(str, "text/xml");
        
        // Vérifier s'il y a une erreur SOAP
        const faultString = xmlDoc.getElementsByTagName("faultstring")[0];
        if (faultString) {
            throw new Error(faultString.textContent);
        }
        
        loadUsers();
        document.getElementById('userForm').reset();
        document.getElementById('userError').textContent = '';
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('userError').textContent = error.message || 'An error occurred while creating the user';
    });
}

// Fonction pour charger la liste des utilisateurs
function loadUsers() {
    const soapRequest = `<?xml version="1.0" encoding="UTF-8"?>
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:user="http://microservices.com/user">
            <soapenv:Header/>
            <soapenv:Body>
                <user:getAllUsersRequest/>
            </soapenv:Body>
        </soapenv:Envelope>`;

    fetch(userServiceUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text/xml;charset=UTF-8',
            'SOAPAction': ''
        },
        body: soapRequest
    })
    .then(response => response.text())
    .then(str => {
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(str, "text/xml");
        const users = xmlDoc.getElementsByTagName("ns2:user");
        let html = '';
        for (let user of users) {
            const username = user.getElementsByTagName("ns2:username")[0].textContent;
            const email = user.getElementsByTagName("ns2:email")[0].textContent;
            html += `
                <tr>
                    <td>${username}</td>
                    <td>${email}</td>
                </tr>
            `;
        }
        document.getElementById('userTable').getElementsByTagName('tbody')[0].innerHTML = html;
    })
    .catch(error => console.error('Error:', error));
}

// Initialisation des gestionnaires d'événements
document.addEventListener('DOMContentLoaded', function() {
    // Chargement initial des administrateurs
    loadAdmins();
    // Chargement initial des utilisateurs
    loadUsers();

    // Gestionnaire de soumission du formulaire administrateur
    document.getElementById('adminForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const adminData = {
            username: document.getElementById('adminUsername').value,
            email: document.getElementById('adminEmail').value,
            password: document.getElementById('adminPassword').value,
            role: document.getElementById('adminRole').value
        };
        createAdmin(adminData);
    });

    // Gestionnaire de soumission du formulaire utilisateur
    document.getElementById('userForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const userData = {
            username: document.getElementById('userUsername').value,
            email: document.getElementById('userEmail').value,
            password: document.getElementById('userPassword').value
        };
        createUser(userData);
    });
});
