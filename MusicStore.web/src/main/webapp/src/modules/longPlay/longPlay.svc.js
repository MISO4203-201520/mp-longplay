(function(ng){
    var mod = ng.module('longPlayModule');
    
    mod.service('longPlayService', ['CrudCreator','longPlayContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.findItem = function(priceMax){
                return this.api.one('cheapest', priceMax).get();
                
            };
            
            this.getProviderPurchases = function(){
                return this.api.one("provider").get();
            };
    }]);
})(window.angular);

