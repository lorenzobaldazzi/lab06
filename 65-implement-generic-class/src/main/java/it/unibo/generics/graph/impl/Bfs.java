package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FringeStrategy;

public class Bfs<S> implements  FringeStrategy<S>{
    private static final Bfs<?> instance = new Bfs<>();

    @SuppressWarnings("unchecked")
    public static <S> Bfs<S> getInstance(){
        return (Bfs<S>) instance;
    }

    public void addToFringe(final Deque<S> fringe, final S element){
        fringe.addLast(element);
    }
    
}
