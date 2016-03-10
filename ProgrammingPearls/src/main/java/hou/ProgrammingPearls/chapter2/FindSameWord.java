package hou.ProgrammingPearls.chapter2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author houweitao
 * @date 2015年11月6日 下午1:42:57
 * @end 2015年11月6日15:29:14
 */

public class FindSameWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "doc//obama.txt";
		FindSameWord fs = new FindSameWord();
		String txt = fs.getTXT(filename);
		ArrayList<String> arrayList = new ArrayList<String>();
		HashMap<String, String> fingerPrint = new HashMap<String, String>();

		StringTokenizer st = new StringTokenizer(txt, ", ! ' . ��");// 按逗号/空格/叹号分割,其他字符自行添加

		while (st.hasMoreElements()) {
			String tmp = (String) st.nextElement();
			if (tmp != "" && tmp != null && tmp != "s" && !arrayList.contains(tmp.toLowerCase()))
				arrayList.add(tmp.toLowerCase());
		}

		System.out.println(arrayList.size());
		fs.sortList(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
//			System.out.println(i + "," + arrayList.get(i) + ":");
			if (!fingerPrint.containsKey(fs.makeFinger(arrayList.get(i))))
				fingerPrint.put(fs.makeFinger(arrayList.get(i)), arrayList.get(i));
			else
				fingerPrint.put(fs.makeFinger(arrayList.get(i)),
						fingerPrint.get(fs.makeFinger(arrayList.get(i))) + "," + arrayList.get(i));
		}

		for (Map.Entry<String, String> entry : fingerPrint.entrySet()) {
//			System.out.println(entry.getKey() + "--->" + entry.getValue());
			if (entry.getValue().contains(","))
				System.out.println(entry.getKey() + "--->" + entry.getValue());
		}

//		System.out.println(fs.stringSort("alive"));
//		System.out.println(fs.makeFinger("aliive"));
	}

	String getTXT(String filename) {
		String txt = "";
		try {
			File file = new File(filename);
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
				txt = txt + s;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}

	ArrayList<String> sortList(ArrayList<String> al) {
		for (int i = 0; i < al.size(); i++) {
			for (int j = i + 1; j < al.size(); j++) {
				if (!stringCompare(al.get(i), al.get(j))) {
					String tmp = al.get(i);
					al.set(i, al.get(j));
					al.set(j, tmp);
				}

			}
		}
		return al;
	}

	boolean stringCompare(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		int length = 0;
		if (aLength > bLength)
			length = bLength;
		else
			length = aLength;
		for (int i = 0; i < length; i++) {
			if (a.charAt(i) < b.charAt(i))
				return true;
			if (a.charAt(i) > b.charAt(i))
				return false;
		}

		if (aLength > bLength)
			return false;
		else
			return true;
	}

	String makeFinger(String s) {
		if (s.length() == 1)
			return s;

		String fingerPrint = "";

		String print = stringSort(s);

//		System.out.println("print"+print);

		char now = print.charAt(0);
		int count = 1;

		for (int i = 1; i < print.length(); i++) {
			if (print.charAt(i) == now) {
				count++;
				if (i == print.length() - 1)
					fingerPrint = fingerPrint + String.valueOf(now) + String.valueOf(count);
			} else {
				if (count == 1)
					fingerPrint = fingerPrint + String.valueOf(now);
				else
					fingerPrint = fingerPrint + String.valueOf(now) + String.valueOf(count);
				count = 1;
				now = print.charAt(i);
				if (i == print.length() - 1)
					fingerPrint = fingerPrint + String.valueOf(now);
			}
		}
//		System.out.println(fingerPrint);
		return fingerPrint;
	}

	String stringSort(String s) {
		String after = "";

		char[] tmp = s.toCharArray();

		for (int i = 0; i < tmp.length; i++) {
			for (int j = i + 1; j < tmp.length; j++) {
				if (tmp[i] > tmp[j]) {
					char hou = tmp[j];
					tmp[j] = tmp[i];
					tmp[i] = hou;
				}
			}
		}
		after = String.valueOf(tmp);

//		System.out.println(after);
		return after;
	}
}
