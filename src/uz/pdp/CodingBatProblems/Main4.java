package uz.pdp.CodingBatProblems;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.util.*;

class Edge {

  String src, dest;
  int weight;

  Edge(String src, String dest, int weight) {
    this.src = src;
    this.dest = dest;
    this.weight = weight;
  }
}

class Graph {

  Map<String, List<Edge>> adjList = new HashMap<>();

  void addEdge(String src, String dest, int weight) {
    Edge edge = new Edge(src, dest, weight);
    adjList.putIfAbsent(src, new ArrayList<>());
    adjList.get(src).add(edge);
  }

  int findWeightBetweenVertices(String start, String end) {
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    Map<String, Integer> weights = new HashMap<>();

    queue.add(start);
    visited.add(start);
    weights.put(start, 0);

    while (!queue.isEmpty()) {
      String current = queue.poll();
      if (current.equals(end)) {
        return weights.get(end);
      }
      for (Edge edge : adjList.getOrDefault(current, Collections.emptyList())) {
        if (!visited.contains(edge.dest)) {
          int weightToDestination = weights.get(current) + edge.weight;
          weights.put(edge.dest, weightToDestination);
          queue.add(edge.dest);
          visited.add(edge.dest);
        }
      }
    }
    return -1;
  }


  boolean hasPath(String start, String end) {
    Set<String> visited = new HashSet<>();

    Queue<String> queue = new LinkedList<>();

    queue.add(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      String current = queue.poll();
      if (current.equals(end)) {
        return true;
      }
      for (Edge edge : adjList.getOrDefault(current, Collections.emptyList())) {
        if (!visited.contains(edge.dest)) {
          queue.add(edge.dest);
          visited.add(edge.dest);
        }
      }
    }
    return false;
  }

  Map<String, List<Edge>> getAdjList() {
    return adjList;
  }
}

class GraphPanel extends JPanel {

  private Map<String, List<Edge>> adjList;


  public GraphPanel(Map<String, List<Edge>> adjList) {
    this.adjList = adjList;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    int radius = 10;
    int padding = 30;
    int step = (getWidth() - 2 * padding) / (adjList.size() - 1);

    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};
    int colorIndex = 0;

    Map<String, Point> vertexPositions = new HashMap<>();

    int i = 0;
    for (String vertex : adjList.keySet()) {
      int x = padding + i * step;
      int y = getHeight() / 2;
      g2.setColor(colors[colorIndex % colors.length]);
      g2.fillOval(x - radius / 2, y - radius / 2, radius, radius);
      g2.drawString(vertex, x - radius / 2, y - radius / 2);
      vertexPositions.put(vertex, new Point(x, y));
      i++;
      colorIndex++;
    }

    g2.setColor(Color.BLACK);
    for (String src : adjList.keySet()) {
      for (Edge edge : adjList.get(src)) {
        Point srcPoint = vertexPositions.get(src);
        Point destPoint = vertexPositions.get(edge.dest);
        if (srcPoint == null || destPoint == null) {
          continue;
        }
        g2.drawLine(srcPoint.x, srcPoint.y, destPoint.x, destPoint.y);
        String weight = String.valueOf(edge.weight);
        int midX = (srcPoint.x + destPoint.x) / 2;
        int midY = (srcPoint.y + destPoint.y) / 2;
        g2.drawString(weight, midX, midY);

        int deltaX = destPoint.x - srcPoint.x;
        int deltaY = destPoint.y - srcPoint.y;
        double angle = Math.atan2(deltaY, deltaX);
        int xOffset = (int) (Math.cos(angle) * (radius / 2));
        int yOffset = (int) (Math.sin(angle) * (radius / 2));
        g2.drawString(">", srcPoint.x + xOffset, srcPoint.y + yOffset);
      }
    }
  }
}


public class Main4 {

  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addEdge("A", "C", 2);
    graph.addEdge("C", "B", 1);
    graph.addEdge("B", "D", 2);
    graph.addEdge("B", "E", 3);

    GraphPanel graphPanel = new GraphPanel(graph.getAdjList());

    JFrame frame = new JFrame("4-Amaliyot uchun Graf chizish");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(graphPanel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setSize(600, 400);

    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Boshlang'ich grafni kiriting");
      String startVertex = sc.next();
      System.out.println("Tugovchi grafni kiriting");
      String endVertex = sc.next();

      if (graph.hasPath(startVertex, endVertex)) {
        int weight = graph.findWeightBetweenVertices(startVertex, endVertex);
        System.out.println("Start: " + startVertex);
        System.out.println("End: " + endVertex);
        System.out.println(
            startVertex + " va " + endVertex + " Graflar orasidagi masofa: " + weight + "\n");
      } else {
        System.out.println(
            "Afsus " + startVertex + " dan " + endVertex + " ga bog'lanish topilmadi 😔\n");
      }
    }
  }
}
