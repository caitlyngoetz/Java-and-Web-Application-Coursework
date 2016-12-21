#!/bin/gprolog --consult-file

:- include('data.pl').

before(time(Hr1, Min1), time(Hr2, Min2)) :- (Hr1 < Hr2) ; ((Hr1==Hr2),(Min1<Min2)).
after(time(Hr1,Min1), time(Hr2, Min2)) :- (Hr1 > Hr2) ; ((Hr1== Hr2),(Min1>Min2)).
in_between(Start, Finish, Middle) :- (before(Start, Middle), after(Finish, Middle)).
exact(time(Hr1,Min1), time(Hr2, Min2)) :- Hr1 = Hr2 , Min1 = Min2.
meetone(Person, slot(Begin, End)) :- free(Person, slot(Available, Busy)),
  (
   (exact(Begin, Available), exact( End,  Busy));
   (exact(Begin, Available), before(End,  Busy));
   (after(Begin, Available), before(End,  Busy));
   (after(Begin, Available), exact( End,  Busy))
  ).

main :- findall(Person, meetone(Person,slot(time(8,30),time(8,45))), People),
	write(People), nl, halt.

:- initialization(main).
