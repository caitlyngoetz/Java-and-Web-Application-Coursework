Object subclass: Account [

    |number customer balance|
    
   Account class[
	new[
	^super new

	]	

	]  
 
   accrue: rate [
	^ self subclassResponsibility

	] 

  getbalance[
        ^balance
        ]
    
   deposit: amount [
    
        balance := balance + amount
        
        ]
        
   withdraw: amount [
    
        balance := balance - amount
        ]
        
   asString [
        ^(number asString), ':', (customer asString), ':', (balance asString)
	]
]

