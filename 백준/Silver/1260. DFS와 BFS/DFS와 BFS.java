import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        new GraphSolver().solve();
    }
}

class GraphSolver {
    //필드값 입력
    private List<Integer>[] adj;
    private int N, M, V;
    private boolean[] visited;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer sp = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(sp.nextToken());
            int P = Integer.parseInt(sp.nextToken());

            adj[U].add(P);
            adj[P].add(U);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    public void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int next : adj[start]) {
            if(!visited[next]){
                dfs(next);
            }
        }
    }

        public void bfs ( int start){
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.offer(start);

            while(!queue.isEmpty()){
                int current= queue.poll();
                System.out.print(current + " ");

                for(int next: adj[current]){
                    if(!visited[next]){
                        visited[next]= true;
                        queue.offer(next);
                    }
                }
            }

        }
}

