(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel','purchaseService','$http', function (CrudCreator, $scope, svc, model, purchaseSvc,$http) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'CartItem');         
            var self = this;
            
            $scope.paymentMethod = [{
                    value: 'deb',
                    label: 'Debit'
                }, {
                    value: 'cre',
                    label: 'Credit'
                }]; 
            
            $scope.fecha="";
            var oldFetch = this.fetchRecords;
            this.fetchRecords = function(){
                return oldFetch.call(this).then(function(data){
                    self.calcTotal();
                    return data;
                });
            };
            this.fetchRecords();
            this.readOnly = true;
            $scope.lastQuantity = 0;
            $scope.total = 0;

            this.recordActions = {
                delete: {
                    displayName: ' ',
                    icon: 'trash',
                    class: 'primary',
                    fn: function (record) {
                        svc.deleteRecord(record).then(function(){
                            self.fetchRecords();
                        });
                    },
                    show: function () {
                        return true;
                    }
                }
            };

            this.calcTotal = function () {
                $scope.cartList=[];
                $scope.total = 0;
                $scope.totalDiscount=0;
                $scope.totalIva=0;
                for (var i = 0; i < $scope.records.length; i++) {
                    var iva=($scope.records[i].longPlay.price * $scope.records[i].quantity)*0.16;
                    var total= (($scope.records[i].longPlay.price * $scope.records[i].quantity)+iva)-$scope.records[i].longPlay.discount;
                    $scope.total += total;
                    $scope.totalDiscount += $scope.records[i].longPlay.discount;
                    $scope.totalIva += iva;
                    var obj=new Object();
                    obj.price=$scope.records[i].longPlay.price;
                    obj.quantity=$scope.records[i].quantity;
                    obj.longPlay=$scope.records[i].longPlay;
                    $scope.cartList.push(obj);
                }
            };

            $scope.verify = function (quantity) {
                $scope.lastQuantity = quantity;
            };//guarda la cantidad anterior

            $scope.postVerify = function (record) {
                var patron = /^\d*$/; //^[0-9]{3}$
                if (patron.test(record.quantity) && record.quantity > 0) {
                    self.calcTotal();
                } else {
                    self.showError("You must enter a valid quantity");
                    record.quantity = $scope.lastQuantity;
                    $scope.currentRecord = record;
                }
            };//Realiza la validacion de la nueva cantidad asignada.
            $scope.checkout = function () {
                
                //self.showWarning("Not implemented yet");
                $('#divPagar').show('slow');
            };
            $scope.subtotal = function (record) {
                var iva=(record.longPlay.price * record.quantity)*0.16;
                return ((record.longPlay.price * record.quantity)+iva)-record.longPlay.discount;
            };
            $scope.iva = function (record) {
                var iva=(record.longPlay.price * record.quantity)*0.16;
                return iva;
            };
            
            
           function fecha(num){
               if(num.toString().length==1){
                   return "0"+num;
               }
               
               return num;
           }
           $scope.comboChange = function () {
               if ($scope.paymentMethodList.label=="Credit"){
                   $("#divCredito").show("slow");
               }else{
                   
                   $("#divCredito").hide("slow");
                   
               }
           };
            
            $scope.pay = function () {
                var date="";
                var grabar=true;
                if ($scope.cardNumber == undefined){
                    self.showWarning("Card number is required.");                    
                }else if($scope.paymentMethodList==undefined){
                    self.showWarning("Payment method is required.");
                } else{
                    if ($scope.paymentMethodList.label=="Credit"){
                   if ($scope.expire==undefined || $scope.nameCardOwner=="" || $scope.nameCardOwner==undefined || $scope.cvc=="" || $scope.cvc==undefined){
                       self.showWarning("Missing data.");
                       grabar=false;
                   }else{
                       date=($scope.expire.getMonth()+1)+"/"+$scope.expire.getFullYear();
                   }
                    }
                    if (grabar==true){
                    var f = new Date();
                    var pay =new Object();
                    pay.date= f.getFullYear()+ "-" +fecha((f.getMonth() +1)) + "-" +fecha(f.getDate());
                    pay.iva=$scope.totalIva;                    
                    pay.paymentMethod=$scope.paymentMethodList.label;
                    pay.cardNumber=$scope.cardNumber;
                    pay.total=$scope.total;
                    pay.purchaseDetail=$scope.cartList;
                    pay.expirationDate=date;
                    pay.CVC=$scope.cvc;
                    pay.nameCardOwner=$scope.nameCardOwner;
                    //pay.nameCardOwner=$scope.nameCardOwner;
                    purchaseSvc.addItem(pay);
                   for (var i = 0; i < $scope.records.length; i++) {
                   svc.deleteRecord($scope.records[i]).then(function(){
                            //self.fetchRecords();
                        });
                   }
                //$('#divPagar').hide('slow');    
                window.location="#/catalog";
                 }
                }
            };
            
           
        }]);
})(window.angular);
