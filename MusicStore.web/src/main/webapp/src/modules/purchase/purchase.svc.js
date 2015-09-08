(function (ng) {
    var mod = ng.module('purchaseModule');

    mod.service('purchaseService', ['CrudCreator', 'purchaseContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);

            this.addItem = function (record) {
                var self = this;
                
                   return self.saveRecord(record).then(function(data){
                    
                    return data.data;
                });
                   
                    //alert(insertado.get);
                    
              
            };
            
        }]);
})(window.angular);
