package com.prufercode;

import java.util.Arrays;

public class PruferChainBuilder {

  private final int[] removal;
  private final int[] parent;
  private int[] prufer;

  public PruferChainBuilder(final int[] removal, final int[] parent){
    this.removal = removal;
    this.parent = parent;
  }

  public void buildPruferCode(){
    _buildPruferCode();
  }

  public final int[] getResult(){
    return this.prufer;
  }

  private void _buildPruferCode(){
    final int N = this.removal.length;
    int[] pruferCode = new int[N];
    for(int i = 0; i < N; i++){
      if(this.removal[i] > N){
        continue;
      }
      pruferCode[this.removal[i] - 1] = parent[i];
    }
    this.prufer = Arrays.copyOf(pruferCode, N - 2);
  }
}
