const formCadastro = document.getElementById('formCadastro');

formCadastro.addEventListener('submit', async function(event){
    event.preventDefault();

    const formData = new FormData(formCadastro);

    try{
        const response = await fetch ('localhost:8081/api/user',{
            method: 'POST',
            body: formData
        });

        if(response.ok){
            alert('Cadastro realizado com sucesso!');
            window.location.href = 'index.html';
        }
        else{
            const data = await response.json();
            alert('Erro ao cadastrar:' +data.error);
        }
    }
    catch (error){
        alert('Erro ao enviar requisição: ' + error.message);
    }
});