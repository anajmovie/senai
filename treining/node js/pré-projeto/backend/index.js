require('dotenv').config();
const Express = require('express');
const connection = require('./src/database/connection');
const route = require('./routes');

const app = Express();

app.use(Express.json())
app.use(route)

app.listen(process.env.APP_PORT, () => {
    console.log("Rodando na porta", process.env.APP_PORT);
    connection.sync();
})
