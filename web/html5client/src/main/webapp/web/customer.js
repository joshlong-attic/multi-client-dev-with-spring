
function tos(){ return '{ firstName: '+ this.firstName + '; lastName: ' +this.lastName + '; id: ' + this.id  +'}'; }

var customers = [  { toString:tos,firstName : 'Josh', lastName : 'Long', id : 1} , 
					  {toString:tos, firstName : 'Juergen', lastName : 'Hoeller', id : 2} ];

function url(u){
	return 'http://127.0.0.1:8080/html5client/' + u ;
}

function performLookupById( id , cbwithcustomer){
	var u = url('customer/'+ id);
	alert('url:' + u )
	 $.ajax({
        url: u,
        success: function(data) {
        	
            cbwithcustomer(data);
        }, 
        error: function(a,b,c){
        	alert( a + ':' + b + ':' + c)
        }
    });

}

function CustomerCtrl($scope) { 
	
	$scope.customers =customers; // new Array();
	
 	$scope.isCustomerLoaded = function(){
	  return $scope.customer !=null ; 
	 };
	
  	$scope.lookupCustomer = function(){	
  		performLookupById( $scope.id, function(c){
  			$scope.customer = c ; 
  		});
  		
  		/*
		var results = new Array(); 
     	angular.forEach( $scope.customers, function(c){		
	   		if(c.id == $scope.id) {
       			this.push( c);
			}
		}, results ); 	
		var result = results[0] || null ;
		$scope.customer = result 
		return result ;
		*/
	};
	$scope.save = function(){
		alert('save!');
	};
	$scope.trash = function(){
		alert( 'trash!' );
		$scope.customer = null ;
	}; 
}

