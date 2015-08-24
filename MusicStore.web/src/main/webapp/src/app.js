(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'albumModule',
        'cartItemModule',
        'clientModule',
        'longPlayModule',
        'providerModule',
        'ngRoute',
        'ngCrud'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                .when('/album', {
                    templateUrl: tplUrl,
                    controller: 'albumCtrl',
                    controllerAs: alias
                })
                .when('/client', {
                    templateUrl: tplUrl,
                    controller: 'clientCtrl',
                    controllerAs: alias
                })
                .when('/provider', {
                    templateUrl: tplUrl,
                    controller: 'providerCtrl',
                    controllerAs: alias
                })
                .otherwise('/');
        }]);
})(window.angular);
