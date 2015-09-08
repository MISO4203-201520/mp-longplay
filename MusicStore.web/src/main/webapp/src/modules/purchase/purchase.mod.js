(function (ng) {
    var mod = ng.module('purchaseModule', ['ngCrud']);

    mod.constant('purchaseContext', 'purchases');

    mod.constant('purchaseModel', {
        fields: [{
                name: 'date',
                displayName: 'Date',
                type: 'Date',
                required: true
            }, {
                name: 'iva',
                displayName: 'Iva',
                type: 'Currency',
                required: true
            }, {
                name: 'paymentMethod',
                displayName: 'PaymentMethod',
                type: 'String',
                required: true
            }, {
                name: 'total',
                displayName: 'Total',
                type: 'Currency',
                required: true
            }]});
})(window.angular);
