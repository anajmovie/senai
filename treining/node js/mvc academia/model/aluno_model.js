const imcModel = (id, nome, peso, altura, nascimento) => {
    let data = (nascimento+'').split('T')
    let json = {
        "id": id,
        "nome": nome,
        "peso": peso,
        "altura": altura,
        "nascimento": data[0],
        "imc": (peso / (altura * altura)).toFixed(2)
      }
      return json
}

const imcCalc = (nome, peso, altura) => {
    let imc = peso / (altura ** 2)
    let json = {
        'nome':nome,
        'peso':peso,
        'altura':altura,
        'imc':imc.toFixed(2)
    }

    if(imc < 18.5){
        json.status = 'abaixo do peso'
    } else if(imc > 18.5 && imc < 25){
        json.status = 'peso normal'
    } else if(imc > 25 && imc < 30){
        json.status = 'sobrepeso'
    } else if(imc > 30 && imc < 35){
        json.status = 'obesidade grau 1'
    } else if(imc > 35 && imc < 40){
        json.status = 'obesidade grau 2'
    } else if(imc > 40){
        json.status = 'obesidade mórbida'
    }
     return json
}

module.exports = {
    imcModel,
    imcCalc
}