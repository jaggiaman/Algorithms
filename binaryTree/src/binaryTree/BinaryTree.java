package binaryTree;

import java.util.Scanner;

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
	public node root;
	
	public void addNode(int data) {
		if(root==null) {
			node Node=new node(data);
			Node.Left=null;
			Node.Right=null;
			Node.parent=null;
			root=Node;
			
		}
		add(data, root);
	}
	public void add(int data, node temp) {
		if(temp.data>=data) {
			if(temp.Left!=null)
				add(data,temp.Left);
			else {
				node Node=new node(data);
				Node.Left=null;
				Node.Right=null;
				Node.parent=temp;
				temp.Left=Node;
				return;
			}

	}
		else {
			if(temp.Right!=null)
				add(data,temp.Right);
			else
			{
				node Node=new node(data);
				Node.Left=null;
				Node.Right=null;
				Node.parent=temp;
				temp.Right=Node;
				return;
			}
		}
		
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
	
	public void inOrder() {
		if(root==null)
			System.out.print("No node to Print");
		else
			preOrder(root);
			
	}
	public void inOrder(node temp) {
		if(temp==null) {
			return;
		}
		
		inOrder(temp.Left);
		System.out.print("Node:"+temp.data);
		inOrder(temp.Right);
	}
	
	
	public boolean delete(int data) {
		if(root==null) {
			System.out.print("Nothing to delete\n");
			return false;
		}	
		return delete(data, root);
	}
	public boolean delete(int data, node temp) {
		if(temp==null)
			return false;
		if(temp.data==data) {
			if(temp.Right==null&&temp.Left==null) {
				if(temp.parent.data>data) {
					temp.parent.Left=null;
					return true;
				}
				else
				{
					temp.parent.Right=null;

					return true;
				}
			}
				
			if(temp.Right==null&&temp.parent!=null) {
				if(temp.parent.data>data) {
					temp.parent.Left=temp.Left;
					temp.Left.parent=temp.parent;
					return true;
				}
				else
				{
					temp.parent.Right=temp.Left;
					temp.Left.parent=temp.parent;
					return true;
				}
			}
			else {
				node parent=temp;
				temp=temp.Right;
				while(temp.Left!=null) {
					temp=temp.Left;
				}
					parent.data=temp.data;
					temp.parent.Left=temp.Right;
					return true;
			}
		}
		if(temp.data>data)
			delete(data,temp.Left);
		else 
			delete(data,temp.Right);
		return false;
		
	}


	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		System.out.print("Please Enter Node data to Insert\n");
		Scanner sc = new Scanner(System.in);
		char ch='y';
		while(ch!='n') {
			System.out.print("Enter your Chaoice\n");
			System.out.print("1.add\n");
			System.out.print("2.preOrder\n");
			System.out.print("3.inOrder\n");
			System.out.print("4.Delete\n");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.print("Please Enter 1Node data to Insert\n");
				//int dat1ya = sc.nextInt(); 
				int[] arr= {20, 10, 30, 5, 7,6,31,29, 13, 12};
				
				for(int data:arr)
					tree.addNode(data);
				break;
			}
			case 2:{
				tree.preOrder();
				break;
			}
			case 3:{
				tree.inOrder();
				break;
			}
			case 4:{
				System.out.print("Please Enter Node data to Delete\n");
				int data = sc.nextInt(); 
				tree.delete(data);
				break;
			}
			default:{
				System.out.print("LOL");
			}
			}
			System.out.print("Want to continue:y or n\n");
			ch = sc.next().charAt(0); 
			
			
		}
}
}

