package org.t3_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2 {
    //선택정렬
    //최대나 최소 데이터를 데이터가 나열된 순으로 찾아가 며 선택하는 방법
    //O(n^2)

    /**
     * 남은 정렬 부분에서 최솟값 또는 최댓값을 찾는다
     * 남은 정렬 부분에서 가장 앞에있는 데이터와 선택된 데이터를 swap한다.
     * 가장 앞에있는데이터의 위치를 번경해 남은 정렬 부분의 범위를 축소한다.
     * 전체 데이터 크기 만큼 index가 커질때까지 , 남은 부분이 없을때까지 반복
     */

    private static void select_01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sr = br.readLine();
        int arrN[] = new int[sr.length()];

        for(int i=0; i<sr.length(); i++){
            arrN[i]= Integer.parseInt(sr.substring(i , i+1));
        }

        for(int i=0; i<sr.length(); i++){
            int max = i;
            for(int j=i+1; j<sr.length(); j++){
                //최댓값 찾기
                if(arrN[j] > arrN[max]){
                    max = j;
                }
            }

            //남은 정렬 부분에서 앞 데이터와 swap 하는과정
            //내림차순정렬이니까 큰값이 앞으로 가야함
            if (arrN[i] < arrN[max]) {
                int temp = arrN[i];
                arrN[i] = arrN[max];
                arrN[max] = temp;
            }
        }

        for(int i=0; i<sr.length(); i++){
            System.out.print(arrN[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        select_01();
    }
}
