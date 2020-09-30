'use strict';
const express    = require('express');
const app        = express();
const bodyParser = require('body-parser');
const logger 	   = require('morgan');
const router2 	   = express.Router();
const port 	   = process.env.PORT || 8050;

app.use(bodyParser.json());
app.use(logger('dev'));

require('./routesPost')(router2);
app.use('/api/v1', router2);

app.listen(port);

console.log('App Runs on ${'+port+'}');
