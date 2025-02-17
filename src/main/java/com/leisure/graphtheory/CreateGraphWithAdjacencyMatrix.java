package com.leisure.graphtheory;

import java.util.HashMap;

/**
 * ClassName: CreateGraphWithAdjacencyMatrix
 * Package: com.leisure.graphtheory
 * Description: 创建的是一种无向图
 *
 * @Author: MyLeisureLife
 * @Date: 2025/2/16:20:56:00 星期日
 */
public class CreateGraphWithAdjacencyMatrix {

    // 邻接矩阵
    private final int[][] adjacencyMatrix;

    // 顶点
    private final HashMap<String, Integer> vertex;

    //顶点位置
    private Integer vertexPosition;

    // 图中的边数
    private int edges;

    /**
     * 初始化无向图
     * @param vertexCount 顶点数量
     */
    public CreateGraphWithAdjacencyMatrix(int vertexCount) {
        vertex = new HashMap<String, Integer>();
        vertexPosition = 0;
        adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    /**
     * 添加顶点, 注意：初始化时传入的顶点个数
     * @param vertexContent 顶点内容
     */
    public void addVertex(String vertexContent){
        if(vertex.size() < adjacencyMatrix.length){
            vertex.put(vertexContent, vertexPosition);
            vertexPosition++;
        }
    }

    /**
     *
     * @param vertexA 顶点A
     * @param vertexB 顶点B
     * @param isAdjacency  是否邻接， 1:邻接   0:不邻接
     */
    public void addEdge(String vertexA, String vertexB, int isAdjacency){
        Integer positionA = vertex.get(vertexA);
        Integer positionB = vertex.get(vertexB);
        adjacencyMatrix[positionA][positionB] = isAdjacency;
        adjacencyMatrix[positionB][positionA] = isAdjacency;
        edges++;
    }

    /**
     * @return 返回邻接矩阵
     */
    public int[][] getAdjacencyMatrix(){
        return adjacencyMatrix;
    }

    /**
     *
     * @return 获取图的总的变数
     */
    public int getEdges(){
        return edges;
    }

    /**
     * 输出邻接矩阵的示意图
     */
    public void showAdjacencyMatrix(){
        for (int[] adjacencyMatrix : adjacencyMatrix) {
            for (int vertex : adjacencyMatrix) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }

    }


    /**
     * 使用邻接矩阵创建图结构
     */
    public static void main(String[] args) {
        CreateGraphWithAdjacencyMatrix graph = new CreateGraphWithAdjacencyMatrix(5);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 1);
        graph.addEdge("B", "D", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("D", "C", 1);
        graph.addEdge("D", "E", 1);
        graph.addEdge("C", "E", 1);
        graph.showAdjacencyMatrix();

    }



}
