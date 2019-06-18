package AmbroseRen.kit.cmd;

import java.io.IOException;

public class osk {

	public static void main(String[] args) throws IOException {
		  //执行批处理文件
		  String strcmd="cmd /c start  d:\\public.bat";

		  Runtime rt = Runtime.getRuntime();
		  Process ps = null;
		  try {
			  ps = rt.exec(strcmd);
			  ps.waitFor();
			  int i = ps.exitValue();
			  if(i ==0){
				  System.out.println("执行完成");
			  }else{
				  System.out.println("执行失败.") ;
			  }
			  ps.destroy();
			  ps = null;
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  new osk().killProcess();
		  
	}
		
	public static void killProcess(){
		Runtime rt =Runtime.getRuntime();
		Process p =null;
		try {
			rt.exec("cmd.exe /C start wmic process where name='cmd.exe' call terminate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
