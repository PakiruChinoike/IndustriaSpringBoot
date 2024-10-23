//RECEBE UM ID DE PRODUTO
export function getById(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/produce/public/${id}`, true);
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

//RECEBE UM ID DE MÁQUINA
export function getByMachine(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/produce/public/machine/${id}`, true);
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

//RECEBE UM CORPO DE PRODUTO
export function postProduce(machineId, name, xLength, zLength, yLength) {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/produce/private', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        machineId: machineId, 
        name: name,
        xLength: xLength,
        zLength: zLength, 
        yLength: yLength
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

//RECEBE UM CORPO DE PRODUTO E UM ID DE PRODUTO
export function updateProduce(id, machineId, name, xLength, zLength, yLength) {
    var request = new XMLHttpRequest();
    request.open('POST', `http://localhost:8081/api/produce/private/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        machineId: machineId,
        name: name,
        xLength: xLength,
        zLength: zLength, 
        yLength: yLength
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

//RECEBE UM ID DE PRODUTO
export function deleteProduce(id) {
    var request = new XMLHttpRequest();
    request.open('DELETE', `http://localhost:8081/api/produce/private/${id}`, true);
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

//RECEBE UM CORPO DE PRODUTO E UM ID DE MÁQUINA
export function matchProduce(id, machineId, name, xLength, zLength, yLength) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/produce/public/match/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        machineId: machineId,
        name: name,
        xLength: xLength,
        zLength: zLength, 
        yLength: yLength
    });

    request.onload = () => {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 400) {
            console.log(data.message);
        } else {
            console.log(`Error: ${request.status}`);
        }
    };

    request.send(body);
}