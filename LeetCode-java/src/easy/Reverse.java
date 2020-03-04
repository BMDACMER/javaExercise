package easy;

public class Reverse {

	// 使用String类的静态方法valueOf   数字----> 字母
	// 字符串转数字  parseInt
//	public int reverse(int x) {
//
//		String s = String.valueOf(x);
//		String s2= "";
//		if(x > 0) {
//			for (int i = s.length() - 1; i >= 0; i--) {
//				s2 += s.charAt(i);
//			}
//		}else {
//			s2 += s.charAt(0);
//			for (int i = s.length() - 1; i > 0; i--) {
//				s2 += s.charAt(i);
//			}
//			
//		}
//		return Integer.parseInt(s2);
//    }
//	
//	public static void main(String[] args) {
//		Reverse test = new Reverse();
//		int y = test.reverse(1534236469);
//		System.out.println(y);
//		
//	}
	
	class Solution {
	    public int reverse(int x) {
	        int ans = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
	                return 0;
	            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
	                return 0;
	            ans = ans * 10 + pop;
	            x /= 10;
	        }
	        return ans;
	    }
	}

}
