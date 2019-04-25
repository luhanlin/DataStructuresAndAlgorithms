package com.luhanlin.structures.graph;

import java.util.LinkedList;

/**
 * @description: 图 遍历
 * @author: Mr.Lu
 * @create: 2019-04-25 14:17
 **/
public class GraphIterate {

    /**
     * 图的顶点
     */
    private static class Vertex {
        int value;

        public Vertex(int value) {
            this.value = value;
        }
    }

    /**
     * 邻接表形式 -- 图
     */
    private static class Graph {
        // 顶点个数
        private int size;

        private Vertex[] vertexs;

        // 每个顶点连接的其他顶点
        private LinkedList<Integer> listArr[];


        public Graph(int size) {
            this.size = size;
            vertexs = new Vertex[size];
            listArr = new LinkedList[size];

            for (int i = 0; i < size; i++) {
                vertexs[i] = new Vertex(i);
                listArr[i] = new LinkedList<>();
            }
        }

    }

    /**
     * depth first search
     * @param graph 图
     * @param start 开始顶点下标
     * @param visited 是否被访问
     */
    public static void dfs(Graph graph, int start, boolean[] visited){
        System.out.print(graph.vertexs[start].value + " -> ");
        visited[start] = true;
        for (int index : graph.listArr[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    /**
     * breath first search
     * @param graph 图
     * @param start 开始下标
     * @param visited  顶点是否被访问
     * @param queue 存放每层访问的元素
     */
    public static void bfs(Graph graph, int start, boolean[] visited, LinkedList<Integer> queue){
        queue.offer(start);

        while(!queue.isEmpty()){
            Integer font = queue.poll();

            if (visited[font]) {
                continue;
            }

            System.out.print(graph.vertexs[font].value + " -> ");
            visited[font] = true;

            for (int index : graph.listArr[font]) {
                queue.offer(index);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.listArr[0].add(1);
        graph.listArr[0].add(2);
        graph.listArr[0].add(3);

        graph.listArr[1].add(0);
        graph.listArr[1].add(3);
        graph.listArr[1].add(4);

        graph.listArr[2].add(0);

        graph.listArr[3].add(0);
        graph.listArr[3].add(1);
        graph.listArr[3].add(4);
        graph.listArr[3].add(5);

        graph.listArr[4].add(1);
        graph.listArr[4].add(3);
        graph.listArr[4].add(5);

        graph.listArr[5].add(3);
        graph.listArr[5].add(4);

        System.out.println("深度优先遍历开始：");
        dfs(graph, 0, new boolean[graph.size]);
        System.out.println();
        System.out.println("广度优先遍历开始：");
        bfs(graph, 0, new boolean[graph.size], new LinkedList<>());
    }
}
