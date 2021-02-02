%a
blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).

rot(isskogel).

schwarz(teufeltal).

start(sonnalm).
start(teufeltal).

endetIn(sonnalm, vorkogel).
endetIn(sonnalm, arbiskogel).
endetIn(teufeltal,wiesenalm).
endetIn(arbiskogel, plattenalm).
endetIn(plattenalm, wiesenalm).
endetIn(vorkogel, isskogel).
endetIn(isskogel, tal).
endetIn(wiesenalm, tal).

/* zu b) endetIn(X, wiesenalm). -> X= teufeltal ; -> X= plattental*/

%c
gleicherStartpunkt(X,Y) :- start(X), start(Y), (X\=Y).
gleicherStartpunkt(X,Y) :- endetIn(Z,X),  endetIn(Z,Y), (X\=Y). 

%d

erreichbar(X,Y) :- endetIn(X,Y).
erreichbar(X,Y) :- endetIn(X,Z), erreichbar(Z,Y).

%e


moeglicheSchlusspiste(X,S):- erreichbar(X,S), endetIn(S, tal).
moeglicheSchlusspiste(S,S).
%f
treffpisten(X,Y,T):- erreichbar(X,T), erreichbar(Y,T), T \= tal.

%g
anfaengergeeignet(X):-  blau(X), blau(S), endetIn(X,S), anfaengergeeignet(S).
anfaengergeeignet(X):-  blau(X), blau(A), endetIn(X,tal).
