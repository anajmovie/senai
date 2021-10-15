var body = document.querySelector("body");
var list = document.querySelector(".list");
var card = document.querySelector(".card");

fetch("https://api.magicthegathering.io/v1/cards")
.then((response) => {
    return response.json();
})
.then((obj) => {
    obj.cards.forEach(element => {
        let card = document.createElement("div");
        card.className = "card";

        let nome = document.createElement("h2");
        nome.innerHTML = element.name;

        let tipo = document.createElement("h2");
        tipo.innerHTML = element.type;

        let cor = document.createElement("h2");
        cor.innerHTML = element.colors;

        card.appendChild(nome);
        card.appendChild(tipo);
        card.appendChild(cor);
        list.appendChild(card);

    });
})
.catch((err) => {
    console.log(err);
});