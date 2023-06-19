package baekjoon.silver5;

import java.util.Scanner;

/*
* 풀면서 느낀점은 입력 조건을 잘 보아야 한다.
*  1. 입력조건이 0 <= N <= 500 이기떄문에 int 형으로 팩토리얼을 계산해서 푸는 형식으로 접근하면 풀 수가 없다.
*  2. 2 * 5 = 10 즉, 2와 5의 짝이 맞는 갯수를 찾으면 된다.
*  */

/*
* 다른 사람의 풀이
* 팩토리얼 특성상 5의 개수가 2의 개수보다 무조건 작기 때문에 5의 수만 카운트하면 된다.
*  */

public class P1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int two = 0, five = 0; // 2의 개수와, 5의 개수를 담을 변수

        for (int i = 1; i <= N; i++) {
            int num = i;

            while (num % 2 == 0) { // 2의 개수 파악
                two++;
                num /= 2;
            }

            while (num % 5 == 0) { // 5의 개수 파악
                five++;
                num /= 5;
            }
        }

        System.out.println(Math.min(two, five)); // 짝이 맞는 갯수를 출력해야 하기 때문에, 둘중에 작은 값을 출력해준다.
    }
}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int quotient; // 몫
//        int remainder; // 나머지
//        int count = 0; // 0의 개수를 카운트 변수
//
//        quotient = factorial(N);
//
//        System.out.println(quotient);
//
//        while(true) {
//            if(quotient < 10)
//                break;
//
//            remainder = quotient % 10;
//            quotient /= 10;
//
//            if(remainder == 0) {
//                count++;
//            }else {
//                break;
//            }
//        }
//
//        System.out.println(count);
//    }
//
//    static int factorial(int n) {
//        // 재귀함수 탈출 조건
//        if (n == 1) {
//            return 1;
//        }
//        return n * factorial(n - 1);
//    }
