package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS 와 BFS
public class P1260 {

    static ArrayList<Integer>[] connections;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        connections = new ArrayList[n + 1]; // 서로 연결되어있는 부분을 체크하기 위한 list
        visited = new boolean[n + 1]; // 방문을 체크 여부를 체크하기 위한 list

        // ArrayList 생성
        for(int i=1; i<=n; i++) {
            connections[i] = new ArrayList<>();
        }

        // 노드를 서로 연결시켜준다.
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            connections[x].add(y);
            connections[y].add(x);
        }

        // collection 안에 모든 값들을 정렬해준다.
        for(int i=1; i<=n; i++) {
            Collections.sort(connections[i]);
        }

        dfs(v);
        Arrays.fill(visited, false); // dfs 를 출력했기때문에 방문을 초기화 해준다.
        bfs(v);
    }

    static void dfs(int Node) {
        System.out.println(Node + " ");
        visited[Node] = true;

        for(int i : connections[Node]) {
            if(visited[i] == false) {
                dfs(i);
            }
        }

        System.out.println();
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int Node = queue.poll();
            System.out.println(Node + " ");
            for(int i : connections[Node]) {
                if(visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
