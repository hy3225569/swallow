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
            }
        }
    };
});