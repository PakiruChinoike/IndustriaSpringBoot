window.addEventListener("DOMContentLoaded", (e) => {
    const formLogin = document.getElementById("formLogin");

    if (formLogin) {

        formLogin.addEventListener('submit', async function(event){
            event.preventDefault();
    
            const formData = new FormData(formLogin);
    
            var email = formData.get("inputEmail");
            var password = formData.get("inputPassword");

            localStorage.setItem("user", email);

            getByEmail(email, password);
        });
    }
});

function getByEmail(inputEmail, inputPassword) {
    var request = new XMLHttpRequest();
    request.open('GET', `http://localhost:8081/api/user/private/email/${inputEmail}`, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    
    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200)         
            var u = JSON.parse(request.responseText);
            verificarCadastro(inputPassword, u.password);
        };
    
    request.send();
}

function verificarCadastro(inputPassword, userPassword) {
    if (inputPassword===userPassword) {
        window.location.href= "index.html";
    } else {
        alert("Erro ao verificar usuário.");
    }
}