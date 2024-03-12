package org.t2_dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test1 {
    //자료구조
    /**
     * 배열 - 메모리의 연속공간의 값이 채워지는 형태 ,
     * 인덱스를 통해 참조하며 미리 선언된 자료형값만 저장할 수 있다. -> int[] -> int type 이 가능하고 , int[0] 부르듯 해당하는값이 인덱스
     * 특징 , 특정 인덱스값 삭제가어렵고 , 크기를 선언 , 선언한 크기를 줄이거나 키울수 없음 -> 유연성이부족하지만 효율적으로 자원을 사용할 수 있다.
     */
    /**
     * 리스트 - 리스트값과 포인터로 묶은 노드를 포인터로 연결한 구조
     * 인덱스가없다 (기본구조는) -> 헤더부터 접근해야하므로 값에 접근하는게 배열의 인덱스를 활용하는 방법처럼 빠르지 못하고 느리다.
     * 연산에 유리하다 . 크기가 정해지지않는다.
     * -> 인덱스에 비해 유동적인 값들이 들어오거나 (연산이 많은 경우) , 크기가 명확하지않은 데이터를 다룰때 유리하다.
     */
    //숫자의 합 구하기 - 11720
    private static void sumNumber_1() {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();

        char[] cArr = c.toCharArray();

        int sum = 0;
        for(int i = 0; i < cArr.length; i++ ){
            sum += cArr[i] - '0';
        }
        System.out.println(sum);
    }

    //평균 구하기 - 1546
    private static void avgNumber_1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            int an = sc.nextInt();
            arr[i] = an;
        }

        long sum=0;
        long max=0;
        for(int i=0; i<n; i++){
            if(arr[i] > max){ max = arr[i];}
            sum += arr[i];
        }

        System.out.println(sum *100.0 /max/n);
    }
   // 구간 합 구하기 - 11659
    private static void sum_arr_1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        Long[] S = new Long[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        S[0] = 0L; // 초기값 설정
        for (int i = 1; i <= N; i++) {
            // 합배열 만들기
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int q = 0; q < M; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }

    }
    //구간합 구하기 2 - 11660
    private static void sum_arr_2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int [][] arrN = new int[N+1][N+1]; // 원본 배열 ,arrNew
        int [][] arrS = new int[N+1][N+1]; // 합 배열 , arrSum

        //원본 배열 저장
        for(int i=1; i<=N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1; j<=N; j++){
                arrN[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        //합 배열 저장
        /**
         * 이전 행 , 이전 열 값 (+) 기존 값 (-) 이전행&이전열
         */
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arrS[i][j] = arrS[i-1][j]+arrS[i][j-1]+arrN[i][j]-arrS[i-1][j-1];
            }
        }
        for(int i=0; i<M; i++){
            //질의 받기
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int res = arrS[x2][y2] - arrS[x2][y1-1] - arrS[x1-1][y2] + arrS[x1-1][y1-1];

            System.out.println(res);
        }

    }
    //나머지 합 구하기 - 10986
    private static void sum_arr_3() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int cnt = 0; //res 값
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int arrN[] = new int[N];
        int arrC[] = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N;i++){
            arrN[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        //합배열 만들기
        int arrS[] = new int[N];
        arrS[0] = arrN[0];

        for(int i=1; i<N; i++){
            arrS[i] = arrN[i]+arrS[i-1];
        }

        //나누어 떨어지는 경우 찾기
        for(int i=0; i<N; i++){
            int c = arrS[i] %M;

            if(c==0){
                cnt++;
            }

            arrC[c]++;

        }
        for(int i=0; i<M; i++){
            if(arrC[i] > 1){
                //경우가 2개 이상인 경우만..
                //경우의 수 구하는 공식..
                /**
                 * 이때 사용된 공식은 조합(combination)의 공식
                 * 공식: nC2 = n! / (2! * (n-2)!)
                 * 여기서 n!는 팩토리얼이며, n! = n * (n-1) * (n-2) * ... * 1 입니다.
                 * 2!는 2 * 1로 계산됩니다. 따라서 nC2는 n(n-1)/2 가 됩니다
                 */
                cnt = cnt + (arrC[i] *(arrC[i]-1) /2);
            }
        }

        System.out.println(cnt);

        //백준에 올린코드..
        /**
         import java.io.BufferedReader;
         import java.io.IOException;
         import java.io.InputStreamReader;
         import java.util.StringTokenizer;

         public class Main {
         public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         // 입력 받기
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());

         st = new StringTokenizer(br.readLine());
         int[] arr = new int[N];
         for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
         }

         // 부분 합 배열 만들기
         long[] prefixSum = new long[N + 1];
         for (int i = 1; i <= N; i++) {
         prefixSum[i] = (prefixSum[i - 1] + arr[i - 1]) % M;
         }

         // 나머지가 같은 부분 합의 개수 세기
         long[] count = new long[M];
         for (int i = 0; i <= N; i++) {
         count[(int) prefixSum[i]]++;
         }

         // 나머지가 같은 부분 합에서 2개를 선택하는 경우의 수 계산
         long result = 0;
         for (int i = 0; i < M; i++) {
         result += (count[i] * (count[i] - 1)) / 2;
         }

         System.out.println(result);
         }
         }

         */
    }

    public static void main(String[] args) throws IOException {
        sum_arr_3();
    }


}
