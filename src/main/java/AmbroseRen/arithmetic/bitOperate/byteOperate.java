package AmbroseRen.arithmetic.bitOperate;

public class byteOperate {
	public static void main(String[] args) {
		byte a =(byte)4>>>1&0xf;//0100--
		byte b =(byte)-10>>>1&0xf;//1010--0101
		byte c =(byte)0100>>>1&0xf;//0000
		byte d =(byte)1000>>>1&0xf;//0100--
		
		System.out.println(a);//0		0000
		System.out.println(b);//4		0100
		System.out.println(c);//0		0000
		System.out.println(d);//4		0100
		System.out.println("===");
		
		byte a1 =(byte)0001>>>1;//0000--
		byte b1 =(byte)0010>>>1;//0100
		byte c1 =(byte)0100>>>1;//0010 0000
		byte d1 =(byte) ((byte)1000>>>1);//
		
		System.out.println(a1);//0
		System.out.println(b1);//4
		System.out.println(c1);//32
		System.out.println(d1);//-12
		System.out.println("===");
		
		int a2 =0001>>>1;//
		int b2 =0010>>>1;//1010
		int c2 =0100>>>1;//
		int d2 =1000>>>1;//
		
		System.out.println(a2);
		System.out.println(b2);
		System.out.println(c2);
		System.out.println(d2);
		System.out.println("==");
		
		int m =2<<4;
		int n =2^3;
		System.out.println(m);
//		System.out.printf("%+d",m);
		System.out.println(n);
		
		int s1 =4>>>2&0xf;//0100--
		System.out.println(s1);
	}
	
}
