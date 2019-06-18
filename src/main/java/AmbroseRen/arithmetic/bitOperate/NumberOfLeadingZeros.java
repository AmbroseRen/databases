package AmbroseRen.arithmetic.bitOperate;

/**  
*   Integer类toBinaryString（）方法探究
*   
* 项目名称：AmbroseRen  
* 类名称：NumberOfLeadingZeros  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月13日 下午4:13:15  
* @version       
*/ 
public class NumberOfLeadingZeros {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString((int)1000 & 0xff));
		
		int a ='f';
		System.out.println(a);
		int b= numberOfLeadingZeros(a);
		System.out.println(b);
	}
	
	  private static String toUnsignedString0(int val, int shift) {
	        // assert shift > 0 && shift <=5 : "Illegal shift value";
	        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
	        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
	        char[] buf = new char[chars];

	        formatUnsignedInt(val, shift, buf, 0, chars);

	        // Use special constructor which takes over "buf".
	        return new String(buf);//, true
	    }
	  static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
	        int charPos = len;
	        int radix = 1 << shift;
	        int mask = radix - 1;
	        do {
	            buf[offset + --charPos] = digits[val & mask];
	            val >>>= shift;
	        } while (val != 0 && charPos > 0);

	        return charPos;
	    }
	   final static char[] digits = {
		        '0' , '1' , '2' , '3' , '4' , '5' ,
		        '6' , '7' , '8' , '9' , 'a' , 'b' ,
		        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
		    };
	   
	   //判断位数
	   public static int numberOfLeadingZeros(int i) {
	        // HD, Figure 5-6
	        if (i == 0)
	            return 32;
	        int n = 1;
	        if (i >>> 16 == 0) { n += 16; i <<= 16; }
	        if (i >>> 24 == 0) { n +=  8; i <<=  8; }
	        if (i >>> 28 == 0) { n +=  4; i <<=  4; }
	        if (i >>> 30 == 0) { n +=  2; i <<=  2; }
	        n -= i >>> 31;
	        return n;
	   }
	   
}
