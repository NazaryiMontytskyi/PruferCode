package com.prufercode;

import java.util.List;
import java.util.Map;

public class EncodedEdgeList {
  private Map<Integer, List<Integer>> adjacencyList;
  private List<Pair> sortedDirectedEdges;
  private int[] array_u;
  private int[] array_v;

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    if(sortedDirectedEdges != null || !(sortedDirectedEdges.isEmpty())){
      sb.append("Sorted Directed Edges: \n");
      sortedDirectedEdges.forEach(e -> {
        sb.append(String.format("[%d - %d]", e.first(), e.second()));
        if(sortedDirectedEdges.indexOf(e) != sortedDirectedEdges.indexOf(sortedDirectedEdges.getLast())){
          sb.append(", ");
        }
      });
      sb.append("\n");
    }
    if(adjacencyList != null || !(adjacencyList.isEmpty())){
      sb.append("Adjacency List: \n");
      adjacencyList.forEach((vertex, neighbourList) ->{
        sb.append(vertex + ": ");
        neighbourList.forEach(e -> {
          sb.append(e);
          if(neighbourList.indexOf(e) != neighbourList.indexOf(neighbourList.getLast())){
            sb.append(", ");
          }
          else{
            sb.append("\n");
          }
        });

      });

    }
    return sb.toString();
  }

  public void setAdjacencyList(Map<Integer, List<Integer>> adjacencyList){
    this.adjacencyList = adjacencyList;
  }

  public void setSortedDirectedEdges(List<Pair> sortedDirectedEdges){
    this.sortedDirectedEdges = sortedDirectedEdges;
  }

  public void setArrayU(int[] array_u){
    this.array_u = array_u;
  }

  public void setArrayV(int[] array_v){
    this.array_v = array_v;
  }

  public final int[] getArrayU(){
    return this.array_u;
  }

  public final int[] getArrayV(){
    return this.array_v;
  }

  public final List<Pair> getSortedListEdges(){
    return this.sortedDirectedEdges;
  }

  public final Map<Integer, List<Integer>> getAdjacencyList(){
    return this.adjacencyList;
  }
}
