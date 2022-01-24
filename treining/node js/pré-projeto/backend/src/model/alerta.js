const { Model, DataTypes } = require('sequelize');

class alerta extends Model {
    static init(datacon) { //variavel que representa os dados do banco
        super.init( // referenciando a classe que esta herdando
            //definindo a tabela
            {
                // definindo as colunas
                tipo: {
                    type: DataTypes.STRING(50),
                    allowNull: false  // nao pode ser nulo
                },
                duracao: {
                    type: DataTypes.INTEGER,
                    allowNull: false
                },
                descricao: {
                    type: DataTypes.STRING(150),
                    allowNull: true
                }
            },
            {
                sequelize: datacon, //dados do banco
                tableName: 'alertas', //nome da tabela
                modelName: 'alerta'
            }
        );
    }

    static associate(models) {
        alerta.hasMany(models.localizacao, { foreignKey: 'id_alerta'});
    }
}

module.exports = alerta;