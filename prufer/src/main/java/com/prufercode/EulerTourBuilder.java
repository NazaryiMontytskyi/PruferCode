package com.prufercode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class EulerTourBuilder {

  private EncodedEdgeList edgeList;
  private EulerTour result;

  public EulerTourBuilder(EncodedEdgeList edgeList){
    this.edgeList = edgeList;
  }

  public void computeEulerTourBuilding(){
    _buildEulerTour();
  }

  public EulerTour getResult(){
    return this.result;
  }

  private void _buildEulerTour(){
    Map<Integer, List<Integer>> adjList = this.edgeList.getAdjacencyList();
    Stack<Integer> vertices = new Stack<>();
    List<Integer> eulerTour = new ArrayList<>();
    final Integer maxVertex = adjList.keySet().stream().sorted().collect(Collectors.toList()).getLast();
    vertices.add(maxVertex);
    while(!vertices.isEmpty()){

      var currentVertex = vertices.peek();
      eulerTour.add(currentVertex);
      var currentNeighbours = adjList.get(currentVertex);

      if(!currentNeighbours.isEmpty()){
        var currentNeighbour = currentNeighbours.getFirst();
        currentNeighbours.remove(currentNeighbour);
        adjList.get(currentNeighbour).remove(currentVertex);
        vertices.push(currentNeighbour);
      }
      else{
        vertices.pop();
      }
    }
    int[] resultArray = new int[eulerTour.size()];
    for(int i = 0; i < resultArray.length; i++){
      resultArray[i] = eulerTour.get(i);
    }
    this.result = new EulerTour(resultArray);

  }

}