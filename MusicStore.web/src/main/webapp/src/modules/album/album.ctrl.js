(function (ng) {
    var mod = ng.module('albumModule');

    mod.controller('albumCtrl', ['CrudCreator', '$scope', 'albumService', 'albumModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'album', 'Album');
            this.asGallery = true;
            this.fetchRecords();
        }]);
})(window.angular);
