'use strict';

const user = require('../models/user');

exports.deleteProfile = (email) =>

	new Promise((resolve,reject) => {

		user.deleteOne({email:email},function(err)
		{
			if(err)return handleError(err);
			console.log('User deleted successfully');
		});

});
