#!/bin/gprolog --consult-file

:- include('data.pl').
:- include('uniq.pl').

before(time(Hr1, Min1), time(Hr2, Min2)) :- (Hr1 < Hr2) ; ((Hr1==Hr2),(Min1<Min2)).
after(time(Hr1,Min1), time(Hr2, Min2)) :- (Hr1 > Hr2) ; ((Hr1== Hr2),(Min1>Min2)).
in_between(Start, Finish, Middle) :- (before(Start, Middle), after(Finish, Middle)).
exact(time(Hr1,Min1), time(Hr2, Min2)) :- Hr1 = Hr2 , Min1 = Min2.
earliest(Time, Time2, Final) :- (before(Time, Time2), Time  = Final); (after(Time,  Time2), Final = Time2); (exact(Time, Time2), Time = Final).
latest(Time, Time2, Final) :- (before(Time, Time2), Time2 = Final); (after(Time, Time2), Final = Time); (exact(Time, Time2), Time = Final).
meet(Slot) :- people([H]), free(H,Slot).	
meet(Slot) :- people([H|T]), free(H, HeadSlot), compareTime(T, HeadSlot, Slot).
compareTime([H], HeadSlot, Slot) :- free(H, HeadSlot2), finalSlot(HeadSlot, HeadSlot2, Slot).
compareTime([H|T], HeadSlot, Slot) :- free(H, HeadSlot2), finalSlot(HeadSlot, HeadSlot2, Compare), compareTime(T, Compare, Slot).
finalSlot(slot(Beg, End), slot(Beg2, End2), slot(BeginCompare, EndCompare)) :- before(Beg, End2), after(End, Beg2), latest(Beg, Beg2, BeginCompare), earliest(End, End2, EndCompare).

people([ann,bob, carla, dave]).

main :- findall(Slot, meet(Slot), Slots),
        uniq(Slots, Uniq),
        write(Uniq), nl, halt.

:- initialization(main).
