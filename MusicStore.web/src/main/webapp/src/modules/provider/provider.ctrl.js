(function(ng) {
    var mod = ng.module('providerModule');

    mod.controller('providerCtrl', ['CrudCreator', '$scope', 'providerService', 'providerModel', function(CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            this.fetchRecords();
        }]);

    mod.controller('longPlaysCtrl', ['CrudCreator', '$scope', 'longPlayModel', function(CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'longPlays', 'provider');
        }]);
})(window.angular);