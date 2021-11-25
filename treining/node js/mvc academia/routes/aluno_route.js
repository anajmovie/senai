const express = require('express')
const router = express.Router()

const aluno_controll = require('../controll/aluno_controll.js')
router.get('/api/:id', aluno_controll.getId)
router.get('/imc/:id', aluno_controll.imcId)
router.get('/alunos/imc', aluno_controll.imcStatus)

module.exports = router