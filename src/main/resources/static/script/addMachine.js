const buttonPrensa = document.getElementById("button-prensa");
const buttonTorno = document.getElementById("button-torno");

buttonPrensa.addEventListener("click", async function(event) {
    event.preventDefault();

    selectMachine(2);
});


buttonTorno.addEventListener("click", async function(event) {
    event.preventDefault();

    selectMachine(1);
});

function selectMachine(idMachine) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/machine/public/${idMachine}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200)         
            console.log(JSON.parse(request.responseText));
        };

    request.send();
}

function addMachine(name, model, produceList, currentProduceId) {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/user', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

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