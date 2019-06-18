package AmbroseRen.method;

public class minNum {
	public static void main(String[] args) {
		int[]arr =new int[10];
		System.out.println("数组数据为：");
		for(int i=0;i<arr.length;i++){
			 arr[i]=(int)(Math.random()*1000);
			System.out.println(arr[i]);//拆，输出
		}
		int min=arr[0];								//假设
		for(int j=1;j<arr.length;j++){				//i和j的关系
			if(arr[j]<min){
				
				min=arr[j];
				System.out.println("最小值为："+min);
			}
			
		}
		
	}
	
}
