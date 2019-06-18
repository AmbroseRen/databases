package AmbroseRen.method.file;

import java.io.File;

/**
 * 1. 1+2+3+4+.....100的结果
 * 用递归算法
 * 2.一块一瓶汽水，三瓶盖=一瓶汽水；两空瓶=一瓶汽水。
 * 20块能买几瓶水？
 * @author 天大java
 * 递归调用：
 * 方法内部调用自己方法的现象称为递归调用。
 * 递归允许程序执行到某个阶段整体重来
 * 注意点：
 * 1.递归消耗内存，运行效率差
 * 2.调用不能100%成立，会造成死循环
 *
 */
public class File_delete {

	public static void main(String[] args) {
		File file =new File("a");
		
		delete(file);
	}
	public static void delete(File file){
		if(file.isDirectory()){
			File[] subs =file.listFiles();
			for(File sub:subs){
				delete(sub);
			}
		}
		file.delete();
	}

}
