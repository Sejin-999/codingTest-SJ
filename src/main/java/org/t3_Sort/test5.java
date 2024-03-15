package org.t3_Sort;

import java.io.*;
import java.util.StringTokenizer;

public class test5 {
    //merge sort 병합 정렬 : 분할 정복 방식을 사용해 데이터를 분할하고 분할한 데이터정렬하는 알고리즘
    //O(nlogn)

    /**
     * 최소그룹으로나누기 (2)
     * 투포인트 방식을 사용해 그룹별로 정렬 시키기
     *
     */

    public static int arrN[];
    public static int temp[];
    private static void merge_01() throws IOException {
        //setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
       arrN = new int[N+1];
       temp = new int[N+1];
        for(int i=1; i<=N; i++){
            arrN[i] = Integer.parseInt(br.readLine());
        }

        merge_01_mergeSort(1 , N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int  i=1; i<=N; i++){
            bw.write(arrN[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge_01_mergeSort(int start , int end){
        if(end -start <1){
            //종료값
            return;
        }
        int mid = start + (end-start)/2;
        merge_01_mergeSort(start ,mid);
        merge_01_mergeSort(mid+1 , end);

        for(int i=start; i<=end; i++){
            temp[i] = arrN[i];
        }
        int point = start;
        int index1 = start;
        int index2 = mid+1;
        while (index1 <= mid && index2 <= end){
            if(temp[index1] < temp[index2]){
                arrN[point] = temp[index1];
                point++;
                index1++;
            }else{
                //index1 > index2
                arrN[point] = temp[index2];
                point++;
                index2++;
            }
        }

        //선택되지 않은 나머지값들 정리
        while (index1 <= mid){
            arrN[point] = temp[index1];
            point++;
            index1++;
        }
        while (index2 <= end){
            arrN[point] = temp[index2];
            point++;
            index2++;
        }
    }
    //버블 소트 프로그램 //1517
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
                point++;
                index2++;
                result+= index2-point;
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
