package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;

public class Step<N> {
    private final N position;
    private final List<N> path;

    public Step(final N start){
        this.position = start;
        this.path = List.of(start);
    }

    public Step(Step<N> previous, N next){
        this.position = next;
        this.path = new LinkedList<>(previous.path);
        this.path.add(next);    
    }

    public N getPosition(){
        return this.position;
    }

    public List<N> getPath(){
        return this.path;
    }
}
