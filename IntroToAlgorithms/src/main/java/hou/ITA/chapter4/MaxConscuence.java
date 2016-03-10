package hou.ITA.chapter4;

/**
 * @author houweitao
 * @date 2015年11月22日 下午1:20:25
 * not work...
 * 2015年11月22日13:52:36
 * seem work...
 * 2015年11月22日14:01:31
 */

public class MaxConscuence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 13, 23, -18, 40, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		MaxConscuence mc = new MaxConscuence();
		System.out.println(mc.getMaxConscuence(nums, 0, nums.length-1));
//		mc.help(nums, 0, nums.length);
	}

	int getMaxConscuence(int[] nums, int begin, int end) {

		if(begin==end){
			return nums[begin];
		}else if (begin == end - 1) {
			return Math.max(nums[begin], Math.max(nums[end], nums[begin] + nums[end]));
		} 
		
		
		int mid = (begin+ end) / 2;
		int lSum = getMaxConscuence(nums, begin, mid);
		int rSum = getMaxConscuence(nums, mid+1, end);
		int cSum = help(nums, 0, nums.length);

		System.out.println("lSum: "+lSum);
		System.out.println("rsum: "+rSum);
		System.out.println("csum: "+cSum);
		
		return Math.max(lSum, Math.max(rSum, cSum));
	}

	private int help(int[] nums, int low, int high) {
		if (low == high)
			return nums[low];
		else if (high == low + 1) {
			return Math.max(nums[low], Math.max(nums[high], nums[low] + nums[high]));
		} else {

			int lSum = Integer.MIN_VALUE;
			int rSum = Integer.MIN_VALUE;
			int sum = 0;
			int maxL, maxR;
			int mid = (low + high) / 2;
			System.out.println(nums[mid]);
			for (int i = mid; i >= low; i--) {
				sum = sum + nums[i];
				if (sum > lSum) {
					lSum = sum;
					maxL = i;
				}
			}

			sum = 0;
			for (int i = mid + 1; i < high; i++) {
				sum = sum + nums[i];
				if (sum > rSum) {
					rSum = sum;
					maxR = i;
				}
			}
			
//			System.out.println(lSum+","+rSum+",");
			return Math.max(lSum, Math.max(rSum, lSum + rSum));
		}
	}
}
