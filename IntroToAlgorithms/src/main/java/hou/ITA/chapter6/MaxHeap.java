package hou.ITA.chapter6;

/**
 * @author houweitao
 * @date 2015年11月22日 下午2:03:08
 * @succeed 2015年11月22日14:53:46
 */

/**
 * 现在想想，更好的组织方式是创建一个数据结构，这个数据结构包含一个数组，一个属性max
 * max来标记堆操作的时候的边界
 * 2015年11月22日23:25:13
 */

public class MaxHeap {
	int[] heapSort(int[] nums) {
//		MaxHeap mh = new MaxHeap();
		nums = buildMaxHeap(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			int tmp = nums[i];
			nums[i] = nums[0];
			nums[0] = tmp;
			System.out.println("max: " + nums[i]);
			adjust(nums, 0, i);
			System.out.print(i + ": ");
			printArray(nums);
		}
		return nums;
	}

	int[] buildMaxHeap(int[] nums) {
		for (int i = (nums.length) / 2 - 1; i >= 0; i--)
			adjust(nums, i);

		return nums;
	}

	void adjust(int[] nums, int i) {
		// TODO Auto-generated method stub
		int largest = i;

		if (2 * i + 1 < nums.length)
			if (nums[2 * i + 1] > nums[i])
				largest = 2 * i + 1;
		if (2 * i + 2 < nums.length)
			if (nums[2 * i + 2] > nums[largest])
				largest = 2 * i + 2;

		if (largest != i) {
			int tmp = nums[i];
			nums[i] = nums[largest];
			nums[largest] = tmp;
			adjust(nums, largest);
		}
	}

	void adjust(int[] nums, int i, int max) {
		// TODO Auto-generated method stub
		int largest = i;

		if (2 * i + 1 < max)
			if (nums[2 * i + 1] > nums[i])
				largest = 2 * i + 1;
		if (2 * i + 2 < max)
			if (nums[2 * i + 2] > nums[largest])
				largest = 2 * i + 2;

		if (largest != i) {
			int tmp = nums[i];
			nums[i] = nums[largest];
			nums[largest] = tmp;
			adjust(nums, largest, max);
		}
	}

	void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ",");
		System.out.println();
	}
}
