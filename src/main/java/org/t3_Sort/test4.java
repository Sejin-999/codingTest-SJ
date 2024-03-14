package org.t3_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test4 {
    //퀵정렬
    //pivot(기준값)을 선정해 해당 값보다 작은 데이터와 큰데이터를 분류 -> 반복
    //O(nlogn)
    /**
     * pivot을 설정한다
     * 피봇을 기준으로 두개의 데이터 집합으로 분류한다. -> 피봇보다 큰애 작은애
     *  - start 가 가르키는 데이터가 pivot이 가르키는 데이터보다 작으면 start를 오른쪽으로 한칸이동시킨다.
     *  - end 가 가르키는 데이터가 pivot이 가르키는 데이터보다 크면 end를 왼쪽으로 한칸 이동시킨다.
     *  - start가 가르키는 데이터가 pivot 보다 크고, end가 가르키는 데이터가 pivot 보다 작으면 해당 데이터를 swap한다.
     *  그리고 start는 오른쪽으로한칸 end는 왼쪽으로 한칸 이동시킨다.
     *  - start와 end가 만날때까지 반복한다. 이때 만나는 데이터의 크기가 피봇보다 크면 오른쪽에 작으면 왼쪽에 데이터를 삽입한다.
     *  -> 이후 다시 피봇을 선정하고 , 분리 집합이 1개가 될때까지 반복한다.
     */
    //k번째 수 구하기 11004

    private static void quick_01_v() throws IOException {
        //단순히 구하는 건 쉬운듯
        //일케하면 시간초과뜸
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //데이터의 개수
        int K = Integer.parseInt(st.nextToken()); //K번째 수

        st = new StringTokenizer(br.readLine());
        int arrN[]= new int[N];
        for(int i=0; i<N; i++){
            arrN[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        System.out.println(arrN[K-1]);
    }
    private static void quick_01() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //데이터의 개수
        int K = Integer.parseInt(st.nextToken()); //K번째 수

        st = new StringTokenizer(br.readLine());
        int arrN[]= new int[N];
        for(int i=0; i<N; i++){
            arrN[i]= Integer.parseInt(st.nextToken());
        }

        //setting end

        /**
         * 피봇정하기
         * pivot == K -> k번째에 있는 수를 찾을때
         * pivot > K -> 왼쪽부분만 수행
         * pivot < K -> 오른쪽 부분만 수행
         */

        //K 번째를 찾는 문제임으로 중앙값을 설정

        quick_sort(arrN , 0 , N-1 , K-1);
        System.out.println(arrN[K-1]);
    }
    public static void quick_sort(int[]arrN , int start_p , int end_p , int K){
        if(start_p < end_p){
            int pivot = partition(arrN , start_p , end_p);
            if(pivot == K){
                return;
                //피봇이 K값이라는건 더이상 구할 필요가없다는뜻
                // break처럼 쓴건데 되나?
            } else if (pivot < K) {
                //왼쪽 부분만 수행하면됨
                quick_sort(arrN , start_p , pivot-1 , K);
            }else{
                // pivot > K -> 오른쪽 부분만 수행하면됨
                quick_sort(arrN , pivot+1 ,end_p, K);
            }
        }
    }

    public static int partition(int []arrN , int start_p , int end_p){
        if(start_p+1 == end_p){
            //만나는 지점에 있는
            if(arrN[start_p] > arrN[end_p]){
                //스왑해야하는 경우
                swap(arrN, start_p, end_p);
            }
            return end_p;
        }

        int avg = (start_p + end_p)/2;

        swap(arrN, start_p, avg);

        int pivot = arrN[start_p];
        int i = start_p+1;
        int j = end_p;
        while (i <=j){
            while (j >= start_p+1 && pivot < arrN[j]){
                j--;
            }
            while (i <= end_p && pivot > arrN[i]){
                i++;
            }
            if(i <=j){
                swap(arrN , i++ , j--);
            }
        }

        arrN [start_p]= arrN[j];
        arrN[j] = pivot;
        return j;
    }
    public static void swap(int [] arrN , int start_p , int end_p){
        int temp = start_p;
        arrN[start_p] = arrN[end_p];
        arrN[end_p] = temp;
    }
    public static void main(String[] args) throws IOException {
        quick_01();
    }
}
