package com.prufercode;

public class ChainTransform {

  private final int[] maximum;
  private final int[] parent;
  private ChainArray chain;

  public ChainTransform(final int[] maximum, final int[] parent){
    this.maximum = maximum;
    this.parent = parent;
  }

  public void buildChainArray(){
    _compute();
  }

  public final ChainArray getResult(){
    return this.chain;
  }

  private void _compute(){
    int[] chainArray = new int[this.maximum.length];
    for(int i = 0; i < this.maximum.length - 1; i++){
      if(this.maximum[i] != this.maximum[this.parent[i] - 1]){
        chainArray[i] = -1;
      }
      else{
        chainArray[i] = parent[i];
      }
    }
    chainArray[this.maximum.length - 1] = -1;
    this.chain = new ChainArray(chainArray);
  }

}
