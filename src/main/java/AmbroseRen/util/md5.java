package AmbroseRen.util;

class md5{
    int A,B,C,D;//定义连接变量
    int d[];//保存输入文本的分组信息(每组512个bit)
    int numwords;//保存子分组数目(每个子分组32bit)

        //根据字符串构造md5对象
    md5 (String s,int password) {
      // 初始化连接变量
        A = password/1;
        B = password/3;
        C = password/5;
        D = password/7;
                byte in[] = new byte[s.length()];
                int i;
                for(i=0; i < s.length(); i++)
                {in[i] = (byte) (s.charAt(i) & 0xff);}//转换成十六进制数据
                mdinit(in);
                calc();
    }
        //根据byte输组构造md5对象
    md5 (byte in[],int password) {
      // 初始化连接变量
        A = password/1;
        B = password/3;
        C = password/5;
        D = password/7;
                mdinit(in);
        }
        //处理输入文本
    void mdinit (byte in[]) {
        int newlen, endblklen, pad, i;
        long datalenbits;

        datalenbits = in.length  * 8;//计算输入文本的bit长度
        endblklen = in.length % 64;//计算输入文本关于512bit取模后的字节数。
        if (endblklen < 56) {
            pad = 64 - endblklen;
        } else {
            pad = (64 - endblklen) + 64;
        }
        newlen = in.length + pad;//生成新的文本长度，该长度为512bit的整数倍。
        byte b[] = new byte[newlen];//创建新byte数组，长度为64的整数倍
        for(i=0; i < in.length; i++) {//把输入文本的byte数据导入新数组中
            b[i] = in[i];
        }
        //剩余位置减去64bit其余部分用1或0补充
        b[in.length] = (byte) 0x80;
        for (i = b.length + 1; i < (newlen - 8); i++) {
            b[i] = 0;
        }
        //最后64bit的位置用输入文本的原始长度填充
        for (i = 0; i < 8; i++) {
            b[newlen - 8 + i] = (byte) (datalenbits & 0xff);
            datalenbits >>= 8;
        }

        this.numwords = newlen/4;//计算子分组数（每个子分组32bit）
        this.d = new int[this.numwords];//创建子分组数组
        //生成子分组数组
        for (i = 0; i < newlen; i += 4) {
            this.d[i/4] = (b[i] & 0xff) + ((b[i+1] & 0xff) << 8) +
                ((b[i+2] & 0xff) << 16) + ((b[i+3] & 0xff) << 24);
        }
   }
        //返回MD5字符串
    public String toString() {
        String s;
        return(tohex(A) + tohex(B) + tohex(C) + tohex(D));
    }
        //返回MD5的连接变量值
    int[] getregs() {
        int regs[] = {this.A, this.B, this.C, this.D};
        return regs;
    }
        //计算MD5
    void calc() {
        int AA=0, BB=0, CC=0, DD=0, i;

        for(i=0; i < numwords/16; i++) {//主循环，每次处理一个512bit的分组信息
            AA = A; BB = B; CC = C; DD = D;
            round1(i);
            round2(i);
            round3(i);
                round4(i);
            }
            A += AA; B+= BB; C+= CC; D+= DD;
        }

