package org.t3_Sort;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int arrN2[];
    public static int temp2[];
    public static int result;
    private static void merge_02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        arrN2= new int[N+1];
        temp2 = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        result =0;

        for(int i=1; i<=N; i++){
            arrN2[i] = Integer.parseInt(st.nextToken());
        }

        merge_02_mergeSort(1 , N);

        System.out.println(result);

    }

    private static void merge_02_mergeSort(int start , int end){
        if(end - start <1){
            return;
        }

        int mid = start + (end -start)/2;

        merge_02_mergeSort(start, mid);
        merge_02_mergeSort(mid+1 , end);


        for(int i =start ; i<=end;i++){
            temp2[i] = arrN2[i];
        }

        int point =start;
        int index1 = start;
        int index2 = mid+1;

        while (index1 <= mid && index2 <= end){
            if(temp2[index1] < temp2[index2]){
                arrN2[point] = temp2[index1];
                point++;
                index1++;
            }else{
                //index1 > index2
                arrN2[point] = temp2[index2];
                result+= index2-point;
                point++;
                index2++;

            }
        }

        while (index1 <= mid){
            arrN2[point] = temp2[index1];
            point++;
            index1++;
        }
        while (index2 <= end){
            arrN2[point] = temp2[index2];
            point++;
            index2++;
        }
    }
    public static void main(String[] args) throws IOException {
        merge_02();
    }
}