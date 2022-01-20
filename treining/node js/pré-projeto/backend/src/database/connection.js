require('dotenv').config();
const { Sequelize } = require('sequelize');

const usuario = require('../model/usuario');

const sequelize = new Sequelize(process.env.DATABASE, process.env.USER, '', {
    host: process.env.HOST,
    dialect: 'mysql',
    define: {
        timestamps: false,
    }
});

const sync = () => {
    usuario.init(sequelize);
    
    sequelize.sync({force: true});
}

module.exports = {
    sequelize,
    sync
}
