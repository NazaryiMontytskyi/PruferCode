package com.prufercode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RemovalBuilder {

  private final int[] maximum;
  private final int[] rank;
  private RemovalArray result;

  public RemovalBuilder(final int[] maximum, final int[] rank){
    this.maximum = maximum;
    this.rank = rank;
  }

  public void buildRemoval(){
    _buildRemoval();
  }

  public RemovalArray getResult(){
    return this.result;
  }

  private void _buildRemoval(){
    final int N = this.maximum.length;
    int[] position = new int[N];
    int[] removal = new int[N];
    for(int i = 0; i < position.length; i++) position[i] = i + 1;

    var sortedPositions = Arrays.stream(position).boxed()
    .sorted(Comparator.comparingInt(
      (Integer i) -> this.maximum[i - 1]
    ).thenComparing(
      i -> this.rank[i - 1]
    )).collect(Collectors.toList()).toArray(new Integer[N]);

    for(int i = 0; i < sortedPositions.length; i++){
      removal[sortedPositions[i] - 1] = i + 1;
    }
    this.result = new RemovalArray(removal);
  }

}
