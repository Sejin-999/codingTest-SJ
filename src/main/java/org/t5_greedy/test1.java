package org.t5_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test1 {
    static int res = 0;
    static int k;
    static int [] arrN;
    // 백준11047
    private static  void greedy_01() throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       k = Integer.parseInt(st.nextToken());

      arrN = new int[n];

       for(int i =0; i<n; i++){
           arrN[i] = Integer.parseInt(br.readLine());
       }
        while (k>0){
            greedy_01_task(arrN,n);
        }

        System.out.println(res);
   }
   private static void greedy_01_task(int[] arrN, int n){
       int chc = arrN[0];
       for(int i = n-1; i>0; i--){
           if(arrN[i] <= k){
               chc = arrN[i];
               break;
           }
       }
       res += k/chc;
       k %= chc;
   }

    public static void main(String[] args) throws IOException {
        greedy_01();
    }
}
