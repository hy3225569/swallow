define([], function()
{
    return {
        defaultRoutePath: '/',
        routes: {
            '/userInfo': {
                templateUrl: '/template/userManage.html',
                dependencies: [
                          'controller/usercontroller'
                ]
            },
            '/activity': {
                templateUrl: '/template/activity.html',
                dependencies: [
                          'controller/main/activitycontroller'
                ]
            },
            '/myspace': {
                templateUrl: '/template/myspace.html',
                dependencies: [
                          'controller/myspace/spacecontroller'
                ]
            },
            '/article': {
                templateUrl: '/template/article.html',
                dependencies: [
                          'controller/myspace/articlecontroller'
                ]
            },
            '/writeblog': {
                templateUrl: '/template/writeblog.html',
                dependencies: [
                         
                ]
            }
        }
    };
});