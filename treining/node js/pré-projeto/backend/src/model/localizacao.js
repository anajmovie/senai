const { Model, DataTypes } = require('sequelize');

class localizacao extends Model {
    static init(datacon) {
        super.init(
            {
                coordenadas: {
                    type: DataTypes.STRING(25),
                    allowNull: false
                },
                id_user: {
                    type: DataTypes.INTEGER,
                    allowNull: false,
                    references: {
                        model: 'usuarios',
                        key: 'id'
                    }
                },
                id_alerta: {
                    type: DataTypes.INTEGER,
                    allowNull: false,
                    references: {
                        model: 'alertas',
                        key: 'id'
                    }
                },
                ativo: {
                    type: DataTypes.BOOLEAN,
                    allowNull: false
                }
            },
            {
                sequelize: datacon,
                tableName: 'localizacoes',
                modelName: 'localizacao'
            }
        );
    }

    static associate(models) {
        localizacao.belongsTo(models.usuario, { foreignKey: 'id_user' }); // a localização pertence ao usuario e a chave vai ser id_use
        localizacao.belongsTo(models.alerta, { foreignKey: 'id_alerta' });
    }
}

module.exports = localizacao;