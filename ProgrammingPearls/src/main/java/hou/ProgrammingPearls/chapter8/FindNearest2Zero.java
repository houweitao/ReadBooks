package hou.ProgrammingPearls.chapter8;

/**
 * @author houweitao
 * @date 2015年11月9日 下午1:05:06
 * @source 《编程珠玑》第八章第14题
 */

public class FindNearest2Zero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, -8, 6 };
		FindNearest2Zero find = new FindNearest2Zero();
		find.findOut(nums);
	}

	void findOut(int[] nums) {
		int nearSofar = 1000;
		int nearEndHere = 1000;
		int mark = -1;
		for (int i = 0; i < nums.length; i++) {
			nearEndHere = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				nearEndHere = nearEndHere + nums[j];
				if (near(nearEndHere, nearSofar)) {
					nearSofar = nearEndHere;
					mark = i;
					System.out.println("change:" + nearSofar);
				}
			}
		}
		System.out.println(mark);
	}

	boolean near(int a, int b) {
		int aDis = Math.abs(a - 0);
		int bDis = Math.abs(b - 0);

		if (aDis < bDis)
			return true;
		else
			return false;
	}
}
