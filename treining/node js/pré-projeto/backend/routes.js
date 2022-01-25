const express = require('express');
const route = express.Router();

const usuarioController = require('./src/controller/usuarioController');
const alertaController = require('./src/controller/alertaController');
const localizacaoController = require('./src/controller/localizacaoController');

// rotas da tabela usuarios
route.delete('/usuario/:id', usuarioController.remove);
route.put('/usuario/:id', usuarioController.update);
route.post('/usuario', usuarioController.create);
route.get('/usuario', usuarioController.read);
route.get('/usuario/:id', usuarioController.read);

// rotas da tabela alertas
route.delete('/alerta/:id', alertaController.remove);
route.put('/alerta/:id', alertaController.update);
route.post('/alerta', alertaController.create);
route.get('/alerta', alertaController.read);
route.get('/alerta/:id', alertaController.read);

// rotas da tabela localizaçoes
route.delete('/localizacao/:id', localizacaoController.remove);
route.put('/localizacao/:id', localizacaoController.update);
route.post('/localizacao', localizacaoController.create);
route.get('/localizacao', localizacaoController.read);
route.get('/localizacao/:id', localizacaoController.read);

route.post('/login', usuarioController.login);

module.exports = route;