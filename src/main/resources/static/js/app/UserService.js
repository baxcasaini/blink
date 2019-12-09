'use strict'

angular.module('demo.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getUserById = function(userId) {
				var url = CONSTANTS.getUserByIdUrl;
				try {
					$http.get(url);
				}catch(error){
					console.log(error);
				}
				return $http.get(url);
			}
			return service;
		} ]);