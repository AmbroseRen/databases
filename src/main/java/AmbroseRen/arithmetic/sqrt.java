package AmbroseRen.arithmetic;

public class sqrt {
	public static void main(String[] args) {
		double m,n;
		for(int i=0;i<100000;i++){
			 m=Math.sqrt(i+100);
			n=(Math.sqrt(i+100+168));
			if(m%1==0&&n%1==0){
				System.out.println(i);
			}
		}
		
	}
	
}
