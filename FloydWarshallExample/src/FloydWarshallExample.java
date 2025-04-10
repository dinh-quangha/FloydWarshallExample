public class FloydWarshallExample {
    final static int INF = 99999; // Giá trị đại diện cho "vô cực"

    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // Sao chép ma trận ban đầu vào dist[][]
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Thuật toán Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, V);
    }

    public static void printSolution(int[][] dist, int V) {
        System.out.println("Shortest distances between all pairs of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Đồ thị minh họa với 3 đỉnh: A (0), B (1), C (2)
        int[][] graph = {
                {0,   4,   1},
                {INF, 0, INF},
                {INF, 2,   0}
        };
        int V = 3;

        floydWarshall(graph, V);
    }
}
