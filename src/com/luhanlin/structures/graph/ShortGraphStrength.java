package com.luhanlin.structures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * @description: 最短图路径
 * @author: Mr.Lu
 * @create: 2019-04-25 15:25
 **/
public class ShortGraphStrength {


    public static class Graph {

        private int size;

        private Vertex[] vertexs;

        private LinkedList<Edge> listArr[];

        public Graph(int size) {
            this.size = size;
            vertexs = new Vertex[size];
            listArr = new LinkedList[size];

            for (int i = 0; i < size; i++) {
                listArr[i] = new LinkedList<>();
            }
        }
    }

    /**
     * 迪杰斯特拉 寻找图路劲最短算法
     * @param graph
     * @param startIndex
     * @return
     */
    public static Map<Integer, Integer> djkstra(Graph graph, int startIndex) {
        // 存放最短图路径map
        Map<Integer, Integer> distanceMap = new HashMap<>();

        // 存放访问过的顶点
        HashSet<Integer> visitedSet = new HashSet<>();

        int size = graph.vertexs.length;

        // 1. 初始化map
        for (int i = 1; i < size; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }

        // 2. 开始计算路径
        visitedSet.add(startIndex);

        // 2.1 遍历关联的其他顶点，更新距离map
        for (Edge edge : graph.listArr[startIndex]) {
            distanceMap.put(edge.index, edge.width);
        }

        // 2.2 寻找最短顶点
        for (int i = 1; i < size; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            for (Integer key : distanceMap.keySet()) {
                if (!visitedSet.contains(key) && distanceMap.get(key) < minDistance) {
                    minDistance = distanceMap.get(key);
                    minIndex = key;
                }
            }

            // 2.3 如果都已经被遍历过，则跳出循环
            if (minIndex == -1) {
                break;
            }

            // 2.4 遍历余下顶点
            visitedSet.add(minIndex);

            for (Edge edge : graph.listArr[minIndex]) {
                if (visitedSet.contains(edge.index)) {
                    continue;
                }

                if (edge.width != Integer.MAX_VALUE && (minDistance + edge.width) < distanceMap.get(edge.index)) {
                    distanceMap.put(edge.index, minDistance + edge.width);
                }
            }
        }

        return distanceMap;

    }



    /**
     * 图的顶点
     */
    private static class Vertex {
        String value;

        public Vertex(String value) {
            this.value = value;
        }
    }

    /**
     * 图的权重
     */
    private static class Edge {
        int index;  // 顶点的下标
        int width;  // 顶点的权重

        public Edge(int index, int width) {
            this.index = index;
            this.width = width;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.vertexs[0] = new Vertex("A");
        graph.vertexs[1] = new Vertex("B");
        graph.vertexs[2] = new Vertex("C");
        graph.vertexs[3] = new Vertex("D");
        graph.vertexs[4] = new Vertex("E");
        graph.vertexs[5] = new Vertex("F");
        graph.vertexs[6] = new Vertex("G");

        graph.listArr[0].add(new Edge(1, 5));
        graph.listArr[0].add(new Edge(2, 2));
        graph.listArr[1].add(new Edge(0, 5));
        graph.listArr[1].add(new Edge(3, 1));
        graph.listArr[1].add(new Edge(4, 6));
        graph.listArr[2].add(new Edge(0, 2));
        graph.listArr[2].add(new Edge(3, 6));
        graph.listArr[2].add(new Edge(5, 8));
        graph.listArr[3].add(new Edge(1, 1));
        graph.listArr[3].add(new Edge(2, 6));
        graph.listArr[3].add(new Edge(4, 1));
        graph.listArr[3].add(new Edge(5, 2));
        graph.listArr[4].add(new Edge(1, 6));
        graph.listArr[4].add(new Edge(3, 1));
        graph.listArr[4].add(new Edge(6, 7));
        graph.listArr[5].add(new Edge(2, 8));
        graph.listArr[5].add(new Edge(3, 2));
        graph.listArr[5].add(new Edge(6, 3));
        graph.listArr[6].add(new Edge(4, 7));
        graph.listArr[6].add(new Edge(5, 3));

        Map<Integer, Integer> djkstra = djkstra(graph, 0);

        for (int key : djkstra.keySet()) {
            switch (key){
                case 1 :
                    System.out.println(" A -> B : " + djkstra.get(key));
                    break;
                case 2 :
                    System.out.println(" A -> C : " + djkstra.get(key));
                    break;
                case 3 :
                    System.out.println(" A -> D : " + djkstra.get(key));
                    break;
                case 4 :
                    System.out.println(" A -> E : " + djkstra.get(key));
                    break;
                case 5 :
                    System.out.println(" A -> F : " + djkstra.get(key));
                    break;
                case 6 :
                    System.out.println(" A -> G : " + djkstra.get(key));
            }

        }
    }


}
