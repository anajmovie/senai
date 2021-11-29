const { con } = require('./mysql_controll.js')
const model = require('../model/funcionario_model.js'); 

// lendo todos
const getFunc = (req, res) => {
    let string = 'select * from funcionarios'
    con.query(string, (err, result) => {
        res.json(result)
    })
}

// lendo apenas por matricula
const getMatcl = (req, res) => {
    let string = 'select * from funcionarios where matricula = '+ req.params.matricula
    con.query(string, (err, result) => {
        res.json(result)
    })
}

// criando um novo funcionario
const createFunc = (req, res) => {
    let matricula = '\''+req.body.matricula+'\''
    let nome_completo = '\''+req.body.nome_completo+'\''
    let data_desligamento = req.body.data_desligamento
    let ultimo_salario = req.body.ultimo_salario
    let string = `insert into funcionarios (matricula, nome_completo, data_desligamento, ultimo_salario) values ( ${matricula}, ${nome_completo}, ${data_desligamento}, ${ultimo_salario})`
    con.query(string, (err, result) => {
        if(err != null){
            res.status(400).end()   //se obter um erro nos retorna o status 400
        }else{
            res.status(200).end()
        }
    })
}

// deletando por matricula
const delFunc = (req, res) => {
    let string = 'delete from funcionarios where matricula = '+ req.params.matricula
    con.query(string, (err, result) => {
        if(result.affectedRows == 0){      // se nãõ houver a exclusão da linha no banco, nos retorna o erro 400 
            res.status(400).end()
        }else{
            res.status(200).end()
        }
    })
}

// alterando por matricula
const updFunc = (req, res) => {
    let nome_completo = '\''+req.body.nome_completo+'\''
    let data_desligamento = req.body.data_desligamento
    let ultimo_salario = req.body.ultimo_salario
    let matricula = '\''+req.body.matricula+'\''
    let string = `update funcionarios set nome_completo = ${nome_completo}, data_desligamento = ${data_desligamento}, ultimo_salario = ${ultimo_salario} where matricula = ${matricula}`
    con.query(string, (err, result) => {
        if(result.affectedRows == 1){       // se caso a alteração da linha der certo, vai nos retornar um select da linha ja alterada no formato json
            con.query('select * from funcionarios where matricula = '+ matricula, (err, result) => {
                res.json(result)
            })
        }else {
            res.status(400).end()           // se não, nos retorna o status de erro 400
        }
    })
}

const irrfStatus = (req, res) => {
    let string = 'select * from funcionarios'
    con.query(string, (err, result) => {
        let array = []
        result.forEach(e => {
            array.push(model.irrfModel(e.matricula, e.nome_completo, e.data_desligamento, e.ultimo_salario))
        })
        res.json(array)
    })
}

module.exports = {
    getFunc,
    getMatcl,
    createFunc,
    delFunc,
    updFunc,
    irrfStatus
}