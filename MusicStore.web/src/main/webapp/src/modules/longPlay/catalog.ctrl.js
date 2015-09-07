(function (ng) {
    var mod = ng.module('longPlayModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'longPlayService', 'longPlayModel', 'cartItemService', '$location', 'authService', 'questionService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, questionService) {
            CrudCreator.extendController(this, svc, $scope, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;
            
            $scope.modal = {url : 'src/modules/question/question.tpl.html', data : null, question: ''};

            this.searchByName = function (albumName) {
                var search;
                if (albumName) {
                    search = '?q=' + albumName;
                }
                $location.url('/catalog' + search);
            };
            
            this.registerQuestion = function (){
                var result = false;
                result = questionService.registerQuestion($scope.modal.data, $scope.modal.question);
                if (result){
                    $scope.modal.data = null;
                    $scope.modal.question = '';
                }
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (longPlay) {
                        return cartItemSvc.addItem({
                            longPlay: longPlay,
                            name: longPlay.name,
                            quantity: 1});
                    },
                    show: function () {
                        return true;
                    }
                },
                {
                    name: 'addQuestion',
                    displayName: 'Add Question',
                    icon: 'question-sign',
                    class: 'info',
                    fn: function (record) {
                        $scope.modal.data = record;
                        $scope.modal.question = '';
                        return true;
                    },
                    show: function () {
                        return true;
                    }
                }];

            this.fetchRecords();
        }]);
    
    
})(window.angular);