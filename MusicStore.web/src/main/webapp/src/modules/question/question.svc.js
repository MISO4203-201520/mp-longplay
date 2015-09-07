(function () {

    var questionService = function ($http, $cookies) {

        var registerQuestion = function (record, question) {
            
            var user = angular.fromJson($cookies.get('userCookie'));
            var data = angular.toJson({ albumId: record.album.id, clientId: user.id, description: question, id: null });
            
            $http({
                method: "POST",
                url: "webresources/questions",
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
            registerQuestion: registerQuestion,
        };

    };

    var module = angular.module("mainApp");
    module.factory("questionService", questionService);

}());