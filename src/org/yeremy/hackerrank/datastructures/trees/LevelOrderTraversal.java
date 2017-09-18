package org.yeremy.hackerrank.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal
{
    private static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insert(Node root, int data)
    {
        if (root == null)
        {
            return new Node(data);
        }
        else
        {
            Node cur;
            if (data <= root.data)
            {
                cur = insert(root.left, data);
                root.left = cur;
            }
            else
            {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public void levelOrder(Node root)
    {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null)
            {
                queue.add(node.left);
            }
            if (node.right != null)
            {
                queue.add(node.right);
            }
        }
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        LevelOrderTraversal lot = new LevelOrderTraversal();
        int n = scanner.nextInt();
        Node root = new Node(scanner.nextInt());
        for (int i = 1; i < n; i++)
        {
            lot.insert(root, scanner.nextInt());
        }

        lot.levelOrder(root);
    }
}
