(function (ng) {
    var mod = ng.module('albumModule', ['ngCrud']);

    mod.constant('albumContext', 'albums');

    mod.constant('albumModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'cover',
                displayName: 'Cover',
                type: 'Image',
                required: true
            }, {
                name: 'release',
                displayName: 'Release',
                type: 'Date',
                required: true
            }, {
                name: 'single',
                displayName: 'Single',
                type: 'Boolean',
                required: true
            }, {
                name: 'artist',
                displayName: 'Artist',
                type: 'String',
                required: true
            },{
                name: 'publicationDate',  
                displayName: 'Publication Date',
                type: 'Date',
                required: true 
            }]});
            
})(window.angular);
