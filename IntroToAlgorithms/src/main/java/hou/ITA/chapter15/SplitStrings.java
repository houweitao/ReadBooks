package hou.ITA.chapter15;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年11月25日 上午9:52:51
 * @end? 2015年11月25日10:14:01
 * 可以出结果，但是怎么把路径很好的展示出来呢？试试栈.. not work..
 */

public class SplitStrings {

	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitStrings ss = new SplitStrings();
		int[] split = { 0, 5, 8, 10, 17, 20 };
		int ret = ss.splitStrings(split, 0, split.length - 1, 1);
		System.out.println(ret);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	//clear version
	int splitStrings(int[] split, int begin, int end) {
		if (begin + 1 == end)
			return 0;
		else if (begin + 2 == end) {
			return (split[end] - split[begin]);
		} else {
			int ret = Integer.MAX_VALUE;
			for (int i = begin + 1; i < end; i++) {
				ret = Math.min(ret,
						splitStrings(split, i, end) + splitStrings(split, begin, i) + split[end] - split[begin]);
			}
			return ret;
		}
	}

	//这里数组的第一个点是0，也就是棍子的开始。最后一个点是棍子的长度..方便处理
	int splitStrings(int[] split, int begin, int end, int id) {
//		System.out.println("id: "+id);
		if (begin + 1 == end)
			return 0;
		else if (begin + 2 == end) {
			System.out.println("split place: " + (begin + 1) + ": " + split[begin + 1]);
			return (split[end] - split[begin]);
		} else {
			int ret = Integer.MAX_VALUE;
			int change = ret;
			int mark = -1;
			for (int i = begin + 1; i < end; i++) {
				ret = Math.min(ret, splitStrings(split, i, end, id + 1) + splitStrings(split, begin, i, id + 1)
						+ split[end] - split[begin]);
				if (change != ret) {
//					System.out.println(split[begin] + "-" + split[end] + "   change!分割点：" + split[i] + "  大小： " + ret);
					change = ret;
					mark = i;
					if (stack.isEmpty())
						stack.push(mark);
					else {
						stack.pop();
						stack.push(mark);
					}
				}
			}
			System.out.println("split place: " + mark + ": " + split[mark]);
			System.out.println();
			return ret;
		}
	}
}
