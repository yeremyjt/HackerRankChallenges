package org.yeremy.hackerrank.datastructures.trees;

public class InOrderTraversal
{
    private class Node
    {
        int data;
        Node left;
        Node right;
    }

    void inOrder(Node root)
    {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
