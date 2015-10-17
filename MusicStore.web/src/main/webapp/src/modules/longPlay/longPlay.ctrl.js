(function (ng) {
    var mod = ng.module('longPlayModule');

    mod.controller('longPlayCtrl', ['CrudCreator', '$scope', 'longPlayService', 'longPlayModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'longPlay', 'LongPlay');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
    
    mod.controller('provPurchaseCtrl', ['CrudCreator', '$scope', 'longPlayService', 'longPlayModel', function (CrudCreator, $scope, svc, model) {
        CrudCreator.extendController(this, $scope, svc,model);
        getProviderPurchases = function () {
            svc.getProviderPurchases().then(function (res) {
                $scope.purchases = [];
                $scope.purchases = res;
            });
        };
        $scope.tmpOrderDetail;
        $scope.selectOrderDetail = function(purchase){
            $scope.tmpOrderDetail=purchase;
        };
        $scope.confirmOrderDetail = function(){
            console.log('confirmDetail');
            $scope.tmpOrderDetail.isConfirm=true;
            svc.confirmOrderDetail($scope.tmpOrderDetail);
            $scope.tmpOrderDetail='';
        };
        $scope.cancelOrderDetail = function(){
            console.log('cancelDetail');
            $scope.tmpOrderDetail.isConfirm=false;
            svc.cancelOrderDetail($scope.tmpOrderDetail);
            $scope.tmpOrderDetail='';
        };
        getProviderPurchases();
    }]);
    })(window.angular);