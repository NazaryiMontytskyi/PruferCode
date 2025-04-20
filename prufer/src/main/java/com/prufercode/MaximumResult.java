package com.prufercode;

import java.util.Arrays;

public class MaximumResult {
  private final int[] maximum;

  public MaximumResult(final int[] maximum){
    this.maximum = maximum;
  }

  public final int[] getMaximum(){
    return this.maximum;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "Maximum: "));
    Arrays.stream(maximum).boxed().forEach(e -> sb.append(String.format("%4d", e)));
    return sb.toString();
  }
}
