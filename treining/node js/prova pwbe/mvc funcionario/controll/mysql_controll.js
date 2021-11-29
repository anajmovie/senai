// criando a conexão com o banco de dados
const mysql = require('mysql')
const con = mysql.createConnection({
    'user':'root',
    'database':'funcionario',
    'host':'localhost'
})

// exportando a conexão
module.exports = {
    con
}
