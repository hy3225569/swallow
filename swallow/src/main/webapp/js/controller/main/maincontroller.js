define(["app","sweet-alert","checklist"],function(app){

            app.controller('maincontroller',function($scope,$http,$route){
            	//爱好
            	$scope.hobbys = ['旅游', '计算机', '体育', '读书','其他'];
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
            			$route.reload();
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
            			$scope.checked_hobbys = data.hobby.split(',');
            		}).error(function(e){
            			 console.log(e);
            		});
            		
            		 $http.get('/space/statelogin').success(function(data) {
    			         $scope.statelist = data.data;
    		         }).error(function(e) {
    			          console.log(e);
    		      });  
            		 //完善资料
            		   $scope.edit_data=function(){
            			$scope.userinfo.hobby=$scope.checked_hobbys.join(",");
                 		var json= JSON.stringify($scope.userinfo);
                 		$http.post("/main/updateuserinfo",{data:json}).success(function(data){
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
                 			$route.reload();
                 		});
                 	}
            });
});