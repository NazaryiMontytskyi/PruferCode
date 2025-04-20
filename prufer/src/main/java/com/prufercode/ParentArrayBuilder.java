package com.prufercode;

import java.util.stream.Collectors;
import java.util.Arrays;

public class ParentArrayBuilder {

  private Tree tree;
  private EulerTour eulerTour;
  private ParentArray result;

  public ParentArrayBuilder(Tree tree, EulerTour eulerTour){
    this.tree = tree;
    this.eulerTour = eulerTour;
  }

  public void buildParentArray(){
    executeComputations();
  }

  public ParentArray getResult(){
    return this.result;
  }

  private void executeComputations(){
    final int vertexAmount = this.tree.getVertices().size();
    int[] parentArray = new int[vertexAmount];
    var eulerTour = Arrays.stream(this.eulerTour.getEulerTour()).boxed().collect(Collectors.toList());
    for(int i = 1; i < vertexAmount; i++){
      var indexOfCurrent = eulerTour.indexOf(i);
      var indexOfParent = indexOfCurrent - 1;
      parentArray[i - 1] = eulerTour.get(indexOfParent);
    }
    parentArray[parentArray.length - 1] = -1;
    this.result = new ParentArray(parentArray);
  }

}
