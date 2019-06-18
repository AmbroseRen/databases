package AmbroseRen.method.file;

import java.io.File;

/**
 * 获取目录中所有子项
 *
 */
public class File_listFils {

	public static void main(String[] args) {
		/**
		 * 查看当前目录所有子项
		 */
		File dir =new File(".");
		/**
		 * boolean isFile()
		 * 判断当前File表示的是否是一个文件
		 * 
		 * booelean isDirectory
		 *  判断当前File表示的是否为一个目录
		 */
		if(dir.isDirectory()){
			//获取子项目录
			File[] file =dir.listFiles();
			System.out.println("子项个数为："+file.length);
			for(File sub:file){
				if(sub.isFile()){
					System.out.print("文件为：");
				}
				if(sub.isDirectory()){
					System.out.print("目录为：");
				}
				
				System.out.println(sub.getName());
			}
		}

	}

}

