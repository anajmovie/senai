var table = document.querySelector("#data");

function cadastrar() {
    let carro = document.querySelector("#modelo").value;
    let ano = document.querySelector("#ano").value;
    let preco = document.querySelector("#valor").value;

    let data = [carro, ano, preco];

    let row = document.createElement("tr");
    
    for(let i = 0; i < 3; i++){
        let col = document.createElement("td");
        col.innerHTML = data[i];

        row.appendChild(col);
    }
    table.appendChild(row);
}
