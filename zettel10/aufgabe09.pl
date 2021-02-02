blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).

rot(isskogel).

schwarz(teufeltal).

start(sonnalm).
start(teufeltal).

endetIn(sonnalm, arbiskogel).
endetIn(sonnalm, vorkogel).
endetIn(teufeltal,wiesenalm).
endetIn(arbiskogel, plattenalm).
endetIn(plattenalm, wiesenalm).
endetIn(vorkogel, isskogel).
endetIn(isskogel, tal).
endetIn(wiesenalm, tal).

add(X,0,X).
add(X,s(Y),s(Z)):- add(X,Y,Z).



%a

moegliche(X):-blau(X);rot(X);schwarz(X).

pathOfLength(cons(tal, nil), 0).
pathOfLength(cons(X,cons(tal,nil)),s(0)):- moegliche(X).
pathOfLength(cons(X,cons(Y,Z)),s(U)):- pathOfLength(cons(X,Z),U), moegliche(Y), moegliche(X).


%b

append_t(cons(tal, nil),First , cons(tal , First)).
append_t(cons(X,cons(Y,O)), YS, cons(X, cons(Z,U))):- append_t(cons(Y,O), YS, cons(Z,U)).

tourOfLength(X,0):- pathOfLength(X,0), add(U, 0, 0).
tourOfLength(cons(tal, cons(X,cons(tal,nil))), s(0)):- append_t(cons(tal, nil), cons(X,cons(tal,nil)), cons(tal, cons(X,cons(tal,nil)))), 
                                                       add(s(Z), 0 , s(0)), pathOfLength(cons(X,cons(tal,nil)), s(0)).
tourOfLength(cons(tal, cons(X,Y)), s(U)):-  append(cons(tal, cons(X,nil)), Y, cons(tal, cons(X,Y)), pathOfLength(cons(X,Y), U).



%d

list(nil).
list(cons(X,Y)):- list(Y), moegliche(X).

convert(nil,[]):- list(nil).
convert(X, U):- list(X).
