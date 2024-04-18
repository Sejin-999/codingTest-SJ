package org.t5_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준1929
public class test1 {
    private static  void integer_01() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int []arrN = new int[n+1];
        for(int i=2; i<=n; i++){
            arrN[i] = i;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(arrN[i] == 0){
                continue;
            }
            for(int j=i*2; j<=n; j=j+i ){
                arrN[j] = 0;
            }
        }
        for(int i=m; i<=n; i++){
            if(arrN[i] != 0){
                System.out.println(arrN[i]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        integer_01();
    }
}
