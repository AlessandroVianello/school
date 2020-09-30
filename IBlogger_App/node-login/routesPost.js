'use strict';
const auth = require('basic-auth');
const jwt = require('jsonwebtoken');

const xpost = require('./functions/post');
const xgetPost = require('./functions/getPost')
const config = require('./config/config.json');

module.exports = router2 => {

	router2.get('/', (req, res) => res.end('Welcome to ....... nothing2'));

	router2.post('/posts', (req, res) => {
		const title = req.body.title;
		const content = req.body.content;

		xpost.savePost(title,content)

		.then(result => {

			res.setHeader('Location','/posts/'+title);
			res.status(result.status).json({ message: result.message })
		})

		.catch(err => res.status(err.status).json({ message: err.message }));

	});

  router2.get('/posts', (req,res) => {

			xgetPost.getPost(req.params.id)
			.then(result => res.json(result))
			.catch(err => res.status(err.status).json({ message: err.message }));

	});
}
