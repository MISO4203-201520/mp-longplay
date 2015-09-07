(function (ng) {
    var mod = ng.module('commentModule', ['ngCrud']);

    mod.constant('commentContext', 'comments');

    mod.constant('commentModel', {
        fields: [{
                name: 'description',
                displayName: 'Description',
                type: 'String',
                required: true
            }, {
                name: 'commentUser',
                displayName: 'Comment User',
                type: 'String',
                required: true
            }, {
            }, {
                name: 'commentDate',
                displayName: 'Comment Date',
                type: 'Date',
                required: true
            }, {
                name: 'longPlay',
                displayName: 'LongPlay',
                type: 'Reference',
                service: 'longPlayService',
                options: [],
                required: true
            }]});
})(window.angular);
