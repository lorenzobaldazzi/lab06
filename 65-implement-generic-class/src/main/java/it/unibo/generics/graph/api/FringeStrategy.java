package it.unibo.generics.graph.api;

import java.util.Deque;

public interface FringeStrategy<S> {
    void addToFringe(Deque <S> fringe, S element); //fringe contiene nodi gia visitati
}
