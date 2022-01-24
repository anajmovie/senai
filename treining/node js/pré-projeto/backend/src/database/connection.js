require('dotenv').config();
const { Sequelize } = require('sequelize');

const usuario = require('../model/usuario');
const alerta = require('../model/alerta');
const localizacao = require('../model/localizacao');

// contem os dados da conexao
const sequelize = new Sequelize(process.env.DATABASE, process.env.USER, '', {
    host: process.env.HOST,
    dialect: 'mysql',
    define: {
        timestamps: false,
    }
});

const sync = () => {
    usuario.init(sequelize);
    alerta.init(sequelize);
    localizacao.init(sequelize);
    
    usuario.associate(sequelize.models);
    alerta.associate(sequelize.models);
    localizacao.associate(sequelize.models);

    sequelize.sync({force: true});
}

module.exports = {
    sequelize,
    sync
}
