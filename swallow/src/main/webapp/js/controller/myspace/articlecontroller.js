define(["app","sweet-alert","ckeditor","ckeditordc","ngsanitize"],function(app){

            app.controller('articlecontroller',['$scope','$http','$sce',function($scope,$http,$sce){
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
		     $http.get('/space/articlelogin').success(function(data) {
			         $scope.articlelist = data.data;
		      }).error(function(e) {
			          console.log(e);
		      });  
		     $http.post('/space/article',{articleId:41}).success(function(data) {
		         $scope.article = (data.data)[0];
		         $scope.htmlstr=$sce.trustAsHtml($scope.article.content);
	          }).error(function(e) {
		          console.log(e);
	           });  
            }]);
});