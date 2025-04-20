package com.prufercode;

public class ParentArray {
  private final int[] parent;

  public ParentArray(final int[] parent){
    this.parent = parent;
  }

  public final int[] getParentArray(){
    return this.parent;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "Parent:"));
    for(int i = 0; i < parent.length; i++){
      sb.append(String.format("%5d", this.parent[i]));
    }
    sb.append("\n");
    sb.append(String.format("%10s", "Position:"));
    for(int i = 0; i < parent.length; i++){
      sb.append(String.format("%5d", i + 1));
    }
    return sb.toString();
  }
}
