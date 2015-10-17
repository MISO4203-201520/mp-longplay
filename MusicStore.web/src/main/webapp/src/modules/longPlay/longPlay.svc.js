(function(ng){
    var mod = ng.module('longPlayModule');
    
    mod.service('longPlayService', ['CrudCreator','longPlayContext', 'Restangular', function(CrudCreator, context, restangular){
            CrudCreator.extendService(this, context);
            this.findItem = function(priceMax){
                return this.api.one('cheapest', priceMax).get();
                
            };
            
            this.getProviderPurchases = function(){
                return this.api.one("provider").get();
            };
            
            this.confirmOrderDetail = function(purchase){
                restangular.all('purchases/confirm/'+purchase.id).customPUT(purchase);
            };
            
            this.cancelOrderDetail = function(purchase){
                restangular.all('purchases/cancel/'+purchase.id).customPUT(purchase);
            };
    }]);
})(window.angular);

