const { con } = require("./mysql_controll.js")
const model = require('../model/aluno_model.js')
// função de resposta
const getAll = (req, res) => {
    let string = 'select * from alunos'
    con.query(string, (err, result) => {
        res.json(result)
    })
}
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

const addAluno = (req, res) => {
    let body = req.body
    let string = 'insert into alunos(nome, peso, altura, nascimento) values (\'' + body.nome + '\',' + body.peso + ',' + body.altura + ',\'' + body.nascimento + '\')'
    con.query(string, (err, result) => {
        if(err != null){
            res.status(400).end()
        } else {
            res.status(200).end()
        }
    })
}

const delAluno = (req, res) => {
    let string = 'delete from alunos where id = ' + req.params.id
    con.query(string, (err, result) => {
        if(result.affectedRows == 0){
            res.send(400).end()
        } else {
            res.send(200).end()
        }
    })
}

const updAluno = (req, res) => {
    let nome = '\''+req.body.nome+'\''
    let peso = req.body.peso
    let altura = req.body.altura
    let nascimento = '\''+req.body.nascimento+'\''
    let id = req.body.id
    let string = `update alunos set nome = ${nome}, peso = ${peso}, altura = ${altura}, nascimento = ${nascimento} where id = ${id}`
    con.query(string, (err, result) => {
        if(result.affectedRows == 1){
            con.query('select * from alunos where id = '+id, (err, result) => {
                res.json(result)
            })
        } else{
                res.send(400).end()
        }
    })
}

module.exports = {
    getAll,
    getId,
    imcId,
    imcStatus,
    addAluno,
    delAluno,
    updAluno
}