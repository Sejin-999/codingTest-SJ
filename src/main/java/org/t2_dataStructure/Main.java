package org.t2_dataStructure;

import java.io.*;
import java.util.*;

public class Main {
    private static void queue_02(){
        PriorityQueue<Integer> queue = new PriorityQueue<>((a1,a2) ->{
            int first_abs = Math.abs(a1); //absolute value , 절대값이라는 뜻임
            int second_abs = Math.abs(a2);

            if(first_abs == second_abs){
                return a1> a2 ? 1: -1;
            }else{
                return first_abs-second_abs;
                /**
                 * 절대값기준
                 * a1 - a2 일때 양수가 나오면 a1이 a2보다 크다는 것임 -> 즉 a2가 먼저 우선순위에 올라가고 그 이후 a1임
                 * a1 - a2 일때 음수가 나오면 a2가 a1보다 크다는 것임 -> 즉 a1이 먼저 우선순위에 올라가고 그 이후 a2가 올라감
                 * 위 비교연산자도 동일한 원리
                 */
            }
        });

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=1; i<=N; i++){
            int x = scan.nextInt();

            /**
             * todo
             * x == 0 -> poll 하기 , 만약 비어있는경우 0을 출력
             * x != 0 -> add 하기
             */

            if(x ==0){
                if(queue.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.add(x);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        queue_02();
    }
}