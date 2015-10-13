(function(ng) {
    var mod = ng.module('songModule', ['ngCrud']);

    mod.constant('songContext', 'songs');

    mod.constant('songModel', {
        fields: [{
                name: 'title',
                displayName: 'Title',
                type: 'String',
                required: true
            }, {
                name: 'duration',
                displayName: 'Duration',
                type: 'Integer',
                required: true
            }, {
                name: 'genre',
                displayName: 'Genre',
                type: 'String',
                required: true
            }, {
                name: 'author',
                displayName: 'Author',
                type: 'String',
                required: true
            }, {
                name: 'sample',
                displayName: 'Sample',
                type: 'String',
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