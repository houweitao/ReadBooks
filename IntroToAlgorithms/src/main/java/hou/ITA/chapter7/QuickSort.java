package hou.ITA.chapter7;

/**
 * @author houweitao
 * @date 2015年11月22日 下午11:28:34
 */

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 8, 7, 1, 3, 5, 6, 4 ,20};
		QuickSort qs = new QuickSort();
//		qs.quickSort(nums, 0, nums.length - 1);
//		qs.printArray(nums);
		
		System.out.println(qs.partition(nums, 0, nums.length-1));
	}

	void quickSort(int[] nums, int begin, int end) {
		if (begin == end) {
			System.out.println(nums[end]);
//			return;
		} else if (begin == end - 1) {
			if (nums[begin] > nums[end]) {
				int tmp = nums[begin];
				nums[begin] = nums[end];
				nums[end] = tmp;
			}
//			printArray(nums);
		} else if (begin < end) {
			int q = partition(nums, begin, end);
			System.out.println(end + "," + nums[end] + "," + q);
			quickSort(nums, begin, q - 1);
			quickSort(nums, q + 1, end);
		}
	}

	private int partition(int[] nums, int begin, int end) {
		// TODO Auto-generated method stub
		int judge = nums[end];
		int i = begin - 1;

		for (int j = begin; j < end; j++) {
			if (nums[j] <= judge) {
				i++;
				if (i >= begin) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}

		nums[end] = nums[i + 1];
		nums[i + 1] = judge;

		return i + 1;
	}

	void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ",");
		System.out.println();
	}
}
