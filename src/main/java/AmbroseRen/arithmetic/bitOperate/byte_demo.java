package AmbroseRen.arithmetic.bitOperate;

/**  
*   byte指定位数赋值
*   
* 项目名称：AmbroseRen  
* 类名称：pac3  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月13日 下午3:59:54  
* @version       
*/ 
public class byte_demo {
	public static void main(String[] args) {
		byte bt1 =generateByte("2121");
		byte bt2 =(byte) ((byte)((int)10)<<4);
		System.out.println(bt1);
		System.out.println(bt2);
		
		byte[] sb ={2,3};
		 String str =getHexByte(sb,2,2).toString();
		 System.out.println(str);
	}
	
    public static  byte generateByte(String s) {
        byte tmp = 0;
        char[] arr = s.toCharArray();
        if(arr.length > 2){
            return tmp;
        }
        int t0 = Integer.parseInt(Character.toString(arr[0]), 16);
        int t1 = Integer.parseInt(Character.toString(arr[1]), 16);
        byte tmp0 = (byte)t0;
        byte tmp1 = (byte)t1;
        tmp = (byte) (tmp0 << 4);
        tmp = (byte) (tmp | tmp1);
        return tmp;
    }
    
    /**
     * 
     * @Title: getHexByte 
     * @Description: 将二进制码流变成可打印的string类型
     * @param b : 需要打印的码流
     * @param start: 打印的开始点
     * @param length:打印长度
     * @return
     * @return: StringBuilder
     */
    public static StringBuilder getHexByte(byte[] b,int start, int length){
        int t = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + length; i++) {

            if(i > 2 && b[i-1] == 'U' && b[i-2] == 'U'){
                break;
            }
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(" ").append(hex.toUpperCase());

            t++;
            if(t % 16 == 0){
                sb.append("\n");
            }
        }
        sb.append("\n");
        return sb;  
    }
    
}
