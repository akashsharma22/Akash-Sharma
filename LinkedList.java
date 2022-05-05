import java.util.*;
class LinkedList{
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
		
		Node reverse(Node node){
			Node back = null;
			Node curr = node;
			Node next = null;
			while(curr != null){
				next=curr.next;
				curr.next = back;
				back = curr;
				curr = next;
			}
			node = back;
			return node;
		}
		void display(Node node){
			while(node != null){
				System.out.print(node.data+" ");
				node = node.next;
			}
		}
		
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		LinkedList L = new LinkedList();
		
		L.head = new Node(1);
		int i;
		do{
			System.out.println();
			System.out.println("enter number or 0 to exit");
			i = sc.nextInt();
			
			switch(i){
				case 1:
				L.head = new Node(1);
				L.head.next = new Node(2);
		L.head.next.next = new Node(3);
		L.head.next.next.next = new Node(4);
		L.head.next.next.next.next = new Node(5);
		
		System.out.println("Given linked list-");
		L.display(L.head);
		System.out.println();
		
		System.out.println("reverse linkedlist-");
		head = L.reverse(L.head);
		L.display(head);
		break;
		case 2:
				L.head = new Node(3);
				L.head.next = new Node(4);
		L.head.next.next = new Node(2);
		L.head.next.next.next = new Node(5);
		//L.head.next.next.next.next = new Node(5);
		
		System.out.println("Given linked list-");
		L.display(L.head);
		System.out.println();
		
		System.out.println("reverse linkedlist-");
		head = L.reverse(L.head);
		L.display(head);
		break;
			}
		
		}while(i!=0);
	}
}
		
	
