(function (ng) {
    var mod = ng.module('cartItemModule', ['ngCrud','purchaseModule']);

    mod.constant('cartItemContext', 'cartItems');

    mod.constant('cartItemModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'quantity',
                displayName: 'Quantity',
                type: 'Integer',
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
