var container = document.querySelector("#container");
var button = document.querySelector("#button");
var tbody = document.querySelector("#tbody");

function adicionar() {
    let add = document.getElementById("add");
    let ctdiv = document.createElement("div");
    let bt = document.createElement("button");
    let excluir = document.createElement("button");
    let texto = document.createElement("p");
    
 
    button.addEventListener("click", () =>{

            ctdiv.className = "child";
            ctdiv.id = "child";
            ctdiv.style.border = "1px solid #000";
            ctdiv.style.height = "40px";
            ctdiv.style.borderRadius = "8px";
            ctdiv.style.display = "flex";

            texto.innerHTML = add.value;
            texto.style.fontFamily = "arial";
            texto.style.alignItems = "center";

            bt.innerHTML = "feito";
            bt.style.marginLeft = "300px";
            excluir.innerHTML = "apagar";
            excluir.style.marginLeft = "auto";

            tbody.appendChild(ctdiv);
            ctdiv.appendChild(texto);
            container.appendChild(tbody);
            ctdiv.appendChild(bt);
            ctdiv.appendChild(excluir);
    });

}
