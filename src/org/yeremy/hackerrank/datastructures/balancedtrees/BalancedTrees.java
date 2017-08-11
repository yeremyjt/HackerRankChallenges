package org.yeremy.hackerrank.datastructures.balancedtrees;

public class BalancedTrees
{
    private Node root;

    static Node insert(Node root, int val)
    {
        root = insert(root, val, 0);
        balance(null, root);
        return root;
    }

    private static void balance(Node parent, Node node)
    {
        int balanceFactor = height(node.left) - height(node.right);
        if (balanceFactor == 2 || balanceFactor == -2)
        {
            balance(node, node.left);
        }

        balance(node, node.right);
        balance(node, node.left);
    }

    private static void rotate(Node parent, Node node)
    {
        Node child;
        Node grandChild;
        if (node.left == null) child = node.right;
        else                   child = node.left;

        if (child.left == null) grandChild = child.right;
        else                    grandChild = child.left;

        // Left right case
        if (parent.val > child.val && child.val < grandChild.val)
        {
            parent.left = grandChild;
            grandChild;

        }

    }

    private static Node insert(Node parent, int val, int height)
    {
        if (parent == null)
        {
            Node child = new Node();
            child.val = val;
            child.ht = height;
            return child;
        }

        if (val > parent.val)       parent.right = insert(parent.right, val, height + 1);
        else                        parent.left  = insert(parent.left, val, height + 1);

        return parent;
    }


    private static int height(Node node)
    {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
        {
            return node.ht;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight > rightHeight) return leftHeight;
        else return rightHeight;
    }

    private static class Node
    {
        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child
    }

    public static void main(String[] args)
    {
        BalancedTrees balancedTree = new BalancedTrees();

        Node root = balancedTree.insert(null, 5);
        balancedTree.insert(root, 3);
        balancedTree.insert(root, 4);


        System.out.println(balancedTree);
    }
}
