(function(ng){
    var mod = ng.module('longPlayModule');
    
    mod.service('longPlayService', ['CrudCreator','longPlayContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            
    }]);
})(window.angular);

