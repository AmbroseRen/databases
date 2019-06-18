package AmbroseRen.method.byteStream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf =new RandomAccessFile("raf.dat", "rw");
		System.out.println("初始指针位置："+raf.getFilePointer());
		
		int max =Integer.MAX_VALUE;
		raf.write(max >>>  24);//高8位移到低八位
		System.out.println("24=="+raf.getFilePointer());
		
		raf.write(max >>> 16); //
		System.out.println("16=="+raf.getFilePointer());
		
		raf.write(max >>> 8); //
		System.out.println("8=="+raf.getFilePointer());
		
		raf.write(max); //
		System.out.println("0=="+raf.getFilePointer());
		
		/**
		 * 将int对应字节一次性写出
		 */
		raf.writeInt(25);
		System.out.println("int=="+raf.getFilePointer());
		
		raf.writeLong(123L);
		System.out.println("Long=="+raf.getFilePointer());
		
		raf.writeDouble(103.123);
		System.out.println("Double=="+raf.getFilePointer());
		System.out.println("===========");
		/**
		 * void seek(long)
		 * 移到指针到指定位置
		 */
		raf.seek(0);
		System.out.println("指针移到位置："+raf.getFilePointer());
		
		/**
		 * 连续读取4字节，并返回int值
		 */
		System.out.println(raf.readInt());
		System.out.println("seekInt=="+raf.getFilePointer());
		
		System.out.println(raf.readDouble());
		System.out.println("seekDouble=="+raf.getFilePointer());
		
		System.out.println("over");
		raf.close();
	}
}
