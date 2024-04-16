package org.t5_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test3 {

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

        /** 마이너스 우선순위 큐 시작**/
        if(minusQueue.size()%2 ==0){
            //크기가 짝수인경우
            while (!minusQueue.isEmpty()){
                res += minusQueue.poll()*minusQueue.poll();
            }

        }else{
            //홀수인 경우
            while (minusQueue.size() >1){
                res += minusQueue.poll()*minusQueue.poll();
            }
            if(zeroCnt !=0){
                res += minusQueue.poll()*0;
            }
        }
        /** 마이너스 우선순위 큐 종료**/
        /** 플러스 우선순위 큐 시작**/
        if(plusQueue.size()%2 ==0){
            //큐 사이즈가 짝수인경우
            while (!plusQueue.isEmpty()){
                res += ((int) plusQueue.poll()) * ((int) plusQueue.poll());
            }
        }else{
            //큐 사이즈가 홀수인 경우
            while (plusQueue.size() >1){
                res += ((int) plusQueue.poll()) * ((int) plusQueue.poll());
            }
            res += (int)plusQueue.poll();
        }
        /** 플러스 우선순위 큐 종료**/
        /** 나머지 1 카운트 플러스**/
        res+= oneCnt;

        System.out.println(res);
    }

    //crt
    private static  void greedy_03_e() throws IOException {
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
