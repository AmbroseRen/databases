package AmbroseRen.method.file;

import java.io.File;
import java.io.FileFilter;

/**
 * File的一个重载的listFiles（），该方法可以指定一个文件过滤器，
 * 将目录中所有满足要求的子项全部获取到
 *
 */
public class File_listFilse2 {

	public static void main(String[] args) {
		File dir =new File(".");
		File[] subs =dir.listFiles(new FileFilter(){

			@Override
			public boolean accept(File subs) {
				String name = subs.getName();
				System.out.println("正在过滤的："+name);
				//System.out.println(name);
				
				return subs.isFile();
			}
			
		});
		for(File sub:subs){
			System.out.println(sub.getName());
		}
		
	}

}

