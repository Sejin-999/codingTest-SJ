package org.t3_Sort;

import java.io.IOException;
import java.util.Scanner;

public class test1 {
    //버블 정렬
    // data의 인접요소 끼리 비교하여 Swap 연산으로 정렬하는 방식
    // O(n^2) , 루프를 돌며 인접한 데이터간의 Swap 연산으로 정렬

    /**
     * 동작방식
     * 1. 비교연산할 루프 범위 지정
     * 2. 인접한데이터끼리 비교
     * 3. Swap 조건에 만족하면 Swap
     * 4. 루프종료까지 반복
     * 5. 정렬영역설정 , 루프종료후 해당영역은 제외
     * 6. 1~5까지 정렬이 완료 될때 까지 반복
     */

    //수정렬 하기 - 2750
    private static void bubble_01(){
        //sort 함수가 있긴 하지만 , 사용하지않음
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arrN = new int[N];
        for(int i=0; i<N; i++){
            arrN[i] = sc.nextInt();

        }
        //오름차순으로 버블정렬을 이용해 구현해보자
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i ; j++){
                if(arrN[j] > arrN[j+1]){
                    int temp = arrN[j];
                    arrN[j] = arrN[j+1];
                    arrN[j+1] = temp;
                }
            }
        }

        for(int i=0; i<N; i++){
            System.out.println(arrN[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        bubble_01();
    }
}
