import java.util.HashMap;
import java.util.Map;

public class Main {
  private static final int INF = Integer.MAX_VALUE / 2;

  private static int[][] startMatrix(int n) {
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else {
          dist[i][j] = INF;
        }
      }
    }

    return dist;
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == INF) {
          System.out.print("INF\t");
        } else {
          System.out.print(matrix[i][j] + "\t");
        }
      }
      System.out.println();
    }
  }

  private static void printMinDistance(int[][] dist, String[] vertices) {
    for (int i = 0; i < dist.length; i++) {
      System.out.println();
      System.out.println(vertices[i]);
      System.out.println("-----------");
      for (int j = 0; j < dist[i].length; j++) {
        if (i == j)
          continue;
        if (dist[i][j] == INF) {
          System.out.printf("Para %s: Não há caminho\n", vertices[j]);
        } else {
          System.out.printf("Para %s: %d\n", vertices[j], dist[i][j]);
        }
      }
    }
  }

  public static void floydWarshall(Map<String, Map<String, Integer>> graph, String[] vertices) {
    int n = vertices.length;
    // Inicializa a matriz de distâncias com INF
    int[][] dist = startMatrix(n);

    // Preenche a matriz de distâncias com os pesos dos vértices (k = 0)
    for (String v : vertices) {
      Map<String, Integer> neighbors = graph.get(v);
      for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
        String to = entry.getKey();
        int weight = entry.getValue();
        int i = findIndex(vertices, v);
        int j = findIndex(vertices, to);
        dist[i][j] = weight;
      }
    }

    // Algoritmo de Floyd-Warshall
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] > dist[i][k] + dist[k][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }

    System.out.println("Matriz de distâncias finais:");
    printMatrix(dist);

    System.out.println("\nDistâncias mínimas entre cada lugar:");
    printMinDistance(dist, vertices);
  }

  public static int findIndex(String[] vertices, String vertex) {
    for (int i = 0; i < vertices.length; i++) {
      if (vertices[i].equals(vertex)) {
        return i;
      }
    }
    throw new IllegalArgumentException("Vertex não encontrado: " + vertex);
  }

  private static void addEdge(Map<String, Map<String, Integer>> graph, String source, String destination, int weight) {
    graph.putIfAbsent(source, new HashMap<>());
    graph.get(source).put(destination, weight);
  }

  public static void main(String[] args) {
    Map<String, Map<String, Integer>> graph = new HashMap<>();

    addEdge(graph, "SHOPPING-GRACHER", "TIRO-DE-GUERRA", 6);
    addEdge(graph, "SHOPPING-GRACHER", "AUGUSTO-BAUER", 3);
    addEdge(graph, "SHOPPING-GRACHER", "PAYSANDU", 5);
    addEdge(graph, "SHOPPING-GRACHER", "HAVAN", 2);
    addEdge(graph, "TIRO-DE-GUERRA", "SHOPPING-GRACHER", 5);
    addEdge(graph, "HAVAN", "SHOPPING-GRACHER", 3);
    addEdge(graph, "HAVAN", "UNIFEBE", 4);
    addEdge(graph, "HAVAN", "FISCHER", 10);
    addEdge(graph, "FISCHER", "HAVAN", 10);
    addEdge(graph, "UNIFEBE", "HAVAN", 4);
    addEdge(graph, "UNIFEBE", "FIP", 1);
    addEdge(graph, "FIP", "UNIFEBE", 1);
    addEdge(graph, "FIP", "AUGUSTO-BAUER", 7);
    addEdge(graph, "PAYSANDU", "SHOPPING-GRACHER", 3);
    addEdge(graph, "PAYSANDU", "AUGUSTO-BAUER", 3);
    addEdge(graph, "PAYSANDU", "FIP", 8);
    addEdge(graph, "AUGUSTO-BAUER", "SHOPPING-GRACHER", 1);

    String[] vertices = graph.keySet().toArray(new String[0]);

    floydWarshall(graph, vertices);
  }
}