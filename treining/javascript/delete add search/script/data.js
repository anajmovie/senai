var tablebody = document.querySelector("#tablebody");

function cadastrar() {
    let aluno = document.querySelector("#nome").value;
    let identidade = document.querySelector("#identidade").value;
    let turma = document.querySelector("#turma").value;

    let data = [aluno, identidade, turma];
    let row = document.createElement("tr");

    for(let i = 0; i < 3; i++){
        let col = document.createElement("td");
        col.innerHTML = data[i];
        row.appendChild(col);
    }
    tablebody.appendChild(row);
}

function apagar() {
    let deletar = document.querySelector("#deletar");

    let rows = document.querySelectorAll("tr");
    for(let i = 0; i < rows.length; i++){
        let cols = rows[i].querySelectorAll("td")[0];
        if(cols !== undefined){
            if(cols.innerHTML.toLowerCase() === deletar.value){
                cols.parentNode.remove();
                break;
            }
        }
    }
}

function buscar() {
    let valor = document.querySelector("#buscar").value.toLowerCase();
    
    let rows = document.querySelectorAll("tr");
    for(let i = 0; i < rows.length; i++) {
        if(rows[i].innerHTML.toString().toLowerCase().includes(valor)){
            rows[i].style.display = "table-row";
        }else{
            rows[i].style.display = "none";
        }
    }
}