/* 
* @Author: hy
* @Date:   2016-05-23 14:23:22
*/
'use strict';

require.config({
    paths: {
				'angular' : '/js/angular-1.5.6/angular.min',
				'angular-route' : '/js/angular-1.5.6/angular-route.min',
				'register':'/js/controller/user/registercontroller'
    },
    shim: {
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
        'app'
    ],
    function(app)
    {
        angular.bootstrap(document, ['app']);
    }
);