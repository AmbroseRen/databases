package AmbroseRen.method.file;

import java.io.File;

public class File_mkdir {
	public static void main(String[] args) {
		/**
		 * 在当前目录中创建目录demo
		 */
		File dir =new File("."+File.separator+"demo11");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("创建成功");
		}else{
			System.out.println("该目录已存在！");
		}
		
		/**
		 * 删除目录前提：内容必须是空的！
		 */
		if(dir.exists()){
			dir.delete();
			System.out.println("删除完毕");
		}else{//恒定不存在
			System.out.println("该目录不存在");
		}
	}
}
