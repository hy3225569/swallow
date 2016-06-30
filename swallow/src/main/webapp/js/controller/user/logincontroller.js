/**
 * 用户登录
 */
'use strict';
define(["app","sweet-alert"],function(app){
	app.controller('logincontroller',function($scope,$http){
		$scope.login=function(){
			$http({
				url:"/user/userlogin",
				method:'POST',
				params:{"userName":""+$scope.userName+"","userPass":""+$scope.userPass+""}
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
