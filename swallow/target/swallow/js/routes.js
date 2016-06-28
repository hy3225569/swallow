define([], function()
{
    return {
        defaultRoutePath: '/upload/student/query.htmls',
        routes: {
            '/userInfo': {
                templateUrl: '/swallow/template/userManage.html',
                dependencies: [
                          'controller/usercontroller'
                ]
            }
        }
    };
});