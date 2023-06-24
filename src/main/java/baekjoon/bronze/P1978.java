package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 소수 찾기
// 1. 입력의 조건 중 N개의 수가 주어지는데 수는 1,000 이하의 자연수 라는 조건을 확인하고 미리 1,000 이하의 소수를 구분할 수 있는 소수 리스트를 구한다.
// 2. 입력받은 데이터를 소수 리스트에 소수인지 확인
// 3. 소수이면 count 를 증가시켜 출력한다.

public class P1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 0;
        Boolean isDecimalList[] = new Boolean[1001]; // 소수면 true, 소수가 아니면 false

        Arrays.fill(isDecimalList, true);
        isDecimalList[0] = isDecimalList[1] = false;

        for(int i=2; i<500; i++) {
            if(!isDecimalList[i]) continue;

            for(int j=2; i*j<1001; j++) {
                isDecimalList[i*j] = false;
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            if(isDecimalList[Integer.parseInt(st.nextToken())]) count++;
        }

        System.out.println(count);
    }
}
