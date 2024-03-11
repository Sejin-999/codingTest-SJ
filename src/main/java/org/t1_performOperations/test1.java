package org.t1_performOperations;

public class test1 {
    /**
     * 표기법
     * 빅오 : 최악의 경우 연산횟수 -> 사용할 표기법 , 최악의 경우를 고려해야한다.
     * 빅오메가 : 최선의 연산횟수
     * 빅세타 : 보통의 연산횟수
     */
    // 초당 1억번의 계산 즉, 2초가 주어진다면 2억번내의 계산이 완료되어야 한다.
    // 연산횟수 계산법 : 알고리즘 시간복잡도 X 데이터의 크기
    // 알고리즘 시간 복잡도란 결국 가장 많이 중첩된 반복문의 크기 (상수는 제외한다.)
    // -> 엄청나게 많아지면 상수 또는 가장 많이 중첩된 반복문의 크기 만큼 의미를 주지 않기때문에

    private static void performOperations_1() {
        int N = 10000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            //System.out.println("test  : " + cnt++);
        }
    }

    private static void performOperations_2() {
        int N = 10000;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            //System.out.println("test : " + cnt++);
        }
        for (int i = 0; i < N; i++) {
           // System.out.println("test  : " + cnt++);
        }
        for (int i = 0; i < N; i++) {
            //System.out.println("test : " + cnt++);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1");
        long startTime1 = System.nanoTime();
        performOperations_1();
        long endTime1 = System.nanoTime();
        long elapsedTime1 = endTime1 - startTime1;
        double seconds1 = (double) elapsedTime1 / 1_000_000_000.0;
        System.out.println("Execution time for Test 1: " + seconds1 + " seconds");

        System.out.println("Test 2");
        long startTime2 = System.nanoTime();
        performOperations_2();
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime2 - startTime2;
        double seconds2 = (double) elapsedTime2 / 1_000_000_000.0;
        System.out.println("Execution time for Test 2: " + seconds2 + " seconds");
    }


}
