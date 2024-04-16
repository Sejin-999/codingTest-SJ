package org.t3_Sort;

import java.io.*;
import java.util.*;

public class Main {
    private static void test() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [] arrN = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);

        System.out.println(arrN[k-1]);


    }

    public static void main(String[] args) throws IOException {
        test();
    }

}