package org.t2_dataStructure;

import java.io.*;
import java.util.*;

public class Main {
    private static void stack_03(){
        Queue<Integer> queue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for(int i = 1; i <=n; i++){
            queue.add(i);
        }

        while (queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        //size 1
        System.out.println(queue.peek());
    }
    public static void main(String[] args) throws IOException {
        stack_03();
    }

}