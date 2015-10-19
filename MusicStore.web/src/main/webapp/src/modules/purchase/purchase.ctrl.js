(function(ng) {
    var mod = ng.module('purchaseModule');

    mod.controller('purchaseCtrl', ['CrudCreator', '$scope', 'purchaseService', 'purchaseModel', function(CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, $scope, svc, model);

            var getUserPurchases = function() {
                svc.getUserPurchases().then(function(res) {
                    $scope.purchases = [];
                    $scope.purchases = res;
                });
            };

            getUserPurchases();
        }]);
})(window.angular);