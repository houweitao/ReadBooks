package hou.ITA.chapter6;

/**
 * @author houweitao
 * @date 2015年11月22日 下午2:02:40
 * @succeed 2015年11月22日14:53:46
 */

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort hs = new HeapSort();
		int[] nums = { 1, 2, 3, 4, 5, 6 ,7};
		MaxHeap mh = new MaxHeap();
		nums=mh.heapSort(nums);
		hs.printArray(nums);
	}

	void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ",");
		System.out.println();
	}
}
