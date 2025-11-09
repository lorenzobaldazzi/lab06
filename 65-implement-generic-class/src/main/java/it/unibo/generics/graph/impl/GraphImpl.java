package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Deque;

import it.unibo.generics.graph.api.FringeStrategy;
import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map <N,Set<N>> edges = new LinkedHashMap<>();
    private final FringeStrategy<Step<N>> strategy;
    
    public GraphImpl(final FringeStrategy<Step<N>> strategy){
        this.strategy = strategy;
    }

    
    @SafeVarargs
    private boolean nodesExist (final N... nodes){
        for(final N ntmp: nodes){
            if (!this.edges.containsKey(ntmp)){
                throw new IllegalArgumentException("the node: "+ ntmp + "isn't present");
            }
        }
        
        return true;
    }

    private List<N> searchPath(N source, N destination){
        final Deque <Step<N>> fringe = new LinkedList<>();
        fringe.add(new Step<N>(source));
        final Set<N> visited = new HashSet<>();

        while(!fringe.isEmpty()){
            final Step<N> currentStep = fringe.removeFirst();
            final N currentNode = currentStep.getPosition();

            if(currentNode.equals(destination)){
                return currentStep.getPath();
            }

            if(!visited.contains(currentNode)){
                visited.add(currentNode);
                for(final N near : edges.getOrDefault(currentNode, Set.of())){
                    strategy.addToFringe(fringe, new Step<>(currentStep,near));
                }
            }

        }

        return Collections.emptyList();
    }

    @Override
    public void addNode(N node){
        this.edges.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(N source, N target){
        if(nodesExist(source,target)){
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet(){
        
        return new HashSet<N>(edges.keySet());
    }

    @Override
    public Set <N> linkedNodes(N node){

        return edges.get(node);
    }

    @Override
    public List<N> getPath (N source, N target){
        if(nodesExist(source,target)){
            return searchPath(source, target);
        }else{
            return Collections.emptyList();
        }

       
    }
}
