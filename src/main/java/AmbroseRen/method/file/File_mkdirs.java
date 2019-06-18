package AmbroseRen.method.file;

import java.io.File;

/**
 * 创建多级目录
 *
 */
public class File_mkdirs {

	public static void main(String[] args) {
		File dir =new File("看我在不在"+File.separator+"我乃分身"+File.separator+
				"我不存在"+File.separator+"别找我啊"+File.separator+"无限小");
		/*File dir1 =new File("a"+File.separator+
				"b"+File.separator+
				"c"+File.separator+
				"d"+File.separator
				);*/
		if(!dir.exists()){
			//mkdirs（）会创建层级目录，mkdir（）则需要父目录存在才能创建
			dir.mkdirs();
			System.out.println("目录创建完毕");
		}else{
			System.out.println("该目录已存在");
		}

	}

}

