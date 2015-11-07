(function(ng){
    var mod = ng.module('albumModule');
    
    mod.service('albumService', ['CrudCreator','albumContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            
            this.getTopSellerAlbums = function(){
                return this.api.one("sellers").get();
            };
            
    }]);
})(window.angular);
