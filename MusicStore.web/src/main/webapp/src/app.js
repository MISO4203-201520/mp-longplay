(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'xeditable',
        'authModule',
        'albumModule',
        'cartItemModule',
        'clientModule',
        'longPlayModule',
        'providerModule',
        'ngRoute',
        'ngCrud',
        'ngCookies'
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
                    .when('/catalog', {
                        templateUrl: 'src/modules/longPlay/catalog.tpl.html',
                        controller: 'catalogCtrl',
                        controllerAs: alias
                    })
                    .when('/shoppingCart', {
                        templateUrl: 'src/modules/cartItem/shoppingCart.tpl.html',
                        controller: 'cartItemCtrl',
                        controllerAs: alias
                    })
                    .when('/longPlay', {
                        templateUrl: tplUrl,
                        controller: 'longPlayCtrl',
                        controllerAs: alias
                    })
                    .otherwise('/catalog');
        }]);

    mainApp.config(['authServiceProvider', function (auth) {
            auth.setValues({
                apiUrl: 'users',
                successPath: '/catalog',
                loginPath: '/login',
                registerPath: '/register',
                logoutRedirect: '/login',
                loginURL: 'login',
                registerURL: 'register',
                logoutURL: 'logout',
                nameCookie: 'userCookie'
            });
//            auth.setRoles({'user': 'Client', 'provider': 'Provider'});
        }]);

    mainApp.run(function (editableOptions) {
        editableOptions.theme = 'bs3'; // bootstrap3 theme. For Xeditable plugin Angular
    });
})(window.angular);
