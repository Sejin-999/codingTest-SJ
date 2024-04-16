package org.t4_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] dataArr;
    static boolean[] visited;
    private static void bfs_01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        //초기화
        dataArr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<n+1; i++){
            dataArr[i] = new ArrayList<>();
        }
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dataArr[a].add(b);
            dataArr[b].add(a);
        }
        //작은거부터 방문해야힘;
        for(int i=1; i<n+1; i++){
            Collections.sort(dataArr[i]);
        }

        bfs_01_dfs(start);
        System.out.println("");
        //초기화
        visited = new boolean[n+1];
        bfs_01_bfs(start);

    }
    private static void bfs_01_dfs(int node){
        System.out.print(node + " ");
        visited[node] =true;
        for(int i : dataArr[node]){
            if(! visited[i]) bfs_01_dfs(i);
        }
    }
    private static void bfs_01_bfs(int node){
        visited[node] =true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int i : dataArr[now]){
                if(! visited[i]){
                    visited[i] =true;
                    queue.add(i);
                }
            }
        }

    }
    public static void main(String[] args) {
        // Thread 클래스 상속
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1: " + i);
                }
            }
        };

        // Runnable 인터페이스 구현
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2: " + i);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
