import java.io.*;
import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
   HashSet<Integer> hashSet = new HashSet<>();
    
   ArrayList<ArrayList<Integer>> al = new ArrayList<>();
   ArrayList<Integer> inter = null;
    for(int i=0; i < arr.length; i++) {
      hashSet.add(arr[i]);
    }
    
    for(int i=0; i < arr.length; i++) {
      int temp = k + arr[i];
      if(hashSet.contains(temp)) {
        inter = new ArrayList<>();        
        inter.add(temp);  
        inter.add(arr[i]);
        al.add(inter); 
      }
    }    
     
    int[][] result = new int[al.size()][2];
    
    for (int i = 0; i < al.size(); i++) {
      ArrayList<Integer> row = al.get(i);
      result[i][0] = row.get(0);
      result[i][1] = row.get(1);
    }
    return result;
  }


   public static void main(String[] args) {
     int[] input = new int[]{4, 1};
     int k = 3;
     int[][] result = findPairsWithGivenDifference(input, k);
     for(int i=0; i < result.length; i++) {
         for(int j = 0; j < result[i].length; j++) {
             System.out.print(result[i][j] + " ");
         }
     }
     
  }
  
}
