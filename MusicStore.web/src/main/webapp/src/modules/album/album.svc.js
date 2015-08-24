(function(ng){
    var mod = ng.module('albumModule');
    
    mod.service('albumService', ['CrudCreator','albumContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
