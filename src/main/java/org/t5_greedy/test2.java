package org.t5_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test2 {

    // 백준1715
    private static  void greedy_02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int []arrN = new int[n];

        for(int i=0; i<n; i++){
            arrN[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arrN);

        for(int i=0; i<n; i++){
            deque.add(arrN[i]);
        }

        int start = 0;
        int pollData;
        int pollData2;
        int res = 0;
        while (start+1 < n){
            //첫번째 값은 꺼내고 두번째값은 peek;
           pollData = deque.poll();
           pollData2 = deque.poll();
           int tempRes = pollData+pollData2;
           res += tempRes;
            deque.addFirst(tempRes);
           start++;
        }

        System.out.println(res);

    }
    private static  void greedy_02_e() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int totalComparisons = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            totalComparisons += sum;
            pq.add(sum);
        }

        System.out.println(totalComparisons);
    }
    public static void main(String[] args) throws IOException {
        greedy_02();
    }
}
