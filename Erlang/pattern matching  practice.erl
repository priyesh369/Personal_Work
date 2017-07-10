-module(classTwo).
-author("Priyesh Patel").
-export([exOr/2, maxOf3/3, pieces/1, howManyEqual/3, product_range/2]).

exOr(false,true) ->
  true;
exOr(true,false) ->
  true;
exOr(_,_) ->
  false.

maxOf3(A,B,C) ->
  maxOf2(maxOf2(A,B),C).

maxOf2(A,B) when A>B ->
  A;
maxOf2(_,B) ->
  B.

howManyEqual(D,D,_) ->
  2;
howManyEqual(D,_,D) ->
  2;
howManyEqual(_,D,D) ->
  2;
howManyEqual(D,D,D) ->
  3;
howManyEqual(_,_,_) ->
  0.

product_range(M,N) when M<N->
  M*product_range(M+1,N);
product_range(N,N) ->
  N.

%%Lazy Caterer's Sequence
pieces(V) ->
  ((V*V)+V+2) div 2.
