package org.t3_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//merge sort / 1517 -> 5에 있던 내용 수정해서 풀어봄.. 지저분한거 다합쳐버림
public class test5_1 {
    public static int arrN[];
    public static int temp[];
    public static long result;

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arrN[i] <= arrN[j]) {
                temp[k++] = arrN[i++];
            } else {
                temp[k++] = arrN[j++];
                result += mid - i + 1; // 왼쪽 배열의 남은 원소 개수만큼 결과에 더해준다.
            }
        }

        while (i <= mid) {
            temp[k++] = arrN[i++];
        }
        while (j <= end) {
            temp[k++] = arrN[j++];
        }

        for (int index = start; index <= end; index++) {
            arrN[index] = temp[index];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arrN = new int[N + 1];
        temp = new int[N + 1];
        result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);

        System.out.println(result);
    }
}
