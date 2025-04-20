package com.prufercode;

public class EulerTour {
  private final int[] eulerTour;

  public EulerTour(final int[] eulerTour){
    this.eulerTour = eulerTour;
  }

  public final int[] getEulerTour(){
    return this.eulerTour;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i : this.eulerTour){
      sb.append(String.format("%3d", i));
    }
    return sb.toString();
  }
}
