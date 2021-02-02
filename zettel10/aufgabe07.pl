
increment(    leaf(N), leaf(s(N))).
increment(node(X,Y,Z), node(A, s(Y), B)) :- increment(X, A),
                                            increment(Z, B).

append(      [], YS, YS).
append([X | XS], YS, [X | Res]) :- append(XS, YS, Res).


inorder(      leaf(X), [X]).
inorder(node(X, Y, Z), R) :- inorder(X, X'),
                             inorder(Z, Z'),
                             append(X', [Y], XY),
                             append(XY, Z', R).



