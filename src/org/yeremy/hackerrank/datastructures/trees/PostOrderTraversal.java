package org.yeremy.hackerrank.datastructures.trees;


public class PostOrderTraversal
{
    private class Node
    {
        int data;
        Node left;
        Node right;
    }

    void postOrder(Node root)
    {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
