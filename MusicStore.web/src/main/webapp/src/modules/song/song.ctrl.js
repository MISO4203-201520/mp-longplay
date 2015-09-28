(function(ng) {
    var mod = ng.module('songModule');

    mod.controller('songCtrl', ['CrudCreator', '$scope', 'songService', 'songModel', function(CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'song', 'Song');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);