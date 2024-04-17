package org.t5_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test4 {

    // 백준11047
    private static  void greedy_04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());

        int [][] arrN = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrN[i][0] = start;
            arrN[i][1] = end;
        }
        Arrays.sort(arrN, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){//종료시간이 같은경우
                    return o1[0] - o2[0]; // 시작시간이 빠른순으로
                }
                return o1[1] - o2[1];
            }
        });
        int cnt =0;
        int end = -1;
        for(int i=0; i<n; i++){
            if(arrN[i][0] > end){
                end = arrN[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        greedy_04();
    }
}
