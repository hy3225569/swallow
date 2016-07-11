define(["app","sweet-alert"],function(app){

            app.controller('maincontroller',function($scope,$http,$route){
            	$scope.updateStatus=function(){
            		var json= JSON.stringify($scope.state);
            		$http.post("/space/writestate",{data:json}).success(function(data){
            	    	if(data.httpStatus==0)
            	    	{
            	    		sweetAlert("",data.message,"success");
            	    		$route.reload();
            	    	}
            	    	else{
            	    		sweetAlert("",data.message,"error");
            	    		$route.reload();
            	    	}
            	    
            		}).error(function(){
            			sweetAlert("","请求失败","error");
            		});
            	}
            	    /**
            	     * 获取朋友
            	     */
            		$http.post("/main/friendlist").success(function(data){
            			$scope.friendList=data.data;
            		}).error(function(e){
            			 console.log(e);
            		});
            		/**
            		 * 获取我的主页用户信息
            		 */
            		$http.get("/user/mypageuserinfo").success(function(data){
            			$scope.userinfo=data;
            		}).error(function(e){
            			 console.log(e);
            		});
            		 $http.get('/space/statelogin').success(function(data) {
    			         $scope.statelist = data.data;
    		      }).error(function(e) {
    			          console.log(e);
    		      });  
            });
});