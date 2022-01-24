const localizacao  = require('../model/localizacao');
const usuario = require('../model/usuario');
const alerta = require('../model/alerta');

const create = async (req, res) => {
    const data = req.body;
    const ret = await localizacao.create(data);
    res.json(ret);
}

const read = async (req, res) => {
    let filtro = {};
    let id = req.params.id;
    if(id != undefined) filtro = { where: { id: id }}

    filtro.include = [
        { model: usuario },
        { model: alerta}
    ]

    const ret = await localizacao.findAll(filtro);
    res.json(ret);
}

const update = async (req, res) => {
    const id = req.params.id;
    const data = req.body;
    
    let ret = await localizacao.update(data, {
        where: { id: id }
    })

    ret = await localizacao.findAll({
        where: { id: id }
    })

    res.json(ret);
}

const remove = async (req, res) => {
    const id = req.params.id;
    const ret = await localizacao.destroy({
        where: { id: id }
    })

    if(ret == 1){
        res.json({ id: id })
    }else {
        res.status(400);
    }
}

module.exports = {
    create,
    read,
    update,
    remove
}