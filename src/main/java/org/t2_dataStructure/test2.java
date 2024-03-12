package org.t2_dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test2 {
    //two pointer
    //연속된 자연수 합 구하기 - 2018
    private static void two_pointer_01(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int cnt =1;
        int start_index =1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N){
            if(sum == N){
                cnt++;
                end_index++;
                sum += end_index;
            } else if (sum >N) {
                sum -= start_index;
                start_index++;
            }else{
                //sum < N;
                end_index++;
                sum +=end_index;
            }
        }

        System.out.println(cnt);
    }

    //주몽갑옷 - 1940
    private static void two_pointer_02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //재료의 갯수
        int M =Integer.parseInt(br.readLine()); //갑옷이 만들어지는 번호의 합

        int arrN[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
//        for(int i : arrN){
//            System.out.println(i);
//        }

        int start_index = 0;
        int end_index = N-1;
        int cnt = 0;
        while (start_index < end_index){
            if(arrN[start_index] + arrN[end_index] == M){
                //cnt +
                cnt ++;
                start_index++;
                end_index--;
            }else if(arrN[start_index] + arrN[end_index] < M){
                start_index++;
            }else{
                //넘어간 경우 >M
                end_index--;
            }
        }

        System.out.println(cnt);
    }
    // 좋은 수 찾기  - 1253
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
