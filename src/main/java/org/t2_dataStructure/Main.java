package org.t2_dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    // 좋은 수 찾기 - 1253
    private static void two_pointer_03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arrN[] = new int[N];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN); // 정렬 추가

        for (int k = 0; k < N; k++) {
            int findValue = arrN[k];
            int i = 0;
            int j = N - 1;

            while (i < j) {
                int sum = arrN[i] + arrN[j];

                if (sum == findValue) {
                    // 찾은 경우 체크
                    if (i != k && j != k) {
                        // 동일하지 않은 경우만 체크해야 함
                        ++cnt;
                        break;
                    }else if(i == k){
                        ++i;
                    }else{
                        // j==k
                        --j;
                    }
                } else if (sum < findValue) {
                    i++;
                } else {
                    // sum > findValue
                    j--;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        two_pointer_03();
    }
}