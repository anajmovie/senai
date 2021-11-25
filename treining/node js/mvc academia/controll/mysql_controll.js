// conexão com o banco
const mysql = require('mysql');
const con = mysql.createConnection({
    'user':'root',
    'database':'academia',
    'host':'localhost'
})

// exportando a função
module.exports = {
    con
}