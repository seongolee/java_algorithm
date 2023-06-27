package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 카드 2
* 문제 : 마지막 한장이 남을때까지 아래의 로직을 실행한다.
* 1. 제일 위에 있는 카드를 바닥에 버린다.
* 2. 제일위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
*
* 여기서 문제는 마지막 한장이 남을때까지 반복하는게 포인트.
* 조건 1과 2를 분리해서 로직을 만들어도 되지만 조건 2의 같은 경우는 로직이 돌아가도 카드의 개수에 영향을 주지 않기떄문에,
* 한번에 묶어서 처리하면 좀 더 깔끔하게 처리가 가능함.
* */

public class P2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        if(N == 1){
            System.out.println(N);
            return;
        }

        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1){
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());
    }
}
