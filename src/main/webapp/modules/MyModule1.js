var myApp = angular.module("myModule3",[]);

myApp.controller("myController3", function($scope, $http) {
	
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