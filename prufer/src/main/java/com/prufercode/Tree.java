package com.prufercode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Tree {
  private Set<Integer> vertices;
  private Set<Pair> edges;
  private final int size;

  public Tree(final int size){
    this.size = size;
    this.vertices = new HashSet<Integer>(size);
    this.edges = new HashSet<Pair>();

    this._initializeVertices();
  }

  private void _initializeVertices(){
    for(int i = 1; i <= size; i++){
      this.vertices.add((Integer) i);
    }
  }

  public void addEdge(final int v1, final int v2){
    this.edges.add(new Pair(v1, v2));
  }

  public void removeEdge(final int v1, final int v2){
    this.edges = this.edges.stream().filter(e -> e.first() != v1 && e.second() != v2).collect(Collectors.toSet());
  }

  public Set<Integer> getVertices(){
    return this.vertices;
  }

  public Set<Pair> getEdges(){
    return this.edges;
  }

}
