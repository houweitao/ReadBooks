package hou.ProgrammingPearls.chapter8;

/**
 * @author houweitao
 * @date 2015年11月8日 下午10:59:49
 */

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] nums = { 1, 2, 3, -2, -5, -7, 2, 8, -1, 2 };
		lcs.linerSolution(nums);
		lcs.myIdea(nums);

		System.out.println(lcs.dividedSolution(nums));
	}

	// 用两个变量来记录过程。
	void linerSolution(int[] nums) {
		int maxSofar = 0;
		int maxEndingHere = 0;
		for (int i = 0; i < nums.length; i++) {
			maxEndingHere = max(maxEndingHere + nums[i], 0);
			maxSofar = max(maxSofar, maxEndingHere);
			System.out.println(i + "," + maxEndingHere + "," + maxSofar);
		}
//		maxSofar = max(maxSofar, maxEndingHere);

		System.out.println(maxSofar);
	}

//	不能理解。。
	int dividedSolution(int[] nums) {
		return dividedSolution(nums, 0, nums.length - 1);
	}

	int dividedSolution(int[] nums, int begin, int end) {
		if (begin > end)
			return 0;
		if (begin == end)
			return max(0, nums[begin]);

		int mid = (begin + end) / 2;
		int lMax = 0, sum = 0;
		for (int i = mid; i >= 0; i--) {
			sum = sum + nums[i];
			lMax = max(lMax, sum);
		}

		sum = 0;
		int rMax = 0;
		for (int i = mid + 1; i < end; i++) {
			sum = sum + nums[i];
			rMax = max(rMax, sum);
		}

		return max(lMax + rMax, max(dividedSolution(nums, 0, mid), dividedSolution(nums, mid + 1, end)));
	}

	void myIdea(int[] nums) {
//		int i = 0, j = 1;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i];
			if (tmp > max)
				max = tmp;
			for (int j = i + 1; j < nums.length; j++) {
				tmp = tmp + nums[j];
				if (tmp > max) {
					max = tmp;
//					System.out.println(nums[j]);
				}
			}
		}

		System.out.println(max);
	}

	private int max(int i, int j) {
		// TODO Auto-generated method stub
		if (i > j)
			return i;
		else
			return j;
	}
}
