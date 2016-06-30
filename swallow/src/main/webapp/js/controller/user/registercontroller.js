/**
 * 用户注册控制器
 */
'use strict';
define(["app","sweet-alert"],function(app){
	app.controller('registercontroller',function($scope,$http,$location){
		$scope.register=function(){
			$http({
				url:"/user/userregiste",
				method:'POST',
				params:{"data":'{"userName":"'+$scope.userName+'","userPass":"'+$scope.userPass+'"}'}
			}).success(function(data){
				if(data.httpStatus==0){
					sweetAlert("",data.message, "success");
					window.location.href="/html/masterPage.html";
				}
				else{
					sweetAlert("",data.message, "error");
				}
			}).error(function(){
				sweetAlert("","向服务器请求出现异常", "error");
			});
		}
	});
});

