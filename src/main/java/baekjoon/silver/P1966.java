package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐 문제
public class P1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken()); // 테스트 케이스
        int answer[] = new int[testCase];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 현재 queue 에 찾고자 하는 문서의 위치
            int pollArr[]; // 큐에서 반환된 리스트
            int count = 1; // 출력 순서
            boolean isCheck; // 출력여부

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                queue.offer(new int[] { j, Integer.parseInt(st.nextToken())});
            }

            while(true) {
                pollArr = queue.poll();
                isCheck = true;


                for(int list[]: queue) {
                    if(pollArr[1] < list[1]) {
                        isCheck = false;
                        break;
                    }
                }

                if(isCheck) {
                    if(pollArr[0] == M) {
                        answer[i] = count;
                        queue.clear();
                        break;
                    }

                    count++;
                } else {
                    queue.offer(pollArr);
                }
            }
        }

        for(int num: answer)
            System.out.println(num);
    }
}
