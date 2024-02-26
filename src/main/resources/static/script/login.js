const formLogin = document.getElementById('formLogin');

formLogin.addEventListener('submit', async function(event){
    event.preventDefault();

    const email = document.getElementById('inputEmail').value;
    const password = document.getElementById('inputPassword').value;
    const data = {
        email: email,
        password: password
    };

    try{
        const response = await fetch ('localhost:8081/api/user',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if(response.ok){
            window.location.href = 'index.html';
        }
        else{
            const errorData = await response.json();
            alert('Erro ao logar:' +errorData.message);
        }
    }
    catch (error){
        alert('Erro ao enviar requisição: ' + error.message);
    }
});