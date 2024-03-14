package org.t3_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static void quick_01_01() throws IOException {
        //단순히 구하는 건 쉬운듯
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //데이터의 개수
        int K = Integer.parseInt(st.nextToken()); //K번째 수

        st = new StringTokenizer(br.readLine());
        int arrN[]= new int[N];
        for(int i=0; i<N; i++){
            arrN[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        System.out.println(arrN[K-1]);
    }

    public static void main(String[] args) throws IOException {
        quick_01_01();
    }
}