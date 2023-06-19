package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 문제 : 소수 구하기
* 에라토스테네스의 체
* 1. 2부터 N 까지의 모든 자연수를 나열한다.
* 2. 남은 수 중에서 아직 처리하지 않은 가장 작은 수 i를 찾는다.
* 3. 남은 수 중에서 i의 배수를 모두 제거한다.(i는 제거하지 않는다.)
* 4. 더 이상 반복할 수 없을 때까지 2~3번의 과정을 반복한다.
* */

public class P1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean arr[] = new boolean[N + 1]; // 소수: false, 소수 아님: true

        arr[0] = arr[1] = true; // 0, 1은 소수에서 제외 처리, 처리를 미리해서 2가 예외처리가 들어가지 않아도 된다.

        for(int i=2; i<=N; i++) {
            if(arr[i]) continue; // 소수에서 제거된 값의 배수는 이미 처리가 되었기 떄문에 건너뛴다.

            for(int j=2; i*j<=N; j++) {
                arr[i*j] = true;
            }

            // 여기서 소수를 바로 출력해도 되지만
            // 소수 리스트를 재사용 할 경우가 있을 수 있기때문에 반복문을 한번더 돌려서 처리한다.
            // System.out.println(i);
        }

        for(int i=M; i<=N; i++) {
            if(!arr[i]) {
                System.out.println(i);
            }
        }
        // 예외처리를 밑에서 해도 되지만 위에서 처리 할 경우 2를 따로 처리를 안해도 된다.
        // arr[0] = arr[1] = true; // 0, 1은 소수에서 제외
        // arr[2] = false; // M의 값이 1이 들어오는 경우가 있기 떄문에 예외처리
    }
}
