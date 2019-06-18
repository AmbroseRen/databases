package AmbroseRen.method.file;

import java.io.File;
import java.io.IOException;

/**
 * 创建File文件
 *
 */
public class File_createNewFile {

	public static void main(String[] args) throws IOException {
		
//		File file =new File("."+File.separator+"demo.txt");
		File file =new File("三.txt");
		if(!file.exists()){
			file.createNewFile();
			System.out.println("创建成功");
		}else{
			System.out.println("该文件已存在");
		}
		
		/*if(file.delete()){
			file.delete();
			System.out.println("执行完毕");
		}else{
			System.out.println("已删除");
		}*/

	}

}

