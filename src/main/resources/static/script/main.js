const userEmail = localStorage.getItem("user");
getByUserEmail(userEmail);

function getByUserEmail(email) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/machine/public/email/${email}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200)         
            var machines = JSON.parse(request.responseText);
            console.log(machines);
            machines.forEach(m => {
                addUserMachines(m.id, m.name); 
            });
        };
    
    request.send();
}

function addUserMachines(machineId, machineName) {

    let machine = document.createElement("p");
        machine.id = machineId;
        
    let text = document.createTextNode(machineName);
        machine.appendChild(text);

    document.getElementById("maquinadiv").appendChild(machine);

}

function getAll() {
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8081/api/machine/public', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200)         
            console.log(JSON.parse(request.responseText)); 
        };

    request.send();
}