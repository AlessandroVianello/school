'use strict';
const post = require('../models/post');

exports.getPost = title =>

	new Promise((resolve,reject) => {

		post.find({ title: title }, { title: 1, content: 1, _id: 0})

		.then(posts => resolve(posts[0]))

		.catch(err => reject({ status: 500, message: 'Internal Server Error !' }))

	});
