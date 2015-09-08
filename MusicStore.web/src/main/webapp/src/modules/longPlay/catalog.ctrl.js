(function (ng) {
    var mod = ng.module('longPlayModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'longPlayService', 'longPlayModel', 'cartItemService', '$location', 'commentService', 'authService', 'questionService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, commentService, authSvc, questionService) {
            CrudCreator.extendController(this, svc, $scope, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;
            this.detailsMode = false;
            this.myTextArea = "";
            var self = this;

            $scope.modal = {url: 'src/modules/question/question.tpl.html', data: null, question: ''};

            this.searchByName = function (albumName) {
                var search;
                if (albumName) {
                    search = '?q=' + albumName;
                }
                $location.url('/catalog' + search);
            };

            this.registerQuestion = function () {
                var result = false;
                result = questionService.registerQuestion($scope.modal.data, $scope.modal.question);
                if (result) {
                    $scope.modal.data = null;
                    $scope.modal.question = '';
                }
            };
            this.addComment = function (record) {
                var comment = "";
                var x = document.getElementsByClassName("textArea");
                var i;
                

                for (i = 0; i < x.length; i++) {
                    comment = x[i].value;
                }
                if (comment.trim().length == 0) {
                    alert("El comentario esta vacío.");
                }
                else {
                    commentService.createComment(record, comment);
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
                },
                {
                    name: 'comments',
                    displayName: 'Comments',
                    icon: 'list',
                    class: 'info',
                    fn: function (record) {
                        svc.api.get(record.id).then(function (data) {
                            self.detailsMode = true;
                            $scope.model = data;
                        });
                    },
                    show: function () {
                        return !self.detailsMode;
                    }
                }];

            this.fetchRecords();
        }]);


})(window.angular);