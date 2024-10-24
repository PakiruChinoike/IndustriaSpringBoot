window.addEventListener("DOMContentLoaded", (e) => {
    const formCadastro = document.getElementById("formCadastro");

    if (formCadastro) {

        formCadastro.addEventListener('submit', async function(event){
            event.preventDefault();
    
            const formData = new FormData(formCadastro);
    
            var username = formData.get("inputName");
            var email = formData.get("inputEmail");
            var password = formData.get("inputPassword");

            var status = postUser(username, email, password);

            console.log(localStorage.getItem("user"));

            console.log(status);

        });
    }
})


function postUser(username, email, password) {
    var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8081/api/user', true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    // request.setRequestHeader('Authorization', + auth);

    var body = JSON.stringify({
        username: username,
        email: email,
        password: password
    });

    request.onload = () => {
        if (request.status >= 200 && request.status < 400) {
            console.log(JSON.parse(request.responseText));
            window.location.href= "index.html";
            localStorage.setItem("user", email);
        } else {
            console.log(`Error: ${request.status}`);
            alert("Erro ao cadastrar usuário.");
            localStorage.setItem("user", email);
        }
    };

    request.onerror = () => {
        alert("Erro ao cadastrar usuário.");
    }

    request.send(body);
};