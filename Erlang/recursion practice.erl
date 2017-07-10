%%%-------------------------------------------------------------------
%%% @author Priyesh Patel
%%% @copyright (C) 2017, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 24. Apr 2017 10:07 AM
%%%-------------------------------------------------------------------
-module('2016').
-author("Priyesh Patel").

%% API
-compile(export_all).

merge([], Ys)
  -> Ys;
merge(Xs, [])
  -> Xs;
merge([X | Xs], [Y | Ys]) when X =< Y
  -> [X | merge(Xs, [Y | Ys])];
merge([X | Xs], [Y | Ys])
  -> [Y | merge([X | Xs], Ys)].

%1c
result({rock, paper}) -> -1;
result({rock, scissors}) -> 1;
result({scissors, rock}) -> -1;
result({scissors, paper}) -> 1;
result({paper, scissors}) -> -1;
result({paper, rock}) -> 1;
result({_, _}) -> 0.

resultInner([], []) -> 0;
resultInner([X | Xs], [Y | Ys]) ->
  result({X, Y}) + resultInner(Xs, Ys).

result(Xs, Ys) ->
  Z = resultInner(Xs, Ys),
  case (Z >= 0) of
    true when Z == 0 -> draw;
    true -> win;
    _ -> lose
  end.

%3b
lookup(_X, []) -> false;
lookup(X, [{X, Y} | _Ys]) -> Y;
lookup(X, [_Y | Ys]) -> lookup(X, Ys).


run([]) -> [];
run([X]) -> run([X]);
run([X, Y | Xs]) when X < Y -> [X | run([Y | Xs])];
run([X | _]) -> [X].

count_nl(X) -> lists:foldr(fun(Y, N) when Y == $\n -> N + 1;
  (_, N) -> N end, 0, X).

echo(X) -> X.

test(_F, []) -> true;
test(F, [{X, Y} | Xs]) ->
  case F(X) == Y of
    true -> test(F, Xs);
    false -> false
  end.

check(_F, []) -> false;
check(F, [{X, _Y} | Xs]) ->
  case F == X of
    false -> check(F, Xs);
    true -> true
  end.

bar (_N, []) ->
  [];
bar (N, [Y|Ys]) when N =/= Y ->
  [Y|bar (N, Ys)];
bar (N, [_Y|Ys]) ->
  bar(N, Ys).