package hou.ProgrammingPearls.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author houweitao
 * @date 2015年11月7日 下午4:57:36
 * @end 2015年11月7日17:07:42
 * 一个班级有60人。平均生日相同的同学的个数？
 */

public class RepeatBirthday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatBirthday rb = new RepeatBirthday();
		rb.show(60);
		int count = 0;
		int[] nums = new int[100];
		for (int i = 0; i < 100; i++) {
			nums[i] = rb.show(60);
			count = count + nums[i];
		}
		System.out.println(count / 100);
	}

	int show(int n) {
		Random random = new Random();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int[] birth = new int[n];
		for (int i = 0; i < n; i++)
			birth[i] = random.nextInt(365);

		Arrays.sort(birth);
		for (int i = 0; i < n; i++) {
			System.out.print(birth[i] + ",");
			if (!al.contains(birth[i]))
				al.add(birth[i]);
		}
		System.out.println();
		System.out.println(n - al.size());

		return n - al.size();
	}
}
