//RECEBE UM ID DE PRODUTO
export function getById(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/produce/${id}`, true);
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

//RECEBE UM ID DE MÁQUINA
export function getByMachine(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/produce/machine/${id}`, true);
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

//RECEBE UM CORPO DE PRODUTO
export function postProduce() {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/produce', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        machineId: 1,
        name: "name",
        xLength: 4,
        zLength: 4, 
        yLength: 5
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
export function updateProduce(id) {
    var request = new XMLHttpRequest();
    request.open('POST', `http://localhost:8081/api/produce/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        machineId: 2,
        name: "nameUpdate",
        xLength: 2,
        zLength: 2, 
        yLength: 3
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
    request.open('DELETE', `http://localhost:8081/api/produce/${id}`, true);
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

//RECEBE UM CORPO DE PRODUTO E UM ID DE MÁQUINA
export function matchProduce(id) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/produce/match/${id}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    var body = JSON.stringify({
        machineId: 2,
        name: "nameUpdate",
        xLength: 2,
        zLength: 2, 
        yLength: 3
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