-module(cthree).
-compile(export_all).

	doubleAll([]) -> [];
	doubleAll([X|Xs]) ->
	[ 2*X | doubleAll(Xs) ].

	evens([]) ->
		[];
	evens([X|Xs]) when X rem 2 == 0 ->
		[X | evens(Xs) ];
	evens([_|Xs]) ->
		evens(Xs).

	plusplus([],Ys) ->
		Ys;
	plusplus([X|Xs],Ys) ->
		[X|plusplus(Xs,Ys)].

	stars(0) -> 
		io:format("~n");
	stars(N) -> 
		io:format("*"),
		stars(N-1).
		
	build(N,M) when M>N ->
		[];
	build(N,N) ->
		[N];
	build(N,M) ->
		[N|build(N+1,M)].