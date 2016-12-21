Object subclass: Customer [

    |name|

	initname: cname
    	[
	name := cname
	]
    Customer class
	[
		new
		[
		^super new
		]

	]

	

	getName
	[^name
	]

    asString[
        ^(name asString)
            ]
    
    ]
"
|customer| customer:= Customer new.
customer initname: 'Ann'"
