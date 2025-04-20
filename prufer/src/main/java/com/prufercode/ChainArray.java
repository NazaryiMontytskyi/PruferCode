package com.prufercode;

import java.util.Arrays;

public class ChainArray {

  private final int[] chain;

  public ChainArray(final int[] chain){
    this.chain = chain;
  }

  public final int[] getChain(){
    return this.chain;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "Chain:\n"));
    Arrays.stream(this.chain).boxed().forEach(e -> sb.append(String.format("%4d", e)));
    return sb.toString();
  }

}
