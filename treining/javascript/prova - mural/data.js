var tipos = document.getElementById("tipos");
var mensagem = document.getElementById("msg");
var links = document.getElementById("link");
var body = document.querySelector("body");

function adicionar(){
    let tipo = tipos.options[tipos.selectedIndex].text;
    let mesg = mensagem.value;
    let lin = links.value;

    let card = document.createElement("div");
    card.className = "card";

    let msggg = document.querySelector(".messages");
    let men = document.createElement("p");
    men.innerHTML = mesg;

    let link = document.createElement("p");
    link.innerHTML = lin;

    card.appendChild(men);
    card.appendChild(link);
    msggg.appendChild(card);

    if(tipo === "Normal"){
        card.style.border = "2px solid blue";
        card.style.background = "#caf0f8";
    }else if(tipo === "Urgente"){
        card.style.border = "2px solid red";
        card.style.background = "#fbc3bc";
    }else if(tipo === "Importante"){
        card.style.border = "2px solid green";
        card.style.background = "#cdeac0";
    }

    card.addEventListener("click", () => {
        card.remove();
    })
}