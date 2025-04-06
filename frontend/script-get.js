document.addEventListener("DOMContentLoaded", async function(){

    const tabela = document.querySelector(".tabela");

    const response = await fetch("http://localhost:8080/usuarios", {
        method: "GET"
    });

    const usuarios = await response.json();
    
    for (let index = 0; index < usuarios.length; index++) {
        let linha = document.createElement("tr");

        linha.innerHTML = `
            <td>${usuarios[index].nome}</td>
            <td>${usuarios[index].email}</td>
            <td>${usuarios[index].idade}</td>
        `;
        
        tabela.appendChild(linha);
    }

});

