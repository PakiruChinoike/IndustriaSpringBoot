//RECEBE UM ID DE MÁQUINA
export function getById(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/machine/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    
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

//NÃO RECEBE NADA
export function getAll() {
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8081/api/machine/', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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
export function postMachine() {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/machine', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        name: "name",
        model: "model",
        produceList: [1, 2, 3],
        currentProduceId: 1
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
export function updateMachine(id) {
    var request = new XMLHttpRequest();
    request.open('POST', `http://localhost:8081/api/machine/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        name: "nameUP",
        model: "modelUp",
        produceList: [1, 2, 3, 4],
        currentProduceId: 2
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
    request.open('DELETE', `http://localhost:8081/api/machine/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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
    request.open('PUT', `http://localhost:8081/api/machine/off/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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
    request.open('PUT', `http://localhost:8081/api/machine/on/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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
    request.open('PUT', `http://localhost:8081/api/machine/info/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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
    request.open('PUT', `http://localhost:8081/api/machine/current/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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
export function updateProduceList(id) {
    var request = new XMLHttpRequest();
    request.open('PUT', `http://localhost:8081/api/machine/list/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        produceList: [3, 5, 6]
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
