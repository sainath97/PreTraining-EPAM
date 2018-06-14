package mergesort;

import java.util.*;

public class MergeSort{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements in the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int sortedArr[]=new int[n];
        sortedArr=mergeSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
    
    private static int[] mergeSort(int arr[]) {
    	int n=arr.length;
    	if(n==1)
    		return arr;
    	int left[],right[];
    	if(n%2==0) {
    		left=new int[n/2];
    		right=new int[n/2];
    	}
    	else {
    		left=new int[n/2];
    		right=new int[n/2+1];
    	}
    	//Dividing the Arrays till length of partition becomes 1
    	left=Arrays.copyOfRange(arr, 0, n/2);
    	right=Arrays.copyOfRange(arr, n/2, n);
    	left=mergeSort(left);
    	right=mergeSort(right);
    	//sorting and merging the partitions
    	return merge(left,right);
    }
    
    private static int[] merge(int[] left,int[] right) {
    	int result[]=new int[left.length+right.length];
    	int i=0,j=0,index=0;
    	while(i<left.length&&j<right.length) {
    		if(left[i]<right[j])
    			result[index++]=left[i++];
    		else
    			result[index++]=right[j++];
    	}
    	while(i<left.length)
    		result[index++]=left[i++];
    	while(j<right.length)
    		result[index++]=right[j++];
    	return result;
    }
}
