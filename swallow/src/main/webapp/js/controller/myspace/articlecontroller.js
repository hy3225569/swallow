define(["app","sweet-alert","ckeditor","ckeditordc"],function(app){

            app.controller('articlecontroller',function($scope,$http){
            	$scope.save=function(){
            		var json= JSON.stringify($scope.article);
            		$http.post("/space/writearticle",{data:json}).success(function(data){
            	    	if(data.httpStatus==0)
            	    	{
            	    		sweetAlert("",data.message,"success");
            	    	}
            	    	else{
            	    		sweetAlert("",data.message,"error");
            	    	}
            	    
            		}).error(function(){
            			sweetAlert("","请求失败","error");
            		});
            	}
		     $http.get('/space/articlelist').success(function(data) {
			         $scope.articlelist = data;
		      }).error(function(e) {
			          console.log(e);
		      });  
            });
});