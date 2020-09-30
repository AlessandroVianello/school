'use strict';

const post = require ('../models/post')

exports.savePost = (title,content) =>
    new Promise ((resolve,reject)=>{
        const newPost = new post({

          title : title,
          content : content

        });

        newPost.save()
        .then(() => resolve({ status: 201, message: 'Post Saved Sucessfully !' }))

    		.catch(err => {

    			if (err.code == 11000) {

    				reject({ status: 409, message: 'Post Already Saved !' });

    			} else {

    				reject({ status: 500, message: 'Internal Server Error !' });
    			}
        });
  });
