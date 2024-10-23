//RECEBE UM ID DE MÁQUINA
export function getById(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/machine/public/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);
    
    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            console.log(data.name);
        } else {
            console.log(`Error: ${request.status}`);
        }
    }
    
    request.send();
}

//RECEBE UM ID DE USUÁRIO 
export function getByUserId(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/machine/public/user/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);
    
    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            data.forEach(m => {
                console.log(m.name);
            });
        }
    }
    
    request.send();
}

//NÃO RECEBE NADA
export function getAll() {
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8081/api/machine/public', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            data.forEach(m => {
                console.log(m.name);
            });
        }
    }

    request.send();
}

//RECEBE UM CORPO DE MÁQUINA
export function postMachine(name, model, produceList, currentProduceId) {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/machine/private', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        name: name,
        model: model,
        produceList: produceList,
        currentProduceId: currentProduceId
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

//RECEBE UM CORPO DE MÁQUINA E UM ID DE MÁQUINA
export function updateMachine(name, model, produceList, currentProduceId) {
    var request = new XMLHttpRequest();
    request.open('POST', `http://localhost:8081/api/machine/private/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        name: name,
        model: model,
        produceList: produceList,
        currentProduceId: currentProduceId
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

//RECEBE UM ID DE MÁQUINA
export function deleteMachine(id) {
    var request = new XMLHttpRequest();
    request.open('DELETE', `http://localhost:8081/api/machine/private/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    request.onload = () => {
        if (request.status >= 200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send(body);
}

//RECEBE UM ID DE MÁQUINA
export function turnOff(id) {
    var request = new XMLHttpRequest();
    request.open('PUT', `http://localhost:8081/api/machine/public/off/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    request.onload = () => {
        if (request.status >= 200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send();
}

//RECEBE UM ID DE MÁQUINA
export function turnOn(id) {
    var request = new XMLHttpRequest();
    request.open('PUT', `http://localhost:8081/api/machine/public/on/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    request.onload = () => {
        if (request.status >= 200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send();
}

//RECEBE UM CORPO DE MACHINE_INFO E UM ID DE MÁQUINA
export function updateInfo(id) {
    var request = new XMLHttpRequest();
    request.open('PUT', `http://localhost:8081/api/machine/private/info/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        temperature: 30
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

//RECEBE UM CORPO DE MÁQUINA E UM ID DE MÁQUINA
export function updateCurrentProduce(id) {
    var request = new XMLHttpRequest();
    request.open('PUT', `http://localhost:8081/api/machine/public/current/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        currentProduceId: 3
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

//RECEBE UM CORPO DE MÁQUINA E UM ID DE MÁQUINA
export function updateProduceList(id, produceList) {
    var request = new XMLHttpRequest();
    request.open('PUT', `http://localhost:8081/api/public/machine/list/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        produceList: produceList
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
