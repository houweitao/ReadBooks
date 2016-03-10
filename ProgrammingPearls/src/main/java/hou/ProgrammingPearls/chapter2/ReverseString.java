package hou.ProgrammingPearls.chapter2;

/**
 * @author houweitao
 * @date 2015年11月6日 下午1:15:16
 */

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString rs=new ReverseString();
//		rs.reverse("abcdefg");
		rs.work("abcdefg", 3);
	}

	void work(String s,int reversePlace){
		String s1=reverse(s.substring(0, reversePlace));
		String s2=reverse(s.substring(reversePlace));
		
		String s3=s1+s2;
		s3=reverse(s3);
		System.out.println("finally: "+s3);
	}
	
	String reverse(String s){
		String tmp="";
		
		for(int i=s.length()-1;i>=0;i--){
			tmp=tmp+s.charAt(i)+"";
		}
		
		System.out.println("input:"+s+" output: "+tmp);
		
		return tmp;
	}
}
