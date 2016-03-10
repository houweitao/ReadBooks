package hou.ITA.chapter7;

/**
 * @author houweitao
 * @date 2015年11月22日 下午11:54:30
 * not finish 2015年11月23日00:42:42
 */

public class QuickSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 8, 7, 1, 3, 5, 6, 4, 20 };
		QuickSort2 qs = new QuickSort2();
		qs.quickSort(nums, 0, nums.length - 1);
		qs.printArray(nums);
		int[] num2 = { 8, 5, 6, 7 };
		qs.partition(num2, 0, num2.length - 1);
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

			System.out.println("sort: " + begin + "," + (q - 1));
			quickSort(nums, begin, q - 1);
			System.out.println("sort: " + (q + 1) + "," + end);
			quickSort(nums, q + 1, end);
		}
	}

	private int partition(int[] nums, int begin, int end) {
		int i = begin;
		int j = end - 1;
		int ret = end;

		System.out.println(j);

//		if(begin==end)
//			return begin;

//		if (begin == end - 1) {
//			if (nums[begin] > nums[end]) {
//				int tmp = nums[begin];
//				nums[begin] = nums[end];
//				nums[end] = tmp;
//
//				System.out.print("print: ");
//				printArray(nums);
//			}
//		}

		while (i < j) {
			System.out.println(i + "," + j);
			while (nums[i] < nums[end] && i < j) {
//				if(i==j)
//					return end;
				i++;
			}

			System.out.println(i);

			while (nums[j] > nums[end] && j > i) {
				j--;
			}

			int tmp = nums[j];
			nums[j] = nums[i];
			nums[i] = tmp;

//			printArray(nums);

			i++;
			j--;

			if (i >= j) {
				if (nums[i] < nums[end])
					i++;
				tmp = nums[end];
				nums[end] = nums[i];
				nums[i] = tmp;
				ret = i;

				System.out.print("return: ");
				printArray(nums);
			}
		}
		System.out.println("return: " + ret);
		return ret;
	}

	void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + ",");
		System.out.println();
	}
}
