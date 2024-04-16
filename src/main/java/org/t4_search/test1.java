package org.t4_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test1 {
    //백준 11724
    // dfs : depth first search
    static ArrayList<Integer>[] dataArr;
    static boolean[] visted;
    private static void dfs_01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 에지 개수
        int cnt = 0; // 문제의 연결요소를 구하기 위해 최초의 dfs 가 몇번 실행되는지 체크
        dataArr = new ArrayList[N+1]; // 크기 초기화
        visted = new boolean[N+1]; // 크기 초기화

        //값 초기화
        for(int i=1; i < N+1; i++){
            dataArr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //방향없는 그래프인 경우 양쪽 다 넣어줘야됨
            dataArr[u].add(v);
            dataArr[v].add(u);
        }
        for(int i=1; i<N+1; i++){
            if(!visted[i]){
                cnt++;
                dfs_01_dfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs_01_dfs(int i){
        if(!visted[i]){
            //확인하지 않은 값인 경우만
            visted[i] = true;
            for(int value : dataArr[i]){
                if(!visted[value]){
                    //확인하지 않은 경우
                    dfs_01_dfs(value);
                }
            }
        }else{
            //이미 확인한 값임
            return;
        }
    }

    //백준 , 2023 , 신기한 소수
    static int n;

    private static void dfs_02() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs_02_dfs(2, 1);
        dfs_02_dfs(3, 1);
        dfs_02_dfs(5, 1);
        dfs_02_dfs(7, 1);
    }

    private static void dfs_02_dfs(int number, int digit) {
        if (digit == n) {
            System.out.println(number);
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            if (dfs_02_find_prime(number * 10 + i)) {
                dfs_02_dfs(number * 10 + i, digit + 1);
            }
        }
    }

    private static boolean dfs_02_find_prime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        dfs_02();
    }
}
