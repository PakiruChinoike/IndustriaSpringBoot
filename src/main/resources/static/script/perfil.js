const userEmail = localStorage.getItem('user');
getByEmail(userEmail);

function getByEmail(email) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/user/private/email/${email}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200)         
            var u = JSON.parse(request.responseText);
            atualizaDados(u.username, u.email);
        };
    
    request.send();
}

function atualizaDados(username, email) {

    let nameText = document.createTextNode(username);
    document.getElementById("nomeUsuario").appendChild(nameText);

    let emailText = document.createTextNode(email);
    document.getElementById("emailUsuario").appendChild(emailText);
}
