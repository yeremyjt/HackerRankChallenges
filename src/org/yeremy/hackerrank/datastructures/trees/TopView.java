package org.yeremy.hackerrank.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TopView
{
    private static class Node
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
        if(root==null)
            return;
        Stack<Integer> s=new Stack<>();
        s.push(root.data);
        Node root2=root;
        while(root.left!=null)
        {
            s.push(root.left.data);
            root=root.left;
        }
        while(s.size()!=0)
            System.out.print(s.pop()+" ");

        Queue<Integer> q=new LinkedList<>();
        q.add(root2.right.data);
        root2=root2.right;
        while(root2.right!=null)
        {
            q.add(root2.right.data);
            root2=root2.right;
        }
        while(q.size()!=0)
            System.out.print(q.poll()+" ");
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TopView topView = new TopView();
        int n = scanner.nextInt();
        Node root = new Node(scanner.nextInt());
        for (int i = 1; i < n; i++)
        {
            topView.insert(root, scanner.nextInt());
        }

        topView.topView(root);
    }
}