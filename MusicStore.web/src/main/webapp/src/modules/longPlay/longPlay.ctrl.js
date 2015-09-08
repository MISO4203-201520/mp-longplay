(function (ng) {
    var mod = ng.module('longPlayModule');

    mod.controller('longPlayCtrl', ['CrudCreator', '$scope', 'longPlayService', 'longPlayModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'longPlay', 'LongPlay');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
    })(window.angular);