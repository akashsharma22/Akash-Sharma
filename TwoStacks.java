import java.util.*;
class TwoStacks{
	int arr[];
	int size;
	int stack1;
	int stack2;
	
	TwoStacks(int n){
		size = n;
		arr = new int[n];
		stack1 = n/2+1;
		stack2 = n/2;
		
	}
	void push(int x){
		if(stack1 > 0){
			stack1--;
			arr[stack1]=x;
		}
		else{
			System.out.print("Overflow");
		}
	}
	void push2(int x){
		if(stack2< size-1){
			stack2++;
			arr[stack2]=x;
		}
		else{
			System.out.print("Overflow");
			return;
		}
	}
	int pop(){
		if(stack1 <= size/2){
			int x = arr[stack1];
			stack1++;
			return x;
		}
		else{
			System.out.print("underflow");
		System.exit(1);
		}
		return 0;
	}
	int pop2(){
		if(stack2 >= size/2+1){
			int x = arr[stack2];
			stack2--;
			return x;
		}
		else{
			System.out.print("underflow");
		System.exit(1);
		}
		return 1;
	}

	public static void main(String args[]){
		TwoStacks t = new TwoStacks(10);
		t.push(5);
		t.push2(10);
		t.push2(15);
		t.push(11);
		t.push(7);
		t.push(40);
		
		System.out.println("Popped element from stack1 is "+t.pop());
		System.out.println("Popped element from stack2 is "+t.pop2());
}
}