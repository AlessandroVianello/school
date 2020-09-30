'use strict';

const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const postSchema = mongoose.Schema({

	title 			: String,
	content			: String,

});

mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/node-login');

module.exports = mongoose.model('post', postSchema);
