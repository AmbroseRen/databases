package AmbroseRen.method;

import java.util.Scanner;

/**
 * 验证码方法类
*   
* 项目名称：AmbroseRen  
* 类名称：validCode  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月10日 下午2:08:11  
* @version
 */
public class validCode {

	public static void main(String[] args) {
		Scanner src = new Scanner(System.in); 			
		char[] chs= genarate();
		System.out.println(chs);
		
		int count =0;
		while(true){
			System.out.println("请输入5个字符");
			String str =src.next().toUpperCase();//
			
			if(src.equals("EXIT")){//输入字符串
				System.out.println("欢迎再来");
				break;
			}
			
			char[] input =str.toCharArray();//拆成字符							
			int[] result=check(chs,input);
			
			
			if(result[0]==chs.length){//位置对5个
				int score =chs.length*100-count*20;
				System.out.println("滚吧");
				break;
				
			}else{
				count++;
				System.out.println("对了"+result[1]+"字符,对了"+result[0]+"位置");
				
			}
			
		}
		
		//		int[] result =check(chs,input);
	}
	
	
	public static char[] genarate(){//生成字符数组
		char[] chs =new char[5];
		char[] letters ={'A','B','C','D','E','F','G','H',
				'I','J','K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z',};
		boolean[] flag =new boolean[letters.length];
		for(int i=0;i<chs.length;i++){
			int index;
			do{
				index=(int)(Math.random()*26);
			}while(flag[index]==true);
			
			chs[i]=letters[index];
			flag[index]=true;
		}
		return chs;	
	}

	public static int[] check(char[] chs,char[] input){//对比字符数组
		int[] result =new int[2];		//对比结果假设
		for(int i=0;i<chs.length;i++){			
			for(int j=0;j<input.length;j++){
				if(chs[i]==input[j]){
					result[1]++;
					if(i==j){
						result[0]++;
					}
					break;
				}
			}
			
		}
		return result;					
	}
	
}
