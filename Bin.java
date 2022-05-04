import java.util.*;
class Bin{
	
	public static int bsearch(int a[],int key, int low, int high){
	if(high>=low){
	  int mid = (low + (high - low))/2; // finding mid
	  if(a[mid]==key)
		  return mid;
	  if(a[mid]>key)
		  return bsearch(a,key,low,mid-1);
	  return bsearch(a,key,mid+1,high);
	}
	return -1;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("index");
		int y = sc.nextInt();
		int a[] = new int[y];
		for(int i=0; i<a.length; i++){
			a[i] = sc.nextInt();
			//System.out.println(a[i]);
		}
		for(int i=0; i<a.length; i++){
			//a[i] = sc.nextInt();
			if(i == a.length-1){
			System.out.print(a[i]);break;
		}
		System.out.print(a[i]+",");
		}
		int key = sc.nextInt();
		int n = a.length;
		
		int result = bsearch(a,key,0,n-1);
		
		if (result == -1)
			System.out.println("Not found");
		else
			System.out.println("found");
		
	}
}