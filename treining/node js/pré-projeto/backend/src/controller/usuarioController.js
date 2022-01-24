const usuario  = require('../model/usuario');

const create = async (req, res) => {
    const data = req.body;
    const ret = await usuario.create(data);
    res.json(ret);
}

const read = async (req, res) => {
    let filtro = {};
    let id = req.params.id;
    if(id != undefined) filtro = { where: { id: id }}

    const ret = await usuario.findAll(filtro);
    res.json(ret);
}

const update = async (req, res) => {
    const id = req.params.id;
    const data = req.body;
    
    let ret = await usuario.update(data, {
        where: { id: id }
    })

    ret = await usuario.findAll({
        where: { id: id }
    })

    res.json(ret);
}

const remove = async (req, res) => {
    const id = req.params.id;
    const ret = await usuario.destroy({
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