package org.t2_dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void sum_arr_3() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int cnt = 0; //res 값
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int arrN[] = new int[N];
        int arrC[] = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        //합배열 만들기
        int arrS[] = new int[N+1];
        arrS[0] = arrN[0];

        for (int i = 1; i < N; i++) {
            arrS[i] = arrN[i] + arrS[i - 1];
        }

        //나누어 떨어지는 경우 찾기
        for (int i = 0; i < N; i++) {
            int c = arrS[i] % M;

            if (c == 0) {
                cnt++;
            }

            arrC[c]++;

        }
        for (int i = 0; i < M; i++) {
            if (arrC[i] > 1) {
                //경우가 2개 이상인 경우만..
                //경우의 수 구하는 공식..
                /**
                 * 이때 사용된 공식은 조합(combination)의 공식
                 * 공식: nC2 = n! / (2! * (n-2)!)
                 * 여기서 n!는 팩토리얼이며, n! = n * (n-1) * (n-2) * ... * 1 입니다.
                 * 2!는 2 * 1로 계산됩니다. 따라서 nC2는 n(n-1)/2 가 됩니다
                 */
                cnt = cnt + (arrC[i] * (arrC[i] - 1) / 2);
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        sum_arr_3();
    }

}
