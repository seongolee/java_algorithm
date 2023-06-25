package baekjoon.silver;

import java.util.*;

// 통계학
// 문제를 보았을때, 산술평귱, 중앙값, 최빈값, 범위 등을 구하려면 기본적으로 정렬이 되어있어야 하므로 정렬 후 로직을 처리한다.
// 1. 산술평균: for 문을 돌면서 더해 놓고 마지막에 N 을 나누어 구한다.
// 2. 중앙값: 리스트를 정렬하고, N/2를 하여 중간의 값을 추출할 수 있다.
// 3. 최빈값:
//    1) 최대빈값을 갖는 값을 따로 갖고 있고, 최대빈값을 기준할 수 있는 변수 선언
//    2) 최대빈값을 저장할 리스트를 저장하고, 최대빈값 기준점이 바뀌게 되면, list clear 처리 한다.
//    3) 반복문 로직이 끝났을때 최대빈 리스트 사이즈가 2이상이면 2번째 값을 추출하고, 그렇지 않으면 첫번째 값을 그대로 추출한다.
// 4. 범위 : 정렬되어있는 list 에서 0 번과 마지막 index 의 값을 뽑아서 0번 인덱스의 값을 부호를 바꿔주는 작업을 한 후 더해준다.

// 출력시 조건에 산술평균 소수점 이하 첫째 자리에서 반올림 하는 조건 추가
public class P2108 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int answer[] = new int[4];
        int maxCount = 0; // 최대빈 값을 담아둘 변수
        List<Integer> maxList = new LinkedList<>(); // 최대빈 값들 담을 리스트
        HashMap<Integer, Integer> maxMap = new HashMap<>();

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();

            if(maxMap.containsKey(arr[i])) {
                maxMap.put(arr[i], maxMap.get(arr[i]) + 1);
            } else {
                maxMap.put(arr[i], 1);
            }

            int tempArr = maxMap.get(arr[i]);

            if(maxCount == tempArr) {
                maxList.add(arr[i]);
            }else if(maxCount < tempArr) {
                maxList.clear(); // 리스트를 초기화
                maxCount = tempArr;
                maxList.add(arr[i]);
            }

            answer[0] += arr[i];

        }

        Arrays.sort(arr);
        Collections.sort(maxList);

        answer[0] = (int)Math.round((double)answer[0] / N); // 산술평균값
        answer[2] = maxList.size() > 1 ? maxList.get(1) : maxList.get(0); // 최빈값
        answer[1] = arr[N/2]; // 중앙값
        answer[3] = -arr[0] + arr[N-1]; // 범위값

        for(int num : answer) {
            System.out.println(num);
        }
    }
}
