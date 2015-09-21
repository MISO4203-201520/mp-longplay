          
(function () {

    var commentService = function ($http, $cookies) {

        var createComment = function (record, comment) {
            
            //var user = angular.fromJson($cookies.get('userCookie'));
            
            var data = angular.toJson({ id: null, description: comment, commentDate: null, longPlay: record  });
            
            $http({
                method: "POST",
                url: "webresources/comments",
                data: data,
                headers: {'Content-Type': 'application/json'}
            })/*.success(function() {
                alert("Registro almacenado.");
            }).error(function() {
                alert("Error al guardar.");
            })*/;
            
            return true;
        };

        return {
            createComment: createComment,
        };

    };

    var module = angular.module("mainApp");
    module.factory("commentService", commentService);
}
());