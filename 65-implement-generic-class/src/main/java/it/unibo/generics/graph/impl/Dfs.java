package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FringeStrategy;

public class Dfs<S> implements FringeStrategy<S> {

    private static Dfs<?> instance = new Dfs<>();
    
    @SuppressWarnings("unchecked")
    public Dfs<S> getInstance(){
        return (Dfs<S>) instance;
    }

    public void addToFringe(final Deque<S> fringe, S element){
        fringe.addFirst(element);
    }

}
