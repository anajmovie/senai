var num1 = document.querySelector("#numero1");
var num2 = document.querySelector("#numero2");
var resultado = document.querySelector("#resultado");

function calcularSoma() {
    let calc = Number(num1.value) + Number(num2.value);
    resultado.innerHTML = "Resultado: " + calc;
}

function calcularSub() {
    let calc = Number(num1.value) - Number(num2.value);
    resultado.innerHTML = "Resultado: " + calc;
}

function calcularDiv() {
    let calc = Number(num1.value) / Number(num2.value);
    resultado.innerHTML = "Resultado: " + calc;
}

function calcularMod() {
    let calc = (Number(num2.value) - Number(num1.value)) / (Number(num1.value) * 100);
    let calc2 = calc / (Number(num1.value) * 100);
    let calc3 = calc2 * 100;
    resultado.innerHTML = "Resultado: " + calc3;
}

function calcularMult() {
    let calc = Number(num1.value) * Number(num2.value);
    resultado.innerHTML = "Resultado: " + calc;
}

function calcularExpo() {
    let calc = Number(num1.value) ** Number(num2.value);
    resultado.innerHTML = "Resultado: " + calc;
}