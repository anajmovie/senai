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
    this.cancelar();

    let msg = "";
    if(data[0] == "") {
        msg += "- Informe o nome do aluno \n";
    }

    if(data[1] == "") {
        msg += "- Informe o documento do aluno \n";
    }

    if(data[2] == "") {
        msg += "- Informe a turma do aluno \n";
    }

    if(msg != "") {
        alert(msg);
        return false;
    }
    return true;
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

function cancelar() {
    document.getElementById("nome").value = "";
    document.getElementById("identidade").value = "";
    document.getElementById("turma").value = "";
}