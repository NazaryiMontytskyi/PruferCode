package com.prufercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubtreeValuesFinder {

  ParentArray parentArray;
  MaximumResult result;

  public MaximumSubtreeValuesFinder(ParentArray parentArray){
    this.parentArray = parentArray;
  }

  public MaximumResult getResult(){
    return this.result;
  }

  public void computeMaximums(){
    _computeMaximums();
  }

  private void _computeMaximums(){
    final int N = this.parentArray.getParentArray().length;
  var parent = this.parentArray.getParentArray();

  // --- Ось це додаємо! ---
  // Переводимо 1-базову нумерацію в 0-базову
  int[] p0 = new int[N];
  for(int i = 0; i < N; i++){
    if(parent[i] == -1) {
      p0[i] = -1;
    } else {
      p0[i] = parent[i] - 1;
    }
  }

  // 1) Створюємо списки дітей
  List<Integer>[] children = new ArrayList[N];
  for(int i = 0; i < N; i++){
    children[i] = new ArrayList<>();
  }
  int root = -1;
  for(int i = 0; i < N; i++){
    if(p0[i] == -1){
      root = i;
    } else {
      children[p0[i]].add(i);
    }
  }

    int[] d = new int[N];
    int[] start = new int[N];
    start[0] = 0;
    for(int u = 0; u < N; u++){
      d[u] = children[u].size();
      if(u > 0){
        start[u] = start[u - 1] + (d[u - 1] + 1);
      }
    }
    int M = start[N - 1] + d[N - 1] + 1;

    int[] leftChild = new int[M];
    int[] rightChild = new int[M];
    Arrays.fill(leftChild, -1);
    Arrays.fill(rightChild, -1);

    for(int u = 0; u < N; u++){
      int base = start[u];
      for(int k = 0; k < d[u]; k++){
        int v = children[u].get(k);
        leftChild[base + k] = start[v];
        rightChild[base + k] = base + k + 1;
      }
    }

    int[] value = new int[M];
    for(int u = 0; u < N; u++){
      int base = start[u];
      value[base] = u + 1;
      for(int k = 1; k <= d[u]; k++){
        value[base + k] = 0;
      }
    }

    int[] subtreeMax = new int[M];
    dfs(start[root], leftChild, rightChild, value, subtreeMax);
    int[] maximum = new int[N];
    for(int u = 0; u < N; u++){
      maximum[u] = subtreeMax[start[u]];
    }

    this.result = new MaximumResult(maximum);
  }

  private int dfs(int pos, int[] left, int[] right, int[] value, int[] subMax){
    if(pos < 0){
      return 0;
    }
    int lMax = dfs(left[pos], left, right, value, subMax);
    int rMax = dfs(right[pos], left, right, value, subMax);
    int max = Math.max(value[pos], Math.max(lMax, rMax));
    subMax[pos] = max;
    return max;
  }



}
