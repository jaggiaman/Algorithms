package binaryTree;

import java.util.Scanner;

import binaryTree.BinaryTree.node;

public class BinaryTree {
	public class node{
		int data;
		node Left;
		node Right;
		node parent;
		public node(int data) {
			this.data=data;
		}
	}
	public  node root;
	
	public  node create(int[] arr) {
		int start=0;
		int end=arr.length-1;
		return(create(arr,start,end));
	}
	
	public node create(int[] arr, int start, int end) {
		if(end<=start)
			return null;
		int mid=(start+end)/2;
		node Node= new node(arr[mid]);
		
		Node.Left=create(arr,start,mid);
		Node.Right=create(arr,mid+1,end);
		return Node;
	}
	public void preOrder() {
		if(root==null)
			System.out.print("No node to Print");
		else
			preOrder(root);
			
	}
	public void preOrder(node temp) {
		if(temp==null) {
			return;
		}
		System.out.print("Node:"+temp.data);
		preOrder(temp.Left);
		preOrder(temp.Right);
	}
	public boolean checkBalance(node root) {
		return(checkHT(root)!=Integer.MIN_VALUE);
	}
	public int checkHT(node root) {
		if(root==null)
			return -1;
		int leftHeight=checkHT(root.Left);
		if(leftHeight==Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int rightHeight=checkHT(root.Right);
		if(rightHeight==Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int diff=leftHeight-rightHeight;
		if(Math.abs(diff)>1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight)+1;
		
		
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] arr= {10,20,30,40,50,60,70,80,90};
		tree.root=tree.create(arr);
		tree.preOrder(tree.root);
		System.out.print(tree.checkBalance(tree.root));	
		}
}


