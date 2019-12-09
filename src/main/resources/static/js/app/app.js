'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
	'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "https://tie1fnsb31.execute-api.us-east-2.amazonaws.com/Prod/"

	//add your endpoint api here
});