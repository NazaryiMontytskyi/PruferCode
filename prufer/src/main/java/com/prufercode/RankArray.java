package com.prufercode;

import java.util.Arrays;

public class RankArray {

  final int[] rank;

  public RankArray(final int[] rank){
    this.rank = rank;
  }

  public final int[] getRankArray(){
    return this.rank;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%10s", "Rank:\n"));
    Arrays.stream(this.rank).boxed().forEach(e -> sb.append(String.format("%4d", e)));
    return sb.toString();
  }
}
