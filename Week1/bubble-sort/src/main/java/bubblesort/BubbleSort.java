package bubblesort;

import java.util.*;

public class BubbleSort {

	public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements in the array: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        bubbleSort(arr);
	}

	private static void bubbleSort(int[] lst) {
        int n = lst.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                if (lst[i] > lst[i+1]) {
                    int temp = lst[i];
                    lst[i] = lst[i+1];
                    lst[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);
        System.out.println(Arrays.toString(lst));
    }

}
