// importações
const cors = require('cors')
const express = require('express')
const router = express.Router()
const app = express()

// iniciador de dependências
app.use(cors())
app.use(express.json())

const func_read = require('./routes/funcionario_route.js')
app.use(func_read)

app.use('/', router)

// gerenciando a porta da api
app.listen(2000, () => {
    console.log('rodando na porta 2000')
})