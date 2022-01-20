const express = require('express');
const route = express.Router();

const usuarioController = require('./src/controller/usuarioController');

route.post('/usuario', usuarioController.create);
route.get('/usuario', usuarioController.read);

module.exports = route;