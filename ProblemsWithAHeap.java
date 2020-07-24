package problem01;

/**
 * @author Fahmida Hamid
 * @author Rayaan Attari
 * @version April 2020
 */

class MaxHeap
{
	private int[] A;
	private int heapSize;
	private int heapLength;


	public MaxHeap(int[] A)
	{
		/*
		 * This constructor is basically building a max-heap
		 * */

		this.heapSize = A.length;
		this.heapLength = 2 * this.heapSize;

		this.A = new int[heapLength];

		for(int i = 0; i < A.length; i++)
			this.A[i+1] = A[i];
		A[0] = Integer.MAX_VALUE; // just for safety :)

		for(int i = heapSize/2 ; i >= 1; i--)
			maxHeapify(i);

	}

	public void printHeap()
	{

		for(int i = 1; i <= heapSize; i++)
			System.out.print(this.A[i] + "  ");
		System.out.println();

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

		if(left <= this.heapSize && A[left]> A[largest])
			largest = left;
		if (right <= this.heapSize && A[right] > A[largest])
			largest = right;

		if (largest != i)
		{
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
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

		if (i > 1 && A[i] > A[p]) { //swap A[i] & A[p]
			int temp = A[i];
			A[i] = A[p];
			A[p] = temp;

			heapify(p);
		}
	}

	/**
	 * @param val, an integer
	 * method to insert a value into the existing heap
	 */
	public void insertAnElement(int val) 
	{
		if (heapSize == heapLength)
			this.heapLength = 2 * heapSize; //re-adjusting heap length if heap is full

		heapSize++; //increment heap size
		A[heapSize] = val; //insert element at end of heap
		heapify(heapSize);

	}

	/**
	 * @param val, an integer
	 * @return val, the deleted node
	 * method to delete an element form an existing heap
	 */
	public int deleteAnElement(int val) 
	{
		int i;

		for(i = 1; i <= heapSize; i++) {
			if (A[i] == val) //find index of element to be deleted
				break;
		}

		if(heapSize + 1 == i) 
			System.out.println("The element does not exist!");

		else {
			int last = A[heapSize]; 
			A[i] = last; //replace deleted node with farthest right node
			heapSize--;
			maxHeapify(i); 
		}

		return val;

	}

	/**
	 * @return root, the deleted node
	 * method to delete maximum value from an existing heap
	 */
	public int deleteMax() 
	{
		int root = A[1];
		return deleteAnElement(root); 

	}

}



public class ProblemsWithAHeap {

	public static void main(String[] args) {

		/*
		Integer[] someArray =  {10, 17, 90, -5, 22, 17, 12, 5};
		GenericHeap<Integer> ghp = new GenericHeap<Integer>(someArray);
		ghp.printHeap();
		 */

		/*
		int[] someArray =  {10, 17, 90, -5, 22, 17, 12, 5};
		MaxHeap heap1 = new MaxHeap(someArray);
		heap1.printHeap();

		heap1.insertAnElement(1);
		heap1.printHeap();
		heap1.insertAnElement(30);
		heap1.printHeap();

		heap1.deleteAnElement(90);
		heap1.printHeap();
		heap1.deleteAnElement(-15);
		heap1.printHeap();

		heap1.deleteMax();
		heap1.printHeap();
		 */


		Employee e1 = new Employee("David", "Male", 75);
		Employee e2 = new Employee("Emma", "Female", 100);
		Employee e3 = new Employee("Iqbal", "Male", 250);
		Employee e4 = new Employee("Harry", "Male", 20);
		Employee e5 = new Employee("Leia", "Female", 50);
		Employee e6 = new Employee("Larry", "Male", 80);
		Employee e7 = new Employee("Fatema", "Female", 150);
		Employee e8 = new Employee("George", "Male", 100);
		Employee e9 = new Employee("Ashley", "Female", 90);
		Employee e10 = new Employee("Maria", "Female", 60);

		Employee[] empList = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
		GenericMaxHeap<Employee> heap2 = new GenericMaxHeap<Employee>(empList);

		for(int i = 1; i <= heap2.heapSize; i++) {
			System.out.print(heap2.A.get(i).toString());
		}

	}

}
