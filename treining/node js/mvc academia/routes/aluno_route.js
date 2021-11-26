const express = require('express')
const router = express.Router()

const aluno_controll = require('../controll/aluno_controll.js')
router.get('/academia/alunos', aluno_controll.getAll)
router.get('/academia/aluno/:id', aluno_controll.getId)
router.get('/academia/imc/:id', aluno_controll.imcId)
router.get('/academia/status', aluno_controll.imcStatus)
router.post('/academia/create', aluno_controll.addAluno)
router.delete('/academia/delete/:id', aluno_controll.delAluno)
router.put('/academia/update', aluno_controll.updAluno)

module.exports = router