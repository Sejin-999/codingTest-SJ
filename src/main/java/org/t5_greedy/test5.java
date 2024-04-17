package org.t5_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test5 {

    // 백준11047
    private static  void greedy_05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String []arrN;
        int res=0;
        arrN = text.split("-");
        for(int i=0; i< arrN.length; i++){
           int temp = Sum(arrN[i]);
           if(i==0){
               res+=temp; //처음값
           }
           else{
               res-=temp;
           }
        }
        System.out.println(res);
    }

    static int Sum(String value){
        int sum = 0;
        String [] temp = value.split("[+]");
        for(int i=0; i<temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        greedy_05();
    }
}
