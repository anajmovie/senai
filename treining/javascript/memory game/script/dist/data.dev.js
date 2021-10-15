"use strict";

var _this = void 0;

var buttons = document.querySelectorAll("button");
var body = document.querySelector("body");
var tent = document.createElement("h2");
var acerto = document.createElement("h2");
var erro = document.createElement("h2");
var tentativas = 0;
var acertos = 0;
var erros = 0;
var vira = 0;
var ultima = "";
var check = false; //var cores = ["red", "green", "blue"];

var images = [{
  "image": "url(assets/html.png)",
  "conta": 0
}, {
  "image": "url(assets/css.png)",
  "conta": 0
}, {
  "image": "url(assets/javasc.png)",
  "conta": 0
}, {
  "image": "url(assets/python.png)",
  "conta": 0
}, {
  "image": "url(assets/java.png)",
  "conta": 0
}, {
  "image": "url(assets/postgre.png)",
  "conta": 0
}];
buttons.forEach(function (bt) {
  bt.style.borderRadius = "10px";
  /*bt.style.border = ".5px solid #9a8c98";*/

  var repete = true;

  while (repete) {
    var rand = Math.floor(Math.random() * 6); //floor arredonda os numeros

    if (images[rand].conta < 2) {
      //bt.style.background = cores[rand].cor;
      bt.className = rand; //o nome da classe dos botoes são os numeros aleatorios 

      images[rand].conta++;
      repete = false;
    }
  }

  bt.addEventListener("click", function () {
    var indice = Number(bt.className);

    if (vira < 2) {
      bt.style.background = images[indice].image; //quando executar o clique, vai capturar e revelar as imagens 

      bt.style.backgroundSize = "130px 130px";
      bt.style.border = ".5px solid gray";
      vira++;
      if (vira === 1) ultima = bt;
      if (vira === 2) check = true; //verificando se as cartas são iguais ou diferentes
    }

    if (vira >= 2) {
      if (ultima.className === bt.className) {
        ultima.disabled = true;
        bt.disabled = true;
        vira = 0;
        acertos++;
        acerto.innerHTML = "Acertos: " + acertos;
      } else {
        setTimeout(function () {
          //tempo de execução, delay (2000 milisegundos)
          ultima.style.background = "#4a4e69"; //desvirando a carta e voltando a cor inicial

          ultima.style.border = ".5px solid #9a8c98";
          bt.style.background = "#4a4e69";
          bt.style.border = ".5px solid #9a8c98";
          vira = 0;
        }, 2000); //após 3 segundos as cartas vão virar novamente se forem diferentes

        erros++;
        erro.innerHTML = "Erros: " + erros;
      }

      check = false; //após a verificação, volta a ser false

      tentativas++;
      tent.innerHTML = "Tentativas: " + tentativas;
    } //se acertar tudo vai zerar o placar


    if (acertos == 6) {
      alert("Parabéns! Você venceu o jogo");

      _this.limpar();

      location.reload();
    }
  });
});
tent.innerHTML = "Tentativas: " + tentativas;
tent.style.fontFamily = "arial";
tent.style.marginTop = "100px";
tent.style.marginLeft = "100px";
body.appendChild(tent);
acerto.innerHTML = "Acertos: " + acertos;
acerto.style.fontFamily = "arial";
acerto.style.marginTop = "10px";
acerto.style.marginLeft = "100px";
body.appendChild(acerto);
erro.innerHTML = "Erros: " + erros;
erro.style.fontFamily = "arial";
erro.style.marginTop = "10px";
erro.style.marginLeft = "100px";
body.appendChild(erro); //zerando placar

function limpar() {
  tentativas = 0;
  acertos = 0;
  erros = 0;
  tent.innerHTML = "Tentativas: " + tentativas;
  acerto.innerHTML = "Acertos: " + acertos;
  erro.innerHTML = "Erros: " + erros;
}