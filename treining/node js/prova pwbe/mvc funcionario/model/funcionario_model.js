const irrfModel = (matricula, nome_completo, data_desligamento, ultimo_salario) => {
    let json = {
        "matricula": matricula,
        "nome_completo": nome_completo,
        "data_desligamento": data_desligamento,
        "ultimo_salario": ultimo_salario,
    }


    if(ultimo_salario < 1980.90){
        json.aliquota = 'isento'

    }else if(ultimo_salario > 1980.90 && ultimo_salario < 2940.85){
        json.aliquota = '7.5%'
        let taxa = 142.8
        let aliq = (ultimo_salario * 7.5) / 100
        let irrf = aliq - taxa
        json.irrf = irrf.toFixed(2)

    }else if(ultimo_salario > 2940.85 && ultimo_salario < 3902.59){
        json.aliquota = '15%'
        let taxa = 354.8
        let aliq = (ultimo_salario * 15) / 100
        let irrf = aliq - taxa
        json.irrf = irrf.toFixed(2)

    }else if(ultimo_salario > 3902.59 && ultimo_salario < 4853.13){
        json.aliquota = '22.5%'
        let taxa = 636.13
        let aliq = (ultimo_salario * 22.5) / 100
        let irrf = aliq - taxa
        json.irrf = irrf.toFixed(2)

    }else{
        json.aliquota = '27.5%'
        let taxa = 869.36
        let aliq = (ultimo_salario * 27.5) / 100
        let irrf = aliq - taxa
        json.irrf = irrf.toFixed(2)
    }
    return json
}

module.exports = {
    irrfModel
}