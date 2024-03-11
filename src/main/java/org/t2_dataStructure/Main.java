package org.t2_dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 구간 합 구하기 - 11659
    private static void sum_arr_1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        Long[] S = new Long[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        S[0] = 0L; // 초기값 설정
        for (int i = 1; i <= N; i++) {
            // 합배열 만들기
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int q = 0; q < M; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }

    }
    public static void main(String[] args) throws IOException {
        sum_arr_1();
    }
}
