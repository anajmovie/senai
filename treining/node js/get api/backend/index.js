// importações
const express = require('express');
const app = express();
const  cors = require('cors');
const mysql = require('mysql');

// conexão com o banco de dados
const con = mysql.createConnection({
    database:'academia',
    host:'localhost',
    user:'root'
});

// iniciador de dependencias
app.use(cors())
app.use(express.json())

// rota ( get )
app.get('/api/', (req, res) => {
    let string = 'select * from alunos;';
    con.query(string, (err, result) => {
        if(err) throw err;
        res.json(result)
    })
})

// rota ( get ) por id
app.get('/id/:id', (req, res) => {
    let string = 'select * from alunos where id = ' + req.params.id;
    con.query(string, (err, result) => {
        if(err) throw err;
        res.json(result)
    })
})

// gerenciando a porta da api
app.listen(3000, () => {
    console.log('Rodando na porta 3000')
})