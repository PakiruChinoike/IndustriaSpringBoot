//RECEBE UM ID DE USUÁRIO
export function getById(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/user/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            console.log(data.username);
            console.log(data.email);
        } else {
            console.log(`Error: ${request.status}`);
        }
    }

    request.send();
}

//NÃO RECEBE NADA
export function getAll() {
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8081/api/user', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            data.forEach(u => {
                console.log(u.username);
                console.log(u.email);
            });
        } else {
            console.log(`Error: ${request.status}`);
        }
    }

    request.send();
}

//RECEBE UM NOME DE USUÁRIO
export function getByUsernameLike(username) {
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8081/api/user/username', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        username: username
    });

    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            data.forEach(u => {
                console.log(u.username);
                console.log(u.email);
            });
        } else {
            console.log(`Error: ${request.status}`);
        }
    }

    request.send(body);
}

//RECEBE UM EMAIL DE USUÁRIO
export function getByEmail(email) {
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8081/api/user/email', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        email: email
    });

    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            data.forEach(u => {
                console.log(u.username);
                console.log(u.email);
            });
        } else {
            console.log(`Error: ${request.status}`);
        }
    }

    request.send(body);
}

//RECEBE UM CORPO DE USUÁRIO
export function postUser() {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/user', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        username: "babagee",
        email: "fornai",
        password: "eksboks"
    });

    request.onload = () => {
        if (request.status >= 200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send(body);
}

//RECEBE UM CORPO DE USUÁRIO E UM ID DE USUÁRIO
export function updateUser(id) {
    var request = new XMLHttpRequest();
    request.open('POST', `http://localhost:8081/api/user/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        username: "mano",
        email: "mano@email",
        password: "mano123"
    });

    request.onload = () => {
        if(request.status >=200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send(body);
}

//RECEBE UM ID DE USUÁRIO
export function deleteUser(id) {
    var request = new XMLHttpRequest();
    request.open('DELETE', `http://localhost:8081/api/user/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    request.onload = () => {
        if(request.status >=200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send();
}