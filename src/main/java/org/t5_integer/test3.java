package org.t5_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준1929
public class test3 {
    private static  void integer_03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int []arrN = new int[1000001];
        for(int i=2; i<arrN.length; i++){
            arrN[i] = i;
        }
        for(int i=2; i< Math.sqrt(arrN.length); i++){
            if(arrN[i] == 0){
                continue;
            }
            for(int j=i*2; j<arrN.length; j=j+i ){
                arrN[j] = 0;
            }
        }
        for(int i=n; i<arrN.length; i++){
            if(arrN[i] != 0){
                if(check_p(arrN[i])){
                    System.out.println(arrN[i]);
                    break;
                }
            }
        }

    }

    private static boolean check_p(int a){
        char [] arrC = String.valueOf(a).toCharArray();
        int start = 0;
        int end = arrC.length-1;
        while (start < end){
            if(arrC[start] != arrC[end]){
                //다른 경우..
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        integer_03();
    }
}
