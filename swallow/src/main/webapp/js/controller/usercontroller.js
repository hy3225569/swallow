/* 
* @Author: hy
* @Date:   2016-05-23 14:23:22
*/

define(["app"],function(app){

            app.controller('usercontroller',function($scope,$http){
            	 $http.get('/user/userlist')  
                 .success(function (data) {  
                	  $scope.userlist=data;
                 })  
                 .error(function (e) {  
                     console.log(e); 
                 });  
             
            });
});