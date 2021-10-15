function exerc2() {
    var numeros = [5, 13, 8, 47, 2, 4, 28, 30, 12, 21];
    var i = 0;
    var somapar = 0;
    var somaimpar = 0;
    var contpar = 0;
    var contimpar = 0;
    while(i != numeros.length){
        if(numeros[i]%2 == 1){
            contimpar++;
            somaimpar+=numeros[i];
        }else {
            contpar++;
            somapar+=numeros[i];
        }
        i++;
    }
    console.log("soma dos pares " + somapar + " quantidade pares " + contpar);
    console.log("soma dos impares " + somaimpar + " quantidade impares " + contimpar);
}

    