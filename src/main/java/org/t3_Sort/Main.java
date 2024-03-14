package org.t3_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //수정렬 하기 - 2750
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