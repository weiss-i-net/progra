blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).

rot(isskogel).

schwarz(teufeltal).

start(sonnalm).
start(teufeltal).

endetIn(sonnalm,    vorkogel).
endetIn(vorkogel,   isskogel).
endetIn(isskogel,   tal).

endetIn(sonnalm,    arbiskogel).
endetIn(arbiskogel, plattenalm).
endetIn(plattenalm, wiesenalm).
endetIn(wiesenalm,  tal).

endetIn(teufeltal,  wiesenalm).


% a)

pathOfLength(cons(tal, nil), 0).
pathOfLength(cons(A, cons(B, Rest)), s(L)) :- endetIn(A, B),
                                              pathOfLength(cons(B, Rest), L).

% b)

add(X, 0, X).
add(X, s(Y), s(Z)) :- add(X, Y, Z).

append(nil, B, B).
append(cons(A, As), B, cons(A, Cs)) :- append(As, B, Cs).

tourOfLength(cons(tal, nil), 0).
tourOfLength(cons(tal,   T), L) :- start(P),
                                   append(cons(P, PS), Rest, T),
                                   pathOfLength(cons(P, PS), LenP),
                                   tourOfLength(cons(tal, Rest), LenR),
                                   add(LenP, LenR, L).

