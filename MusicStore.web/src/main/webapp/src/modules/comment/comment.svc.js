(function () {
    var commentService = function ($http) {
        var createComment = function (record, comment, padre) {
            var data = angular.toJson({id: null, description: comment, commentDate: null, longPlay: record, idPadre: padre});
            $http({
                method: "POST",
                url: "webresources/comments",
                data: data,
                headers: {'Content-Type': 'application/json'}
            });

            return true;
        };
        return {
            createComment: createComment
        };
    };
    var module = angular.module("mainApp");
    module.factory("commentService", commentService);
}());