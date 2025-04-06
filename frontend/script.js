const form = document.querySelector(".formulario");
const botao = document.querySelector(".enviar");

botao.addEventListener('click', async function(event){
    event.preventDefault();

    const pessoa = {
        nome: form.nome.value,
        email: form.email.value,
        idade: form.idade.value
    };

    const response = await fetch("http://localhost:8080/usuarios", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pessoa)
    });

    if(response.ok){
        alert("Usuário cadastrado");
    } else {
        alert("Erro");
    }

});