    /* Dummy round*() methods. these are overriden in the md4 and md5
     * subclasses
     */
        //md5的一级处理函数
    static int F(int x, int y, int z) {
        return((x & y) | (~x & z));
    }
        //md5的二级处理函数
    static int G(int x, int y, int z) {
        return((x & z) | (y & ~z));
    }
        //md5的三级处理函数
    static int H(int x, int y, int z) {
        return(x ^ y ^ z);
    }
        //md5的四级处理函数
    static int I(int x, int y, int z) {
        return(y ^ (x | ~z));
    }
        //md5的一级处理
    void round1(int blk) {
        A = rotintlft(A + F(B, C, D) + d[0 + 16 * blk] +
                      0xd76aa478, 7) + B;
        D = rotintlft(D + F(A, B, C) + d[1 + 16 * blk] +
                      0xe8c7b756, 12) + A;
        C = rotintlft(C + F(D, A, B) + d[2 + 16 * blk] +
                      0x242070db, 17) + D;
        B = rotintlft(B + F(C, D, A) + d[3 + 16 * blk] +
                      0xc1bdceee, 22) + C;

        A = rotintlft(A + F(B, C, D) + d[4 + 16 * blk] +
                      0xf57c0faf, 7) + B;
        D = rotintlft(D + F(A, B, C) + d[5 + 16 * blk] +
                      0x4787c62a, 12) + A;
        C = rotintlft(C + F(D, A, B) + d[6 + 16 * blk] +
                      0xa8304613, 17) + D;
        B = rotintlft(B + F(C, D, A) + d[7 + 16 * blk] +
                      0xfd469501, 22) + C;
        A = rotintlft(A + F(B, C, D) + d[8 + 16 * blk] +
                      0x698098d8, 7) + B;
        D = rotintlft(D + F(A, B, C) + d[9 + 16 * blk] +
                      0x8b44f7af, 12) + A;
        C = rotintlft(C + F(D, A, B) + d[10 + 16 * blk] +
                      0xffff5bb1, 17) + D;
        B = rotintlft(B + F(C, D, A) + d[11 + 16 * blk] +
                      0x895cd7be, 22) + C;
        A = rotintlft(A + F(B, C, D) + d[12 + 16 * blk] +
                      0x6b901122, 7) + B;
        D = rotintlft(D + F(A, B, C) + d[13 + 16 * blk] +
                      0xfd987193, 12) + A;
        C = rotintlft(C + F(D, A, B) + d[14 + 16 * blk] +
                      0xa679438e, 17) + D;
        B = rotintlft(B + F(C, D, A) + d[15 + 16 * blk] +
                      0x49b40821, 22) + C;
    }
        //md5的二级处理
    void round2(int blk) {
        A = rotintlft(A + G(B, C, D) + d[1 + 16 * blk] +
                      0xf61e2562, 5) + B;
        D = rotintlft(D + G(A, B, C) + d[6 + 16 * blk] +
                      0xc040b340, 9) + A;
        C = rotintlft(C + G(D, A, B) + d[11 + 16 * blk] +
                      0x265e5a51, 14) + D;
        B = rotintlft(B + G(C, D, A) + d[0 + 16 * blk] +
                      0xe9b6c7aa, 20) + C;
        A = rotintlft(A + G(B, C, D) + d[5 + 16 * blk] +
                      0xd62f105d, 5) + B;
        D = rotintlft(D + G(A, B, C) + d[10 + 16 * blk] +
                      0x02441453, 9) + A;
        C = rotintlft(C + G(D, A, B) + d[15 + 16 * blk] +
                      0xd8a1e681, 14) + D;
        B = rotintlft(B + G(C, D, A) + d[4 + 16 * blk] +
                      0xe7d3fbc8, 20) + C;
        A = rotintlft(A + G(B, C, D) + d[9 + 16 * blk] +
                      0x21e1cde6, 5) + B;
        D = rotintlft(D + G(A, B, C) + d[14 + 16 * blk] +
                      0xc33707d6, 9) + A;
        C = rotintlft(C + G(D, A, B) + d[3 + 16 * blk] +
                      0xf4d50d87, 14) + D;
        B = rotintlft(B + G(C, D, A) + d[8 + 16 * blk] +
                      0x455a14ed, 20) + C;
        A = rotintlft(A + G(B, C, D) + d[13 + 16 * blk] +
                      0xa9e3e905, 5) + B;
        D = rotintlft(D + G(A, B, C) + d[2 + 16 * blk] +
                      0xfcefa3f8, 9) + A;
        C = rotintlft(C + G(D, A, B) + d[7 + 16 * blk] +
                      0x676f02d9, 14) + D;
        B = rotintlft(B + G(C, D, A) + d[12 + 16 * blk] +
                      0x8d2a4c8a, 20) + C;
    }
        //md5的三级处理
    void round3(int blk) {
        A = rotintlft(A + H(B, C, D) + d[5 + 16 * blk] +
                      0xfffa3942, 4) + B;
        D = rotintlft(D + H(A, B, C) + d[8 + 16 * blk] +
                      0x8771f681, 11) + A;
        C = rotintlft(C + H(D, A, B) + d[11 + 16 * blk] +
                      0x6d9d6122, 16) + D;
        B = rotintlft(B + H(C, D, A) + d[14 + 16 * blk] +
                      0xfde5380c, 23) + C;
        A = rotintlft(A + H(B, C, D) + d[1 + 16 * blk] +
                      0xa4beea44, 4) + B;
        D = rotintlft(D + H(A, B, C) + d[4 + 16 * blk] +
                      0x4bdecfa9, 11) + A;
        C = rotintlft(C + H(D, A, B) + d[7 + 16 * blk] +
                      0xf6bb4b60, 16) + D;
        B = rotintlft(B + H(C, D, A) + d[10 + 16 * blk] +
                      0xbebfbc70, 23) + C;
        A = rotintlft(A + H(B, C, D) + d[13 + 16 * blk] +
                      0x289b7ec6, 4) + B;
        D = rotintlft(D + H(A, B, C) + d[0 + 16 * blk] +
                      0xeaa127fa, 11) + A;
        C = rotintlft(C + H(D, A, B) + d[3 + 16 * blk] +
                      0xd4ef3085, 16) + D;
        B = rotintlft(B + H(C, D, A) + d[6 + 16 * blk] +
                      0x04881d05, 23) + C;
        A = rotintlft(A + H(B, C, D) + d[9 + 16 * blk] +
                      0xd9d4d039, 4) + B;
        D = rotintlft(D + H(A, B, C) + d[12 + 16 * blk] +
                      0xe6db99e5, 11) + A;
        C = rotintlft(C + H(D, A, B) + d[15 + 16 * blk] +
                      0x1fa27cf8, 16) + D;
        B = rotintlft(B + H(C, D, A) + d[2 + 16 * blk] +
                      0xc4ac5665, 23) + C;
    }
        //md5的四级处理
    void round4(int blk) {
        A = rotintlft(A + I(B, C, D) + d[0 + 16 * blk] +
                      0xf4292244, 6) + B;
        D = rotintlft(D + I(A, B, C) + d[7 + 16 * blk] +
                      0x432aff97, 10) + A;
        C = rotintlft(C + I(D, A, B) + d[14 + 16 * blk] +
                      0xab9423a7, 15) + D;
        B = rotintlft(B + I(C, D, A) + d[5 + 16 * blk] +
                      0xfc93a039, 21) + C;
        A = rotintlft(A + I(B, C, D) + d[12 + 16 * blk] +
                      0x655b59c3, 6) + B;
        D = rotintlft(D + I(A, B, C) + d[3 + 16 * blk] +
                      0x8f0ccc92, 10) + A;
        C = rotintlft(C + I(D, A, B) + d[10 + 16 * blk] +
                      0xffeff47d, 15) + D;
        B = rotintlft(B + I(C, D, A) + d[1 + 16 * blk] +
                      0x85845dd1, 21) + C;
        A = rotintlft(A + I(B, C, D) + d[8 + 16 * blk] +
                      0x6fa87e4f, 6) + B;
        D = rotintlft(D + I(A, B, C) + d[15 + 16 * blk] +
                      0xfe2ce6e0, 10) + A;
        C = rotintlft(C + I(D, A, B) + d[6 + 16 * blk] +
                      0xa3014314, 15) + D;
        B = rotintlft(B + I(C, D, A) + d[13 + 16 * blk] +
                      0x4e0811a1, 21) + C;
        A = rotintlft(A + I(B, C, D) + d[4 + 16 * blk] +
                      0xf7537e82, 6) + B;
        D = rotintlft(D + I(A, B, C) + d[11 + 16 * blk] +
                      0xbd3af235, 10) + A;
        C = rotintlft(C + I(D, A, B) + d[2 + 16 * blk] +
                      0x2ad7d2bb, 15) + D;
        B = rotintlft(B + I(C, D, A) + d[9 + 16 * blk] +
                      0xeb86d391, 21) + C;
    }
        /////////////
        //移位函数
    static int rotintlft(int val, int numbits) {
        return((val << numbits) | (val >>> (32 - numbits)));
    }
        //整数转换为十六进制字符串
    static String tohex(int i) {
        int b;
        String tmpstr;
        tmpstr = "";
        for(b = 0; b < 4; b++) {
            tmpstr += Integer.toString((i >> 4) & 0xf, 16)
                + Integer.toString(i & 0xf, 16);
            i >>= 8;
        }
        return tmpstr;
    }
    public static void main(String[] args) {
      md5 m1=new md5("ok123213",8769);
      System.out.println(m1);
  }
}

