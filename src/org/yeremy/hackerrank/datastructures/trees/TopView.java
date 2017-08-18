package org.yeremy.hackerrank.datastructures.trees;

public class TopView
{
    private class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node insert(Node root, int data)
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

    void topView(Node root)
    {
        if (root.left != null)
        {
            leftView(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null)
        {
            rightView(root.right);
        }
    }

    void leftView(Node node)
    {
        if (node.left != null)
        {
            leftView(node.left);
        }
        System.out.print(node.data + " ");
    }

    void rightView(Node node)
    {
        if (node.right != null)
        {
            rightView(node.right);
        }
        System.out.print(node.data + " ");
    }


}