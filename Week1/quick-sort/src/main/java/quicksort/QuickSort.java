package quicksort;

import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        quickSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
        sc.close();
	}
	
	private static void quickSort(int arr[],int first,int last) {
		if(first<last) {
			//partitioning the array
			int loc=partition(arr,first,last);
			//sort the partitions
			quickSort(arr,first,loc-1);
			quickSort(arr,loc+1,last);
		}
	}
	
	private static int partition(int arr[],int first,int last) {
		int pivot,left,right;
		//select pivot element(here left most)
		pivot=arr[first];
		left=first;
		right=last;
		while(left<right) {
			left++;
			//find elements greater than pivot
			while(left<=last&&arr[left]<pivot) {
				left++;
			}
			//find elements less than pivot
			while(right>=first&&arr[right]>pivot) {
				right--;
			}
			if(left<=last&&left<right) {
				swap(arr,left,right);
			}
		}
		swap(arr,first,right);
		return right;
	}
	
	private static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
}
