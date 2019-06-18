package AmbroseRen.method;

public class desc {
	public static void main(String[] args) {
		int arr[]=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		System.out.println();
		for(int i=0;i<arr.length-1;i++){//-1;遍历
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]<arr[j+1]){
					int t=arr[j];arr[j]=arr[j+1];arr[j+1]=t;
//					System.out.println(arr[j]);
				}
			}
		}
		for(int i=0;i<arr.length;i++){//依次输出
			System.out.println(arr[i]);
		}
	
	}
	
}
