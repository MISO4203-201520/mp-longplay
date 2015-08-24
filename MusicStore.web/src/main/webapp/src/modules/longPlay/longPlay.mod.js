(function (ng) {
    var mod = ng.module('longPlayModule', ['ngCrud']);

    mod.constant('longPlayContext', 'longPlays');

    mod.constant('longPlayModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true
            }, {
                name: 'album',
                displayName: 'Album',
                type: 'Reference',
                service: 'albumService',
                options: [],
                required: true
            }]});
})(window.angular);
