package AmbroseRen.method;

public class asc3 {
	public static void main(String[] args) {
		int count=0,result=0;
		
		int[] chs={1,2,3,4,};
		for(int i=1;i<=chs.length;i++){			
			for(int j=1;j<=chs.length;j++){				
				for(int k=1;k<=chs.length;k++){
					if(i==j||j==k||k==i){
						continue;
					}					
					result=100*i+10*j+1*k;		
					count++;
					System.out.println(result);
					
				}
			}
		}
		System.out.println(count);

	}
	
}
