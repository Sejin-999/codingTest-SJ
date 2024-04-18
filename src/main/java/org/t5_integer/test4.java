package org.t5_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준1929
public class test4 {
    private static  void integer_04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        // 1,000,000,000,000 -> 루트 -> 1,000,000 까지 구하면 됨
        boolean [] arrB = new boolean[(int)(max-min+1)];


        for(long i = 2; i * i <= max; i++){
            long squ = i*i;
            long start = min%squ == 0 ? min / squ : min / squ + 1;

            for(long j = start; j*squ <= max; j++){
                arrB[(int) (j * squ - min)]= true;
            }
        }

        int cnt = 0;
        for(boolean a : arrB){
            if(! a){
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        integer_04();
    }
}
