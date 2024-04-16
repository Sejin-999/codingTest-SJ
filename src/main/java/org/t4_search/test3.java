package org.t4_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test3 {
    // DFS & BFS , 1260

    static ArrayList<Integer>[] dataArr;
    static boolean[] visted;
    private static void bfs_01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        //초기화
        dataArr = new ArrayList[n+1];
        visted = new boolean[n+1];

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
        //작은거부터 방문해야힘; -> 문제조건임
        for(int i=1; i<n+1; i++){
            Collections.sort(dataArr[i]);
        }
        bfs_01_dfs(start);
        System.out.println("");
        //초기화
        visted = new boolean[n+1];
        bfs_01_bfs(start);

    }
    private static void bfs_01_dfs(int node){
        System.out.print(node + " ");
        visted[node] =true;
        for(int i : dataArr[node]){
            if(! visted[i]) bfs_01_dfs(i);
        }
    }
    private static void bfs_01_bfs(int node){
        visted[node] =true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int i : dataArr[now]){
                if(! visted[i]){
                    visted[i] =true;
                    queue.add(i);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        bfs_01();
    }
}
