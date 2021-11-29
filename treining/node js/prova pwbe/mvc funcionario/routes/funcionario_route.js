const express = require('express')
const router = express.Router()

const funcionario_controll = require('../controll/funcionario_controll.js')
router.get('/funcionario/allfunc', funcionario_controll.getFunc)
router.get('/funcionario/matclFunc/:matricula', funcionario_controll.getMatcl)
router.post('/funcionario/createFunc', funcionario_controll.createFunc)
router.delete('/funcionario/delFunc/:matricula', funcionario_controll.delFunc)
router.put('/funcionario/updFunc', funcionario_controll.updFunc)
router.get('/funcionario/irrfStatus', funcionario_controll.irrfStatus)

module.exports = router
