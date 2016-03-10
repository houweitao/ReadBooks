package hou.ProgrammingPearls.chapter3;

/**
 * @author houweitao 
 * 2015年11月7日 上午10:42:39
 */

public class TaxRate {
	public static void main(String[] args) {
		int[] basetax = new int[25];
		int[] lowerbound = new int[25];
		double[] taxrate = new double[25];
		basetax[0] = 0;
		lowerbound[0] = 0;
		taxrate[0] = 0;

		basetax[1] = 0;
		lowerbound[1] = 2200;
		taxrate[1] = 0.14;
		
		for (int i = 2; i < 25; ++i) {
			basetax[i] = 75 * i - 80;
			lowerbound[i] = 2200 + (i - 1) * 500;
			taxrate[i] = (double) (14 + i - 1) / 100;
			System.out.println(i + "," + basetax[i] + "," + taxrate[i]);
		}
		int salary = 122000;
		int lb = search(lowerbound, salary);

		if (lb != 0) {
			int j = lb;
			double tax = basetax[j] + (double) taxrate[j] * (salary - lowerbound[j]);

			System.out.println(lb + "," + tax);
		}
	}

	static int search(int lowerbound[], int income) {
		if (income >= 14700)
			return 24;

		int i = 0;
		int j = 25;
		int t = (i + j) / 2;

		while (true) {
			if (income - lowerbound[t] < 500 && income - lowerbound[t] >= 0)
				return t;
			else if (income - lowerbound[t] < 0) // 在左侧寻找
			{
				j = t;
				t = (i + j) / 2;
			} else {
				i = t;
				t = (i + j) / 2;
			}
		}
	}
}
