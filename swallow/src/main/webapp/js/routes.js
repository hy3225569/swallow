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
            '/article/:articleId': {
                templateUrl: '/template/article.html',
                dependencies: [
                          'controller/myspace/articlecontroller'
                ]
            },
            '/articlelist': {
                templateUrl: '/template/articlelist.html',
                dependencies: [
                          'controller/myspace/articlecontroller'
                ]
            },
            '/writeblog': {
                templateUrl: '/template/writeblog.html',
                dependencies: [
                       'controller/myspace/articlecontroller'
                ]
            },
            '/mymainpage': {
                templateUrl: '/template/mymainpage.html',
                dependencies: [
                       'controller/main/maincontroller'
                ]
            }
        }
    };
});