package org.t4_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test2 {
    //친구 관계 파악하기 DFS , 13023
    // a-> b -> c -> d -> e --> depth 5 인문제

    static ArrayList<Integer>[] dataArr; //관계 저장용
    static boolean[] visted; // visted 체크용
    static boolean checkRes; // 결과확인용
    private static void dfs_03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드갯수
        int M = Integer.parseInt(st.nextToken()); //에지 갯수

        //초기화
        dataArr = new ArrayList[N];
        visted = new boolean[N];
        checkRes = false;

        for(int i=0; i<N; i++){
            dataArr[i] = new ArrayList<Integer>();
        }

        //a, b
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dataArr[a].add(b);
            dataArr[b].add(a);
        }

        for(int i =0; i<N; i++){
            dfs_03_dfs(i,1);
            if(checkRes) break;
        }
        if(checkRes) System.out.println(1);
        else System.out.println(0);

    }

    private static void dfs_03_dfs(int value , int depth){
        if(depth == 5 || checkRes){
            checkRes = true;
            return;
        }
        visted[value] = true;
        for(int i : dataArr[value]){
            if(! visted[i]){
                dfs_03_dfs(i , depth+1);
            }
        }
        visted[value] = false;


    }
    public static void main(String[] args) throws IOException {
        dfs_03();
    }
}
