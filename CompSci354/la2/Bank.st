Object subclass: Bank [

    |acctSet account str|
    
    Bank class [
         new[
            ^super new init
        ]
    ]
    
     init [
       
       acctSet := Set new
        
    ]
    
    addAccount: account[
        
        acctSet add: account
        
        ]
        
    accrue: rate[
    
        acctSet do: [ :v | v accrue:rate]
        
    ]
    
    asString[
    
    str := ''.
    acctSet do: [ :v | str:= str,(v asString),(Character nl asString) ].
    ^str
    
    ]

   
]
|bank| bank := Bank new.
|customer| customer := Customer new.
customer initname: 'Ann'.
|savings| savings := SavingsAccount new.
|checking| checking := CheckingAccount new.
checking initParameter: 100.00 customer: customer number: '01001'.
savings initParameter: 200.00 customer: customer number: '01002'.
bank addAccount: checking.
bank addAccount: savings.
bank accrue: 0.02.
(bank asString)printNl


