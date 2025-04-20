package com.prufercode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertEdgeListAlgorithm {

  private Tree tree;
  private EncodedEdgeList result;

  public ConvertEdgeListAlgorithm(Tree tree){
    this.tree = tree;
    this.result = new EncodedEdgeList();
  }

  public EncodedEdgeList getResult(){
    return this.result;
  }

  public void convertTreeToEdgeList(){
    _deriveDirectedEdges();
    _formAdjacencyList();
  }

  private void _deriveDirectedEdges(){
    List<Pair> directedEdges = new ArrayList<>();
    this.tree.getEdges().forEach(e -> {
      directedEdges.add(new Pair(e.first(), e.second()));
      directedEdges.add(new Pair(e.second(), e.first()));
    });
    directedEdges.sort((a, b) -> {
      if(a.first() != b.first()){
        return a.first() - b.first();
      }
      return a.second() - b.second();
    });
    this.result.setSortedDirectedEdges(directedEdges);
  }

  private void _formAdjacencyList(){
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    this.tree.getEdges().forEach(e -> {
      adjacencyList.computeIfAbsent(e.first(), k -> new ArrayList<>());
      adjacencyList.computeIfAbsent(e.second(), k -> new ArrayList<>());
      adjacencyList.get(e.first()).add(e.second());
      adjacencyList.get(e.second()).add(e.first());
    });
    this.result.setAdjacencyList(adjacencyList);
  }

}
