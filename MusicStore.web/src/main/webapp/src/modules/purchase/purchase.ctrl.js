(function (ng) {
    var mod = ng.module('purchaseModule');

    mod.controller('purchaseCtrl', ['CrudCreator', '$scope', 'purchaseService', 'purchaseModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, $scope, svc,model);
            
            getUserPurchases = function () {
                svc.getUserPurchases().then(function (res) {
                    $scope.purchases = [];
                    $scope.purchases = res;
                });
            };
            $scope.sayHi = function() {
                alert('hi!')
            };
            getUserPurchases();
        }]);
     ng.module('mainApp').directive('ngConfirmClick', [
        function(){
            return {
                priority: 1,
                terminal: true,
                link: function (scope, element, attr) {
                    var msg = attr.ngConfirmClick || "Are you sure?";
                    var clickAction = attr.ngClick;
                    element.bind('click',function (event) {
                        if ( window.confirm(msg) ) {
                            scope.$eval(clickAction)
                        }
                    });
                }
            };
    }]);
})(window.angular);