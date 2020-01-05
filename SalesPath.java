package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class SalesPath {

         static class Node {

            int cost;
            Node[] children;
            Node parent;

            Node(int cost) {
                this.cost = cost;
                children = null;
                parent = null;
            }
        }

        static int getCheapestCostBFS(Node rootNode) {

               Queue<Node> queue = new LinkedList<>();

               int min = Integer.MAX_VALUE;

               queue.add(rootNode);

               while(!queue.isEmpty()) {

                    Node temp = queue.remove();

                    if(temp.children == null) {
                        min = Math.min(min, temp.cost);
                    }
                    else {
                        for(Node n: temp.children) {
                            n.cost += temp.cost;
                            queue.add(n);
                        }
                    }
               }
                return min;
            }

            static int getCheapCostDFS(Node rootNode) {
                int minCost = Integer.MAX_VALUE;

                if(rootNode.children == null) {
                    return rootNode.cost;
                } else {
                    for(Node n: rootNode.children) {
                        int total = rootNode.cost + getCheapCostDFS(n);

                        if(total < minCost) {
                            minCost = total;
                        }
                    }
                }
                return minCost;
            }

        public static void main(String[] args) {

            //          0
            Node root = new Node(0);

            //          0
            //     5    3    6
            root.children = new Node[3];
            root.children[0] = new Node(5);
            root.children[1] = new Node(3);
            root.children[2] = new Node(6);
            root.children[0].parent = root;
            root.children[1].parent = root;
            root.children[2].parent = root;

            //          0
            //   5      3      6
            // 4
            root.children[0].children = new Node[1];
            root.children[0].children[0] = new Node(4);
            root.children[0].children[0].parent = root.children[0];

            //          0
            //   5      3       6
            // 4      2    0
            root.children[1].children = new Node[2];
            root.children[1].children[0] = new Node(2);
            root.children[1].children[1] = new Node(0);
            root.children[1].children[0].parent =  root.children[1];
            root.children[1].children[1].parent =  root.children[1];

            //          0
            //   5      3       6
            // 4      2    0  1   5
            root.children[2].children = new Node[2];
            root.children[2].children[0] = new Node(1);
            root.children[2].children[1] = new Node(5);
            root.children[2].children[0].parent = root.children[2];
            root.children[2].children[1].parent = root.children[2];

            //          0
            //   5      3        6
            // 4      2     0   1     5
            //            10
            root.children[1].children[1].children = new Node[1];
            root.children[1].children[1].children[0] = new Node(10);
            root.children[1].children[1].children[0].parent = root.children[1].children[1];


            //          0
            //   5      3       6
            // 4      2    0  1   5
            //      1     10
            root.children[1].children[0].children = new Node[1];
            root.children[1].children[0].children[0] = new Node(1);
            root.children[1].children[0].children[0].parent = root.children[1].children[0];

            //          0
            //   5      3        6
            // 4      2     0   1    5
            //      1     10
            //        1
            root.children[1].children[0].children[0].children = new Node[1];
            root.children[1].children[0].children[0].children[0] = new Node(1);
            root.children[1].children[0].children[0].children[0].parent = root.children[1].children[0].children[0];

            //          0
            //   5      3          6
            // 4      2    0  1   5
            //      1     10
            //        1
            int res = SalesPath.getCheapCostDFS(root);

            System.out.println(res);
        }
    }
