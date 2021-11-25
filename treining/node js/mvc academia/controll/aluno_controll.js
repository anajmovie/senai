const { con } = require("./mysql_controll.js")
const model = require('../model/aluno_model.js')
// função de resposta
const getId = (req, res) => {
    let string = 'select * from alunos where id = '+ req.params.id;
    con.query(string, (err, result) => {
        res.json(result);
    })
}

const imcId = (req, res) => {
    let string = 'select * from alunos where id = '+ req.params.id
    con.query(string, (err, result) => {
        res.json(model.imcModel(
            result[0].id,
            result[0].nome,
            result[0].peso,
            result[0].altura,
            result[0].nascimento
        ))
    })
}

const imcStatus = (req, res) => {
    let string = 'select * from alunos'
    con.query(string, (err, result) => {
        let array = []
        result.forEach(e => {
            array.push(model.imcCalc(e.nome, e.peso, e.altura))  
        })
        res.json(array)
    }) 
}

module.exports = {
    getId,
    imcId,
    imcStatus
}