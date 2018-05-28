const mongoose = require('mongoose');
var uri='mongodb://localhost:27017/node-login';
const Schema = mongoose.Schema;

const userSchema = mongoose.Schema({

	name 			: String,
	email			: String,
	hashed_password	: String,
	created_at		: String,
	temp_password	: String,
	temp_password_time: String

});

mongoose.Promise = global.Promise;
mongoose.createConnection(uri,{server:{poolSize:4}});

module.exports = mongoose.model('user', userSchema);
