package com.prufercode;

import java.util.Arrays;

public class RemovalArray {
  private final int[] removal;

  public RemovalArray(final int[] removal){
    this.removal = removal;
  }

  public final int[] getRemovalArray(){
    return this.removal;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "Removal:\n"));
    Arrays.stream(this.removal).boxed().forEach(e -> sb.append(String.format("%4s", e)));
    return sb.toString();
  }
}
