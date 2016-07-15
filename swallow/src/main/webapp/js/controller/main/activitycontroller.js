define(["app"],function(app){

            app.controller('activitycontroller',function($scope,$http,$route){
            	 $http.get('/activity/friendarticle').success(function(data) {
			         $scope.friendArticlelist = data.data;
		      }).error(function(e) {
			          console.log(e);
		      }); 
            	 
            	 $http.get('/activity/friendState').success(function(data) {
			         $scope.friendStatelist = data.data;
		      }).error(function(e) {
			          console.log(e);
		      }); 
            	 
            	 $scope.updateStatus=function(){
             		var json= JSON.stringify($scope.status);
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
            	 
            	 $scope.writeStateComment=function(state){
              		$http.post("/activity/writecomment",{data:'{"actionId":"'+state.stateId+'","commentContent":"'+state.stateComment+'"}'}).success(function(data){
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
            	 
            	 $scope.writeArticleComment=function(article){
               		$http.post("/activity/writecomment",{data:'{"actionId":"'+article.articleId+'","commentContent":"'+article.articleComment+'"}'}).success(function(data){
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