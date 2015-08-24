(function (ng) {
    var mod = ng.module('longPlayModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'longPlayService', 'longPlayModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;

            this.searchByName = function (albumName) {
                var search;
                if (albumName) {
                    search = '?q=' + albumName;
                }
                $location.url('/catalog' + search);
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (longPlay) {
                        return cartItemSvc.addItem({
                            longPlay: longPlay,
                            name: longPlay.name,
                            quantity: 1});
                    },
                    show: function () {
                        return true;
                    }
                }];

            this.fetchRecords();
        }]);
})(window.angular);