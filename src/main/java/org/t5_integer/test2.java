package org.t5_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준1929
public class test2 {
    private static  void integer_02() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long m = (long) Integer.parseInt(st.nextToken());
        Long n = (long) Integer.parseInt(st.nextToken());
        //10^14 까지 구하니까 제곱근 - > 10 ^7 까지 구하면됨
        long[] arrN = new long[10000001]; // 1 ~ 10000000
        for(int i=2; i<=arrN.length; i++){
            arrN[i] = (long) i;
        }

        for(int i=2; i<=Math.sqrt(arrN.length) ; i++){
            if(arrN[i] == 0){
                continue;
            }
            for(int j= i*2; j<=arrN.length; j = j+i){
                arrN[j] = 0L;
            }
        }
        int cnt =0;
        for(int i=2; i< 10000001; i++){
            if(arrN[i] !=0L){
                long temp = arrN[i];
                while ((double)arrN[i] <= (double)n/(double)temp){
                    if((double)arrN[i] >= (double)m/temp){
                        cnt++;
                    }
                    temp = temp*arrN[i];
                }
            }
        }
        System.out.println(cnt);

    }
    public static void main(String[] args) throws IOException {
        integer_02();
    }
}
