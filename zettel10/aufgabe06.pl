
% a)

blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).

rot(isskogel).

schwarz(teufeltal).

endetIn(start,      sonnalm).
endetIn(sonnalm,    vorkogel).
endetIn(vorkogel,   isskogel).
endetIn(isskogel,   tal).

endetIn(sonnalm,    arbiskogel).
endetIn(arbiskogel, plattenalm).
endetIn(plattenalm, wiesenalm).
endetIn(wiesenalm,  tal).

endetIn(start,      teufeltal).
endetIn(teufeltal,  wiesenalm).


% b)
% endetIn(X, wiesenalm).


% c)
gleicherStartPunkt(X, Y) :- endetIn(S, X),
                            endetIn(S, Y).


% d)
erreichbar(X, X).
erreichbar(X, Y) :- endetIn(Z, Y),
                    erreichbar(X, Z).

% e)
moeglicheSchlusspiste(X, S) :- endetIn(S, tal),
                               erreichbar(X, S).

% f)
treffpisten(X, Y, T) :- erreichbar(T, tal),
                        erreichbar(X, T),
                        erreichbar(Y, T),
                        T \= tal.

% g)
anfaengerGeeignet(X) :- blau(X),
                        endetIn(X, tal).

anfaengerGeeignet(X) :- blau(X),
                        endetIn(X, Y),
                        anfaengerGeeignet(Y).
