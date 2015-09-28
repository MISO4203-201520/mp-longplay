(function(ng) {
    var mod = ng.module('songModule');

    mod.service('songService', ['CrudCreator', 'songContext', function(CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
})(window.angular);