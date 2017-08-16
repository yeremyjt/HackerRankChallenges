package org.yeremy.hackerrank.datastructures.balancedtrees;

public class BalancedTrees
{
    static Node insert(Node root, int val)
    {
        root = insertNode(root, val);
        root = balance(null, root, null);
        root = recalculateHeights(root);
        return root;
    }

    private static Node recalculateHeights(Node node)
    {
        if (node == null) return null;
        node.ht = height(node);
        recalculateHeights(node.left);
        recalculateHeights(node.right);
        return node;
    }

    private static Node balance(Node parent, Node node, Direction direction)
    {
        int balanceFactor = (1 + height(node.left)) - (1 + height(node.right));
        if (balanceFactor > 1 || balanceFactor < -1)
        {
            // Check Left Left case
            if (node.left != null && node.left.left != null)
            {
                node = rotateLeftLeft(parent, node, direction);
            }
            // Check Left Right case
            else if (node.left != null && node.left.right != null)
            {
                node = rotateLeftRight(node);
                node = rotateLeftLeft(parent, node, direction);
            }
            // Check Right Right case
            else if (node.right != null && node.right.right != null)
            {
                node = rotateRightRight(parent, node, direction);
            }
            // Check Right Left case
            else if (node.right != null && node.right.left != null)
            {
                node = rotateRightLeft(node);
                node = rotateRightRight(parent, node, direction);
            }
        }
        return node;
    }

    private static Node rotateLeftLeft(Node parent, Node node, Direction direction)
    {
        Node temp = node.left;
        temp.left = node.left.left;
        node.left = null;
        node.right = null;
        temp.right = node;
        node = temp;

        if (direction == Direction.RIGHT)
        {
            parent.right = node;
        }
        else if (direction == Direction.LEFT)
        {
            parent.left = node;
        }

        return node;
    }

    private static Node rotateLeftRight(Node node)
    {
        Node temp = node.left;
        node.left = node.left.right;
        node.left.left = temp;
        node.left.left.left = null;
        node.left.left.right = null;
        return node;
    }

    private static Node rotateRightRight(Node parent, Node node, Direction direction)
    {
        Node temp = node.right;
        temp.right = node.right.right;
        node.left = null;
        node.right = null;
        temp.left = node;
        node = temp;

        if (direction == Direction.RIGHT)
        {
            parent.right = node;
        }
        else if (direction == Direction.LEFT)
        {
            parent.left = node;
        }

        return node;
    }

    private static Node rotateRightLeft(Node node)
    {
        Node temp = node.right;
        node.right = node.right.left;
        node.right.right = temp;
        node.right.right.left = null;
        node.right.right.right = null;
        return node;
    }

    private static Node insertNode(Node parent, int val)
    {
        if (parent == null)
        {
            Node child = new Node();
            child.val = val;
            return child;
        }

        if (val > parent.val)
        {
            parent.right = insert(parent.right, val);
            parent.right = balance(parent, parent.right, Direction.RIGHT);
        }
        else
        {
            parent.left  = insert(parent.left, val);
            parent.left = balance(parent, parent.left, Direction.LEFT);
        }

        return parent;
    }

    private static int height(Node node)
    {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static class Node
    {
        int val;
        int ht;
        Node left;
        Node right;
    }

    private enum Direction
    {
        LEFT, RIGHT;
    }

    public static void main(String[] args)
    {
        BalancedTrees balancedTree = new BalancedTrees();

        Node root = balancedTree.insert(null, 14);
        root = balancedTree.insert(root, 25);
        root = balancedTree.insert(root, 21);
        root = balancedTree.insert(root, 10);
        root = balancedTree.insert(root, 23);
        root = balancedTree.insert(root, 7);
        root = balancedTree.insert(root, 26);
        root = balancedTree.insert(root, 12);
        root = balancedTree.insert(root, 30);
        root = balancedTree.insert(root, 16);

        System.out.println(root);
    }
}
