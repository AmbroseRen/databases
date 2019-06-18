package AmbroseRen.arithmetic.bitOperate;

import java.lang.Integer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ToBinaryString {
	/*public static void main(String[] args) 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			ClassNotFoundException, InstantiationException {
		byte b=(byte)127;
		int a1 =10;
	    System.out.println(Integer.toBinaryString(b & 0xff));
	    System.out.println(Integer.toBinaryString(a1 & 0xff));
		Class<?> c3 =Class.forName("java.lang.Integer");
		Constructor con1 =c3.getDeclaredConstructor(String.class);
		//3)通过构造函数对象构建类的对象
		Object obj =con1.newInstance(10);
		
		c3.getDeclaredMethod("", Object.class);
		Class c1 =Class.forName("AmbroseRen.reflect.Students");
//	    pac3 pac3 =new pac3();
//	    Method method =pac3.getClass().getDeclaredMethod("toUnsignedString", Object.class);
//	    System.out.println(pac3.class.getMethod("toUnsignedString", Object.class));
	    //反射调用私有方法
	    java.lang.Integer integer =new java.lang.Integer(10);
	    Method method =integer.getClass().getMethod("toBinaryString", Object.class);
//	    Method method =pac3.class.getMethod("toUnsignedString", Object.class);
	    method.setAccessible(true);
	    Object str =method.invoke(integer,10);
	    System.out.println(str);
//	    String tString  =integer.toUnsignedString(0, 0);
	}*/
	
	public static void main(String[] args) {
		String str =toUnsignedString(35,10);
		System.out.println(Integer.toBinaryString((int)1000 & 0xff));
		System.out.println(str);
		
		
		System.out.println(digits[35]);
	}
	
    private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[i & mask];
            i >>>= shift;
        } while (i != 0);

        return new String(buf, charPos, (32 - charPos));
    }
    
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
	
	public static String bytes2HexString(byte[] b) {
		  String ret = "";
		  for (int i = 0; i < b.length; i++) {
			   String hex = Integer.toHexString(b[ i ] & 0xFF);
			   if (hex.length() == 1) {
			    hex = '0' + hex;
			   }
		   ret += hex.toUpperCase();
		  }
		  return ret;
	}
	
}
