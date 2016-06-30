/**
 * 用户注册控制器
 */
'use strict';
define(["app"],function(app){
    app.controller('registercontroller',function($scope,$http){
		$scope.register=function(){
			$http({
				url:"/user/userregiste",
				method:'POST',
				data:{data:'{"userName":"test","userPass":"123456"}'}
			}).success(function(data){
				 alert(data.message)		
			}).error(function(){
				
			});
		}
	});
});