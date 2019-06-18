package AmbroseRen.util.MQres;

public enum EnumConstant {
	   
    FPZL_ZZFP("纸质发票", "1"),
    FPZL_DZFP("电子发票", "2"),
    FPLX_ZP("增值税专用发票", "0"),
    FPLX_PP("增值税普通发票", "2"),
    FPZF_ZP("正票", "1"),
    FPZF_HP("红票", "2"),
    GFLX_QY("企业", "01"),
    GFLX_JGSY("机关事业单位", "02"),
    GFLX_GR("个人", "03"),
    GFLX_QT("其它", "04"),
    KP_URL("http://192.168.0.112:8082/zzs_kpfw_ARM9/fpkj/91120000103069334G","1"),
//    QZ_URL("http://ei-test.51fapiao.cn:8080/fpqz/webservice/eInvWS?wsdl","11"),
    QZ_URL("http://qzfw.51fapiao.cn:20080/fpqz/webservice/eInvWS?wsdl","11"),
    QZ_FUN("eiInterface","23"),
    QZ_BMBB("18.2","24"),
    KP_CX_URL("http://192.169.0.40:8082/zzs_kpfw_ARM9/fpcyInterface","10"),
    INTERFACECODE_INVOICE("EI.FPKJ.U.EC.INTRA","invoice"),
    INTERFACECODE_EILNTERFACE("ECXML.FPQZ.BC.E.INV","eilnterface"),
    INTERFACECODE_EILNTERFACEEMAIL("ECXML.EMAILPHONEFPTS.TS.E.INV","eilnterface");
	private final String name;
    private final String type;
    /**已接收**/
    public static Integer FPZT_YJS=1;
    /**已开具**/
    public static Integer FPZT_YKJ=2;
    /**已签章**/
    public static Integer FPZT_YQZ=3;
    /**已推送**/
    public static Integer FPZT_YTS=4;
    /**已回调**/
    public static Integer FPZT_YHD=5;
    /**普通用户**/
    public static Integer USER_TYPE_PTYH=3;
    
    private EnumConstant(String name, String type) {  
        this.name = name;  
        this.type = type;  
    }  
    
    public String getName() {  
        return name;  
    }  
  
    public String getType() {  
        return type;  
    }  
  
    public static EnumConstant getOperationType(String name) {  
        return EnumConstant.valueOf(name);  
    } 
}
