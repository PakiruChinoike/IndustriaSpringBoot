getAll();
localStorage.removeItem("usuario")
console.log(localStorage.getItem("usuario"))

function getByUserEmail(email) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/machine/public/email/${email}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200)         
            console.log(JSON.parse(request.responseText)); 
        };
    
    request.send();
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