package org.t5_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준1934
public class test5 {
    private static  void integer_05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int res = a*b/gcd(a,b);

            System.out.println(res);
        }
    }
    private static int gcd(int a , int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) throws IOException {
        integer_05();
    }
}
