package AmbroseRen.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import AmbroseRen.util.Tools;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class ScanlPort {
	
	public String OpenPortCode(HttpServletRequest request) {
        //1.定义变量
        CommPortIdentifier COM13 = null;//未打卡的端口
        SerialPort serialCOM13 = null;//打开的端口
        OutputStream outputStream =null;
        InputStream inputStream = null;//端口输入流
        String billKey =null;
        String URL =null;
        
        try{
            //2.获取并打开串口COM13
            COM13 = CommPortIdentifier.getPortIdentifier("COM13");
            serialCOM13 = (SerialPort) COM13.open("COM13Listener", 1000);
            
            //写入扫描枪启动命令
//            byte[] order = new byte[]{ '0', 'x', 'F', 'F', ',' ,'0', 'x', '5', '4' , ',','0', 'x', '0', 'D'};
//            outputStream = serialCOM13.getOutputStream();
//            outputStream.write(new byte[] { '0', 'x', 'F', 'F', ',' });
//            outputStream.write(new byte[] { '0', 'x', '5', '4' , ','});
//            outputStream.write(new byte[] { '0', 'x', '0', 'D' });
//            String order1 = com.cn.sys.kit.util.Method.byte2HexString(order);
            
            String order ="0xFF0x540x0D";
            byte[] order1 = Tools.hexStringToByteArray(order);
            outputStream = serialCOM13.getOutputStream();
            outputStream.write(order1);
			outputStream.flush();
			outputStream.close();
            
            //3.获取串口的输入流对象
            inputStream = serialCOM13.getInputStream();
            
            //4.从串口读入数据
            //定义用于缓存读入数据的数组
            byte[] cache = new byte[1024];
            //记录已经到达串口COM13且未被读取的数据的字节（Byte）数。
            int availableBytes = 0;

            //无限循环，每隔20毫秒对串口COM13进行一次扫描，检查是否有数据到达
            while(true){
            	//读入命令
            	inputStream.read(order1);
                //获取串口COM13收到的可用字节数
                availableBytes = inputStream.available();
                System.out.println("availableBytes=start="+availableBytes);
                if(availableBytes == 0){
                	System.out.println("线程阻滞，扫描就绪");
                	Thread.sleep(1000*3);
                }else{                	
                	//如果可用字节数大于零则开始循环并获取数据
                	while(availableBytes > 0){
                		//从串口的输入流对象中读入数据并将数据存放到缓存数组中
                		inputStream.read(cache);
                		//将获取到的数据进行转码并输出
                		for(int j = 0;j < cache.length && j < availableBytes; j++){
                			//因为COM13口发送的是使用byte数组表示的字符串，
                			//所以在此将接收到的每个字节的数据都强制装换为char对象即可，
                			System.out.print((char)cache[j]);
                		}
                		String str =new String(cache, "UTF-8");
                		URL =URLDecoder.decode(str,"UTF-8");
                		billKey =Tools.subString(URL, "&billKey=", "&instId=");
                		System.out.println("billKey=="+billKey);
                		//更新循环条件
                		availableBytes = inputStream.available();
                		System.out.println("availableBytes=end="+availableBytes);
                		System.out.println("存入billKey");
                		serialCOM13.close();
                		return billKey;
                	}
                	//让线程睡眠20毫秒
                	Thread.sleep(20);
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch (NoSuchPortException e) {
        	System.out.println("Port===========");
            //找不到串口的情况下抛出该异常
            e.printStackTrace();
        } catch (PortInUseException e) {
            //如果因为端口被占用而导致打开失败，则抛出该异常
            e.printStackTrace();
        } catch (IOException e) {
            //如果获取输出流失败，则抛出该异常
            e.printStackTrace();
        }
//		Thread.interrupted();
		System.out.println("唤醒线程");
		return billKey;
	}
	

	
	
	
}
