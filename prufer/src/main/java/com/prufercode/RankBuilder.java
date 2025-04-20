package com.prufercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankBuilder {

  private ChainArray chain;
  private RankArray rank;

  public RankBuilder(ChainArray chain){
    this.chain = chain;
  }

  public final RankArray getResult(){
    return this.rank;
  }

  public void buildRankArray(){
    _compute();
  }

  private void _compute(){
    final int[] chainArray = this.chain.getChain();
    final int N = chainArray.length;

    int[] rank = new int[N];
    Arrays.fill(rank, 0);

    for(int i = 0; i < chainArray.length; i++){
      if(chainArray[i] != -1){
        _forceChainRecursive(rank, chainArray, i, 1);
      }
    }
    this.rank = new RankArray(rank);
  }

  private void _forceChainRecursive(int[] rank, final int[] chain, int pos, int current){
    rank[pos] = current;
    current += 1;
    int next = chain[pos] - 1;
    if(chain[pos] == -1){
      return;
    } else{
      _forceChainRecursive(rank, chain, next, current);
    }
  }

}
