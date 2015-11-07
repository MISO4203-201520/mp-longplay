(function(ng) {
    var mod = ng.module('longPlayModule');
    var cCtrl = 'catalogCtrl';
    var cc = 'CrudCreator';
    var lpSvc = 'longPlayService';
    var lpMod = 'longPlayModel';
    var ciSvc = 'cartItemService';
    var cSvc = 'commentService';
    var qSvc = 'questionService';
    var abSvc = 'albumService';
    mod.controller(cCtrl, [cc, '$scope','$modal', '$route', lpSvc, lpMod, ciSvc, '$location', cSvc, qSvc, abSvc,
        function(CrudCreator, $scope,$modal, $route, svc, model, cartItemSvc, $location, commentService, questionService, albumService) {
            CrudCreator.extendController(this, svc, $scope, $route, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;
            this.detailsMode = false;
            this.myTextArea = "";
            var self = this;
            $scope.answerMode = [];
            this.idCommentPadre = 0;
            $scope.modal = {url: 'src/modules/question/question.tpl.html', data: null, question: ''};
            this.searchByName = function(albumName) {
                var search;
                if (albumName) {
                    search = '?q=' + albumName;
                }
                $location.url('/catalog' + search);
            };
            this.registerQuestion = function() {
                var result = questionService.registerQuestion($scope.modal.data, $scope.modal.question);
                if (result) {
                    $scope.modal.data = null;
                    $scope.modal.question = '';
                }
            };
            this.addComment = function(record, commentReg) {
                if (commentReg.trim().length !== 0)
                {
                    commentService.createComment(record, commentReg, null);
                    this.answerMode = false;
                    this.refreshComment(record);
                }
                $scope.commentReg = "";
                this.refreshComment(record);
            };
            this.refreshComment = function(record) {
                svc.api.get(record.id).then(function(data) {
                    self.detailsModel = true;
                    $scope.model = data;
                });
                this.fetchRecords();
            };
            this.findItem = function(priceMax) {
                svc.findItem(priceMax).then(function(results) {
                    $scope.records = results;
                });
            };
            this.playSong = function(record, song) {
                jwplayer("player" + record.id).setup({playlist: [{file: song.sample, title: song.title, image: record.album.cover, description: record.comments}]});
            };
            this.addAnswer = function(record, answer) {
                if (answer.trim().length !== 0)
                {
                    commentService.createComment(record, answer, this.idCommentPadre);
                    this.answerMode = false;
                    this.refreshComment(record);
                }
                this.refreshComment(record);
            };
            this.recordActions = [{name: 'addToCart', displayName: 'Add to Cart', icon: 'shopping-cart', class: 'primary', fn: function(longPlay) {
                        return cartItemSvc.addItem({longPlay: longPlay, name: longPlay.name, quantity: 1});
                    }, show: function() {
                        return true;
                    }}, {name: 'addQuestion', displayName: 'Add Question', icon: 'question-sign', class: 'info', fn: function(record) {
                        $scope.modal.data = record;
                        $scope.modal.question = '';
                        return true;
                    }, show: function() {
                        return true;
                    }}, {name: 'comments', displayName: 'Comments', icon: 'list', class: 'info', fn: function(record) {
                        svc.api.get(record.id).then(function(data) {
                            self.detailsMode = true;
                            self.findCheapMode = false;
                            $scope.model = data;
                        });
                    }, show: function() {
                        return!self.detailsMode;
                    }}, {name: 'songList', displayName: 'Song List', icon: 'music', class: 'info', fn: function(record) {
                        if (record.songs.length > 0)
                            $('#song_modal_' + record.id).modal('show');
                        return true;
                    }, show: function() {
                        return true;
                    }}, {
                    name: 'share social',
                    displayName: 'Share',
                    icon: 'share',
                    class: 'primary',
                    fn: function (app) {
                        var modalInstance = $modal.open({
                            animation: true,
                            templateUrl: 'src/modules/share/social.html',
                            controller: 'ModalShare',
                            resolve: {
                                app: function () {
                                  //  $rootScope.selectedApp = app;
                                    return app;
                                }
                            }
                        });
                        modalInstance.result.then(function (text) {
                            svc.sendQuestion(text, app);
                        }, function () {

                        });
                    },
                    show: function () {
                        return true;
                    }
                }];
            this.fetchRecords();
            albumService.getTopSellerAlbums().then(function(res) {
                console.log(res[0])
                    $scope.sellers = [];
                    $scope.sellers = res;
            });
            
        }]);
    mod.controller('ModalShare', function ($scope, $modalInstance, app) {
        $scope.itemQuestion = {
            name: app.name,
            text: ""
        };

        $scope.ok = function () {
            $modalInstance.close($scope.itemQuestion.text);
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    });
})(window.angular);