package org.t2_dataStructure;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test3 {

    //슬라이딩 윈도우
    //최솟값 찾기 - 11003
    private static void sliding_02() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<NodeX> myDeque = new LinkedList<>();

        for(int i=0; i<N; i++){
            int newValue = Integer.parseInt(st.nextToken());
            while (!myDeque.isEmpty() && myDeque.getLast().value > newValue){
                myDeque.removeLast();
            }
            myDeque.addLast(new NodeX(newValue , i));
            //범위설정
            if(myDeque.getFirst().index <= i-L){
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value+" ");

        }
        bw.flush();
        bw.close();
    }

    static class NodeX{
        public int value;
        public int index;

        NodeX(int value , int index){
            this.value = value;
            this.index = index;
        }
    }

    //슬라이딩 윈도우
    //DNA비밀번호  - 12891

    static int arrMy[] = new int[4];
    static int arrCheck[] = new int[4];
    static int checkFlag = 0; // checkFlag 가 4 가되면 스탑// 유효하다는 뜻
    static int res = 0;
    private static void sliding_01() throws IOException {
        //ACGT

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char arrN[] = new char[S];
        arrN = br.readLine().toCharArray();

        st= new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            arrCheck[i] = Integer.parseInt(st.nextToken());
            if(arrCheck[i] == 0){
                //검사하지 않아도 되는경우
                checkFlag++;
            }

            //myArr 초기화
            arrMy[i] = 0;
        }

        for(int i=0; i<P; i++){
            checkPass(arrN[i]);
        }
        if(checkFlag ==4) res++;
        for(int i=P; i<S; i++){
            int j= i-P;
            checkPass(arrN[i]);
            checkRemove(arrN[j]);
            if(checkFlag == 4) res++;
        }

        System.out.println(res);
    }

    private static void checkPass(char checkCh){
        switch (checkCh){
            case 'A':
                arrMy[0]++;
                if(arrMy[0] == arrCheck[0]) checkFlag++;
                break;

            case 'C':
                arrMy[1]++;
                if(arrMy[1] == arrCheck[1]) checkFlag++;
                break;

            case'G':
                arrMy[2]++;
                if(arrMy[2] == arrCheck[2]) checkFlag++;
                break;

            case'T':
                arrMy[3]++;
                if(arrMy[3] == arrCheck[3]) checkFlag++;
                break;

        }
    }

    private static void checkRemove(char checkCh){
        switch (checkCh){
            case 'A':
                if(arrMy[0] == arrCheck[0]) checkFlag--;
                arrMy[0]--;
                break;

            case 'C':
                if(arrMy[1] == arrCheck[1]) checkFlag--;
                arrMy[1]--;
                break;

            case'G':
                if(arrMy[2] == arrCheck[2]) checkFlag--;
                arrMy[2]--;
                break;

            case'T':
                if(arrMy[3] == arrCheck[3]) checkFlag--;
                arrMy[3]--;
                break;

        }
    }
    public static void main(String[] args) throws IOException {
        sliding_02();
    }
}
