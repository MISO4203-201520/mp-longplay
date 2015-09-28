(function (ng) {
    var mod = ng.module('purchaseModule');

    mod.service('purchaseService', ['CrudCreator', 'purchaseContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);

            this.getUserPurchases = function(){
                return this.api.one("mine").get();
            };
            
        }]);
})(window.angular);
