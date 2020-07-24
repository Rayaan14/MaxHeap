package problem01;

import java.util.ArrayList;

/**
 * @author Rayaan Attari
 * @version April 2020
 */

public class GenericMaxHeap <T extends Comparable<T>>
{
	public int heapSize;
	private int heapLength;
	public ArrayList<T> A;

	/**
	 * @param A, an array of generic type objects
	 * constructor to build a max-heap
	 */
	public GenericMaxHeap(T[] A)
	{
		this.heapSize = A.length;
		this.heapLength = 2 * this.heapSize;

		this.A = new ArrayList<T>(heapLength); //store in an arraylist

		T maxVal = A[0];

		for (T item : A) {
			if(item.compareTo(maxVal) > 0)
				maxVal = item;
		}

		this.A.add(maxVal); //for safety

		for(int i = 0; i < A.length; i++)
			this.A.add(A[i]);

		for(int i = heapSize/2 ; i >= 1; i--)
			maxHeapify(i);

	}

	public int parent(int i)
	{
		return i/2;
	}

	public int left(int i)
	{
		return i*2;
	}
	public int right(int i)
	{
		return i*2 + 1;
	}

	public void maxHeapify(int i)
	{
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = i;

		if(left <= this.heapSize && A.get(left).compareTo(A.get(largest)) > 0)
			largest = left;
		if (right <= this.heapSize && A.get(right).compareTo(A.get(largest)) > 0)
			largest = right;

		if (largest != i)
		{
			T temp = A.get(i);
			A.set(i, A.get(largest));
			A.set(largest, temp);
			maxHeapify(largest);
		}

	}

	/**
	 * @param i, an index
	 * method to heapify ith node in a heap following a bottom-up approach
	 */
	public void heapify(int i) 
	{
		int p = parent(i);

		if (i > 1 && A.get(i).compareTo(A.get(p)) > 0) {
			T temp = A.get(i);
			A.set(i, A.get(p));
			A.set(p, temp);

			heapify(p);
		}
	}

	/**
	 * @param val, an integer
	 * method to insert a value into the existing heap
	 */
	public void insertAnElement(T val) 
	{
		if (heapSize == heapLength)
			this.heapLength = 2 * heapSize; //re-adjusting heap length if heap is full

		heapSize++; 
		A.set(heapSize, val); //insert element at end of heap
		heapify(heapSize);

	}

	/**
	 * @param val, an integer
	 * @return val, the deleted node
	 * method to delete an element form an existing heap
	 */
	public T deleteAnElement(T val) 
	{
		int i;

		for(i = 1; i <= heapSize; i++) {

			if (A.get(i).compareTo(val) == 0) //find index of element to be deleted
				break;
		}

		if(heapSize + 1 == i) 
			System.out.println("The element does not exist!");

		else {
			T last = A.get(heapSize); 
			A.set(i, last); //replace deleted node with farthest right node
			heapSize--;
			maxHeapify(i); //heapify
		}

		return val;

	}

	/**
	 * @return root, the deleted node
	 * method to delete maximum value from an existing heap
	 */
	public T deleteMax() 
	{
		T root = A.get(1);
		return deleteAnElement(root); 

	}


}
