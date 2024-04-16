package org.t5_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static  void greedy_03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int res = 0;

        int oneCnt = 0;
        int zeroCnt = 0;
        /** 분류 시작**/
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp < 0){
                //음수인경우
                minusQueue.add(temp);
            } else if (temp == 0) {
                zeroCnt++;
            } else if (temp ==1) {
                oneCnt++;
            }else{
                //양수인경우
                plusQueue.add(temp);
            }
        }
        /** 분류 종료**/

        //양수
        while (plusQueue.size()>1){
            int f = (int) plusQueue.remove();
            int s = (int) plusQueue.remove();
            res += f*s;
        }
        if(!plusQueue.isEmpty()){
            res += (int)plusQueue.remove();
        }

        while (minusQueue.size()>1){
            int f = minusQueue.remove();
            int s = minusQueue.remove();
            res += f*s;
        }

        if(!minusQueue.isEmpty()){
            if(zeroCnt ==0){
                res += minusQueue.remove();
            }
        }

        res += oneCnt;

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        greedy_03();
    }
}
