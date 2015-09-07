//(function (ng) {
//    var mod = ng.module('commentModule');
//
//    mod.service('commentService', ['CrudCreator', 'commentContext', function (CrudCreator, context) {
//            CrudCreator.extendService(this, context);
//
//            this.createComment = function (record) {
//                var self = this;
//                    
//                
//                    self.createComment(record);
//             
//            };
//        }]);
//})(window.angular);

(function () {

    var commentService = function ($http, $cookies) {

        var createComment = function (record, comment) {
            
            //var user = angular.fromJson($cookies.get('userCookie'));
            var data = angular.toJson({ id: null, description: comment, commentUser: 'usuario prueba', commentDate: null, longPlay: record  });
            
            $http({
                method: "POST",
                url: "webresources/comments",
                data: data,
                headers: {'Content-Type': 'application/json'}
            }).success(function(response) {
                alert("Se registró la información");
            }).error(function() {
                alert("Se presentó un problema registrando la información");
            });
            
            return true;
        };

        return {
            createComment: createComment,
        };

    };

    var module = angular.module("mainApp");
    module.factory("commentService", commentService);

}());