const usuario  = require('../model/usuario');

const create = (req, res) => {
    const data = req.body;
    const ret = sequelize.create(data);
    res.json(ret);
}

const read = (req, res) => {
    const ret = usuario.findAll();
    res.json(ret);
}

module.exports = {
    create,
    read,
}