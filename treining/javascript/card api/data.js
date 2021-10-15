var body = document.querySelector("body");
var lista = document.querySelector(".lista");

function loadData(e){
    let file = e.files[0];

    let fr = new FileReader();
    fr.onload = () => {
        let data = JSON.parse(fr.result);
        generateHTML(data);
    }

    fr.readAsText(file);
}

function generateHTML(data) {
    for(let i = 0; i < data.length; i++){
        let card = document.createElement("div");
        card.className = "card";

        let capa = document.createElement("img");
        capa.src = data[i].capa;
        capa.style.width = "100px";

        let titulo = document.createElement("h2");
        titulo.innerHTML = data[i].titulo;

        let autor = document.createElement("h2");
        autor.innerHTML = data[i].autor;

        let paginas = document.createElement("h2");
        paginas.innerHTML = data[i].paginas;

        let ano = document.createElement("h2");
        ano.innerHTML = data[i].ano;

        card.appendChild(capa);
        card.appendChild(titulo);
        card.appendChild(autor);
        card.appendChild(paginas);
        card.appendChild(ano);
        lista.appendChild(card);
    }
}

function buscar(){
    let search = document.querySelector("#search").value;

    
}