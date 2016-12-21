Account subclass: CheckingAccount [
	|interest|
   	
	CheckingAccount class[

		new[
		^super new
		
		]
		
	]			

	initParameter: accountBalance customer: accountCustomer number: accountNumber[ 
	balance := accountBalance.
        customer := accountCustomer.
        number := accountNumber
	]
    
    accrue: rate[]

    ]
