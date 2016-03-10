package hou.ITA.chapter15;

/**
 * @author houweitao
 * @date 2015年11月24日 下午3:28:14
 * http://blog.csdn.net/wdq347/article/details/9235349
 * @woring!! 2015年11月24日16:25:52
 */

public class NiceOrderPlace {

	int length = 15;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] words = { 2, 3, 2, 8, 4, 5, 2, 5, 7, 2, 4, 5, 1, 3, 5, 5, 6, 7, 4 };
		NiceOrderPlace no = new NiceOrderPlace();

		for (int i = 1; i <= words.length; i++) {
			int out = no.niceOrderPlace(words, i);
			System.out.println("前" + i + "个单词最小空闲, " + out);
		}

		int out = no.left_space(words, 4, 5);
		System.out.println(out);

//		int basic[] = no.getBasic(words);
//		System.out.println(basic.length);
//		for (int i = 0; i < basic.length; i++)
//			System.out.print(basic[i] + ",");
//		System.out.println();
	}

	int niceOrderPlace(int[] words, int num) {
		int[] basic = getBasic(words);
		int basicNum = basic.length;

		if (num == 1)
			return (length - words[0]) * (length - words[0]) * (length - words[0]);

		int[] minGroup = new int[num];
		minGroup[0] = basic[0];
		for (int i = 1; i < num; i++) {// i下标从0开始。1代表第二个数字。
			int min = Integer.MAX_VALUE;
			if (i < basicNum)
				min = basic[i];
			for (int k = 1; k <= i; k++) {// 如果k=i，即代表最后一个单词独占一行。k=i-1，代表最后2个单词独占一行。前面是best(i-2)+last
				int last = left_space(words, k, i);
				if (last >= 0) {
//					min = Math.min(min, minGroup[k - 1] + last);
					if (min > minGroup[k - 1] + last) {
						min = minGroup[k - 1] + last;
						System.out.println((i + 1) + ": 分割: " + k + "," + i + ", " + words[k] + "-" + words[i]);
					}

				}
			}
//			System.out.println("minGroup: " + (i) + ": " + min);
			minGroup[i] = min;
		}

		return minGroup[num - 1];
	}

	int[] getBasic(int[] words) {
//		int initNum = getBlank(words, words.length);
		int initNum = getMaxFirst(words);
		int[] basic = new int[initNum];
		int sum = 0;
		for (int i = 0; i <= initNum - 1; i++) {
			sum = sum + words[i] + 1;
			basic[i] = (length - sum + 1) * (length - sum + 1) * (length - sum + 1);
		}

		return basic;
	}

	private int getMaxFirst(int[] words) {
		// TODO Auto-generated method stub
		if (words[0] > length)
			return 0;
		else {
			int sum = 0;
			for (int i = 0; i < words.length; i++) {
				sum = sum + words[i] + 1;
				if (sum > length + 1)
					return i + 1 - 1;
			}
		}
		return words.length;
	}

	private int left_space(int[] words, int m, int n) {
		// TODO Auto-generated method stub
		int space = 0;
		for (int i = m; i <= n; i++) {
			space = space + words[i] + 1;
		}
		space--;
		if (space > length)
			return -1;
		else if (space == length)
			return 0;
		else
			return (length - space) * (length - space) * (length - space);
	}

	boolean over(int[] words, int k) {
		if (words[0] > length)
			return true;

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + words[i] + 1;
		}
		if (sum - 1 > length)
			return false;
		else
			return true;
	}

	private int getBlank(int[] words, int k) {

		for (int i = 0; i < k; i++) {
			if (!over(words, i + 1)) {
				return i + 1;
			}
		}
		return k;

	}

	private int M(int k) {
		return 0;
	}
}
