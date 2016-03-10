package hou.ProgrammingPearls.chapter4;

import java.util.Arrays;
import java.util.Random;

/**
 * @author houweitao 
 * @date 2015年11月7日 下午4:18:09
 * @end 2015年11月7日16:56:54 惭愧。。
 */

public class BinerySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = { 1, 31, 5, 2, 66, 3, 7, 23 };
		int[] nums = new int[50];
		Random random = new Random();

		for (int i = 0; i < 50; i++)
			nums[i] = random.nextInt(100);

		BinerySearch bs = new BinerySearch();
//		System.out.println(bs.isIn(nums, 66));

		for (int i = 1; i < 100; i++) {
			System.out.println(i + "," + bs.isIn(nums, i));
		}
	}

	boolean isIn(int[] nums, int n) {
		int i = 0, j = nums.length - 1;
		Arrays.sort(nums);

//		for (int index = 0; index < nums.length; index++)
//			System.out.print(nums[index] + ",");
//		System.out.println();

		while (i <= j) {
			int mid = (i + j) / 2;
//			System.out.println(n + ":" + i + "," + mid + "," + j);
			if (nums[mid] == n)
				return true;
			else if (nums[mid] > n) {
				j = mid - 1;// 一开始写成j=mid;实际上mid已经比较过了！
			} else {
				i = mid + 1;// 一开始写成i=mid
			}
		}

		return false;
	}
}
