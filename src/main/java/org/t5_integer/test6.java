package org.t5_integer;

import java.io.*;
import java.util.StringTokenizer;

//백준1850
public class test6 {
    private static  void integer_06() throws IOException {
        //최대공약수 구하기 - > mod연산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long a = Long.valueOf(st.nextToken());
        Long b = Long.valueOf(st.nextToken());

        Long res = mod(a,b);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<res; i++){
            bw.append("1");
        }
        bw.flush();

    }
    private static Long mod (Long a , Long b){
        if(b == 0){
            return a;
        }else{
            return mod(b,a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        integer_06();
    }
}
