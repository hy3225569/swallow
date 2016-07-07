/* 
* @Author: hy
* @Date:   2016-05-23 14:23:22
*/
'use strict';

require.config({
    paths: {
				'angular' : '/js/angular-1.5.6/angular.min',
				'angular-route' : '/js/angular-1.5.6/angular-route.min',
				'register':'/js/controller/user/registercontroller',
				'login':'/js/controller/user/logincontroller',
				'sweet-alert':'/assets/plugins/sweet-alert/js/sweet-alert.min',
				'ckeditor':'/assets/ckeditor/ckeditor',
				'ckeditordc':'/js/directive/ckeditordc',
				'ngsanitize':'/js/angular-1.5.6/angular-sanitize.min'
    },
    shim: {
    	'angular':{
    		exports:'angular'
    	},
        'app': {
            deps: ['angular', 'angular-route']
        },
        'angular-route': {
            deps: ['angular']
        }
       
    }
});


require
(
    [
        'app','register','login'
    ],
    function(app)
    {
        angular.bootstrap(document, ['app']);
    }
);