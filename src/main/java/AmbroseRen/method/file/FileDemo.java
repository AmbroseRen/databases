package AmbroseRen.method.file;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * java.io.file
 * File的每个实例用于表示文件系统中的一个文件或目录
 * 
 * 使用File可以：
 * 1.访问文件或目录的属性信息（名字，大小，修改日期）
 * 2.操作文件或目录（创建，删除）
 * 3.若表示的是目录，可以查看该目录中的子项信息
 * 
 * 但不能访问一个文件中的数据							
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		/**
		 * 尽量使用相对路径，可以避免平台差异
		 * "."：当前目录，指当前项目的根目录
		 */
		File file =new File("."+File.separator+"demo.txt");
		System.out.println(file);
		String name =file.getName();
		System.out.println(name);
		long len =file.length();
		System.out.println(len);
		
		boolean cr =file.canRead();
		boolean cw =file.canWrite();
		boolean ih =file.isHidden();
		System.out.println(cr);
		System.out.println(cw);
		System.out.println("是否隐藏： "+ih);
		
		long time =file.lastModified();
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss MM-dd-yyyy");
		String date =sdf.format(time);
		System.out.println(date);
	}

}
