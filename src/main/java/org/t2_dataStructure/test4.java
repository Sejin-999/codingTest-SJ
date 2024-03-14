package org.t2_dataStructure;

import java.io.*;
import java.util.*;

public class test4 {
    //Stack & queue

    /**
     * stack
     * 후입 선출 - LIFO -> last 에 들어온 애를 먼저 뺀다.
     * top -> 연산이 작용하는 위치 가장위에
     * pop -> 삭제하고 확인
     * push -> 추가
     * peek -> 탑에 있는 데이터를 확인
     * DFS -> depth first search -> 깊이 우선탐색
     * 후입선출 == 재귀함수 -> 일맥상통하다.
     */

    /**
     * Queue
     * 선입선출 -> FIFO -> first 먼저 들어온애를 먼저 처리한다.
     * rear -> 가장 끝 데이터
     * front -> 가장 처음 데이터
     * add -> rear에 추가하기
     * poll -> front에 있는 데이터 확인 및 제거
     * peek -> front에 있는 데이터 확인
     * BFS -> breadth first search -> 넓이 우선탐색
     */

    //스택으로 오름차순 수열 만들기 / 1874

    private static void stack_01(){
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int A[] = new int[n]; // stack
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        StringBuffer sb = new StringBuffer();
        int num =1;
        boolean res = true;

        for(int i=0; i<n; i++){
            int check = A[i];

            if(check >= num){
                while (check >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else{
                //check < num
                int checkN = stack.pop();
                if(checkN > check){
                    System.out.println("NO");
                    res = false;
                    break;
                }else{
                    sb.append("-\n");
                }

            }
        }

        if(res){
            System.out.println(sb.toString());
        }

    }
    //오큰수 구하기 17298
    private static void stack_02() throws IOException {
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arrN = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            while (!stack.empty() && arrN[stack.peek()]< arrN[i]){
                arrN[stack.pop()] = arrN[i];
            }
            stack.push(i);
        }
        while(!stack.empty()){
            arrN[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<n; i++){
            bw.write(arrN[i] + " ");
        }
        bw.flush();
    }
    //card game / 2164
    private static void stack_03(){
        Queue<Integer> queue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 1; i <=n; i++){
            queue.add(i);
        }

        while (queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        //size 1
        System.out.println(queue.peek());
    }
    public static void main(String[] args) throws IOException {
        stack_03();
    }

}
