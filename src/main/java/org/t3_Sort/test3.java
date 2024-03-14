package org.t3_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test3 {
    //삽입정렬
    //이미 정렬된 데이터 범위에 정렬되지않은 데이터를 적절한 위치에 삽입하여 정렬하는 방법
    // O(n^2) + 이진탐색 같은 탐색알고리즘을을 함께 사용하면 시간을 줄일 수 있따.
    /**
     * 현재 index에 있는 데이터 값을 선택한다.
     * 현재 선택한 데이터가 정렬된 데이터 범위에 삽일될 위치를 탐색한다.
     * 삽입 위치부터 index가 있는 위치까지 shift연산을 수행한다.
     * 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행한다.
     * 전체 데이터의 크기만큼 index가 커질때 -> 끝날때까지 반복한다.
     */
    // ATM 인출시간 계산하기 - 11399
    private static void insert_01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //데이터의 개수
        StringTokenizer st= new StringTokenizer(br.readLine());
        int arrN[] = new int[N];
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        //setting end

        // insert sort start
        for(int i=1; i<N; i++){
            int insert_p = i;
            int insert_v = arrN[i];

            //삽입될 위치를 탐색 -> 자신보다 작은값이 있는곳 전까지 동작
            for(int j = i-1 ; j>=0; j--){
                if(insert_v > arrN[j]){
                    //들어올값보다 작은 경우
                    insert_p = j+1; //들어올값 다음번에 지정
                    break; //찾았으니 for문 탈출
                }
                if(j ==0){
                    //찾지 못하고 계속돔 -> 지금 찍힌값이 가장 작은값이라는 뜻
                    insert_p =0;
                }
            }

            //shift 연산을 통해 자리를 만들어주기
            for(int j=i; j>insert_p; j--){
                arrN[j] = arrN[j-1];
            }

            arrN[insert_p] = insert_v;
        }
        // insert sort end
        // 문제 풀이를 위한 합배열 작성
        int [] arrS = new int[N];

        arrS[0] = arrN[0]; //초기값 설정
        for(int i=1; i<N; i++){
            //왜이렇게 하냐면 0부터 시작하는경우 이전값을 선택하지못하기 때문에 런타임뜸
            arrS[i] = arrS[i-1]+ arrN[i];
        }
        int sum =0; // 최종 값 구하기
        for(int i=0; i<N; i++){
            sum += arrS[i];
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        insert_01();
    }
}
