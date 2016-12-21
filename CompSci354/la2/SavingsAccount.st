Account subclass: SavingsAccount [

    |interest|
    
    SavingsAccount class [
    
        new[
            ^super new init
        ]
    ]
    
    init [
    
        interest := 0
      ] 

    initParameter: accountBalance customer: accountCustomer number: accountNumber[ 
	balance := accountBalance.
        customer := accountCustomer.
        number := accountNumber
	]
  
    accrue: rate[
        balance := balance + (balance * rate).
        interest := interest + (balance * rate)
    ]
    
]
        
