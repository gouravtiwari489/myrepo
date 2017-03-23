var myRouteApp = angular.module("Demo", [ "ngRoute" ]).config(
		function($routeProvider) {
			$routeProvider.when("/home", {
				templateUrl : "html/home.html"
			}).when("/deactivation", {
				templateUrl : "html/deactivation.html"
			}).when("/profile", {
				templateUrl : "html/profile.html",
				controller : "profileCtrl"
			}).when("/register", {
				templateUrl : "html/register.html",
				controller : "registerCtrl"
			})
		})

myRouteApp.controller("registerCtrl", function($scope, $http) {
	
	$http.get('resources/spring/search').then(function(response){
		var employee = {
				name:"",
				age: "",
				gender:""
			}
		employee.name = response.data[0].name;
		employee.age = response.data[0].age;
		employee.gender = response.data[0].gender;
		$scope.employee =  employee;
		console.log('employee'+employee);
	});
});


/*myRouteApp.controller("profileCtrl", function($scope, CardService) {
	$scope.myFunc = function(){
		alert("called");
		CardService.AddCardToDB($scope.CardDetail)
	}
})
.factory("CardService", ['$http', function($http){
	
	var fac ={};
	
	fac.AddCardToDB = function(CardDetail){
		$http.post("resources/spring/saveCard", CardDetail).success(function(response){
			alert("posted");
		})
	}
	
	return fac;
}])*/



myRouteApp.controller("profileCtrl", function($scope, $http) {
	$scope.myFunc = function(){
		alert("called");
		var CardDetail =  $scope.CardDetail
		
		$http.post("resources/spring/saveCard", CardDetail).success(function(response){
			alert("posted");
		})
	}
})



