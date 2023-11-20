import java.io.*;
import java.util.*;


public class Solution {
    private Node root;
    private class Node {
        private int value;
        private Node right, left;
        private int height;
        public Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    public Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return  x;
    }
    public Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    public Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        int cmp = value - node.value;
//      if (node.contains(value)) return node;
        if (cmp < 0) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);
        if (balance > 1 && node.left.value - value > 0) {
            node = rotateRight(node);
        }
        if (balance < -1 && node.right.value - value < 0) {
            node = rotateLeft(node);
        }
        if (balance > 1 && node.left.value-value < 0) {
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }
        if (balance < -1 && node.right.value-value > 0) {
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
        }
        return node;
    }
    public void insert(int value) {
        root = insert(root, value);
    }
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + "(BF=" + (height(node.left)-height(node.right)) + ") ");
        inOrder(node.right);
    }
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                Node tmp = queue.poll();
                System.out.print(tmp.value + "(BF=" + (height(tmp.left)-height(tmp.right)) + ") ");
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            
        }
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        Solution s = new Solution();
        for (int i =0; i<=n; i++) {
            int x = sn.nextInt();
            s.insert(x);
        }
        s.inOrder(s.root);
        System.out.println("");
        s.levelOrder();
    }
}