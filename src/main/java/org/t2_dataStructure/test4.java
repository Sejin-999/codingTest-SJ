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
    private static void queue_01(){
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
