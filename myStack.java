package data_structure;

import java.util.Scanner;

class intStack{
	private int arr[];
	private int top;
	
	public intStack()
	{
		arr = new int [10];
		top = -1;
	}
	public intStack(int s)
	{
		arr = new int[s];
		top = -1;
	}
	public void push (int e)
	{
		if(top == arr.length-1)
		{
			System.out.println("Overflow");
			return;
		}
		top = top+1;
		arr[top]=e;
		return;
		}
	public int pop() {
		int d = -999;
		if(top== -1)
		{
			System.out.println("Underflow...");
			return d;
		}
		d = arr[top];
		top = top -1 ;
		return d;
	}
	public int peek()
	{
		int d = -999;
		if(top == -1)
		{
			System.out.println("Underflow");
			return d;
		}
		System.out.println("Toppest element");
		return arr[top];
	}
	public boolean isFull()
	{
		if(top == arr.length - 1)
			return true;
		else
			return false;
	}
	public boolean isEmpty()
	{
		if (top== -1)
			return true;
		else
			return false;
	}
}

public class myStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch,e;
		intStack s1 = new intStack();
		do {
			System.out.println("Menu");
			System.out.println("1.Push");
			System.out.println("2.pop");
			System.out.println("3.peek");
			System.out.println("4.Exit");
			System.out.println("5. Check if stack is full");
	        System.out.println("6. Check if stack is empty");
			System.out.println("Enter Your Choice(1...4)");
			
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter element to add or push");
				e = sc.nextInt();
				s1.push(e);
				break;
				
			case 2:
				System.out.println(s1.pop());
				break;
				
			case 3:
				System.out.println(s1.peek());
				break;
			case 4:
				
				System.out.println("\n The End");
				break;
			 case 5:
                 if (s1.isFull()) {
                     System.out.println("The stack is full.");
                 } else {
                     System.out.println("The stack is not full.");
                 }
                 break;

             case 6:
                 if (s1.isEmpty()) {
                     System.out.println("The stack is empty.");
                 } else {
                     System.out.println("The stack is not empty.");
                 }
                 break;
			}
			
		}while(ch !=6);
	}

}
