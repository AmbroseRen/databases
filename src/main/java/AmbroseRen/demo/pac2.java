package AmbroseRen.demo;

import AmbroseRen.kit.parse.PaserXml;
import AmbroseRen.kit.parse.XmlConfig;
import AmbroseRen.network.http.HttpUtil;
import AmbroseRen.util.AES;
import AmbroseRen.util.Base64Util;
import AmbroseRen.util.Tools;
import AmbroseRen.web.Json;
import net.sf.json.JSONObject;

public class pac2 {
	public static void main(String[] args) {
		
		try {
			String key="I7GBo4w9E6dmGlLVJMaVtXrhbNqp4KBh";
			String data=
		"<content>"+
			"<REQUEST_FPKJXX>"+
				"<FPKJXX_FPTXX>"+
					"<NSRSBH>91120000103069334G</NSRSBH>"+
					"<FJH>001002</FJH>"+
					"<NSRMC>天津自来水集团有限公司</NSRMC>"+
					"<XHF_DZ>华苑产业区华天道8号海泰信息广场D座10层</XHF_DZ>"+
					"<XHF_DH>022-95113</XHF_DH>"+
					"<XHF_YHZH>12001645900052512941</XHF_YHZH>"+
					"<GHFMC>王记公胜水甫</GHFMC>"+
					"<GHF_NSRSBH>12313112111111111111</GHF_NSRSBH>"+
					"<GHF_DZ>营口道122号</GHF_DZ>"+
					"<GHF_GDDH>18330471457</GHF_GDDH>"+
					"<GHF_YHZH>421123199309097657</GHF_YHZH>"+
					"<KPY>自来水</KPY>"+
					"<SKY>Boss</SKY>"+
					"<FHR>Boss</FHR>"+
					"<KPLX>1</KPLX>"+
					"<YFP_DM>012001700111</YFP_DM>"+
					"<YFP_HM>85017666</YFP_HM>"+
					"<KPHJJE>94.72</KPHJJE>"+
					"<HJBHSJE>94.72</HJBHSJE>"+
					"<HJSE>0</HJSE>"+
					"<BZ>100000020,100000020;</BZ>"+
					"<BB>￥</BB>"+
					"<WB>0</WB>"+
					"<FPZL>51</FPZL>"+
					"<KPRQ>2018-10-31 16:12:28</KPRQ>"+
					"<FP_DM>012001700111</FP_DM>"+
					"<FP_HM>85017666</FP_HM>"+
					"<FPMW>7/59/527*2+997084+>/17124</FPMW>"+
					"<JYM>49752 19126 28051 43025</JYM>"+
					"<EWM>20170517103931-070411000669-0</EWM>"+
					"<JQBH>661619973461</JQBH>"+
					"<PDF>070411000339</PDF>"+				
				"</FPKJXX_FPTXX>"+
				"<FPKJXX_XMXXS>"+
					"<FPKJXX_XMXX>"+
						"<XMMC>billcab</XMMC>"+
						"<XMDW>天津自来水集团有限公司</XMDW>"+
						"<GGXH>1.0</GGXH>"+
						"<XMSL>2</XMSL>"+
						"<HSBZ>0</HSBZ>"+
						"<XMDJ>2.56</XMDJ>"+
						"<FPHXZ>0</FPHXZ>"+
						"<SPBM>001001001</SPBM>"+
						"<SPBMJC>001</SPBMJC>"+
						"<YHZCBS>0</YHZCBS>"+
						"<LSLBS>2</LSLBS> "+
						"<ZZSTSGL>0</ZZSTSGL>"+
						"<XMJE>1000</XMJE>"+
						"<SL>0%</SL>"+
						"<SE>0</SE>"+
					"</FPKJXX_XMXX>"+
				"</FPKJXX_XMXXS>"+
				
			"</REQUEST_FPKJXX>"+
		"</content>";
			String xml ="<?xml version='1.0' encoding='utf-8'?>"+					
			"<interface>"+
				"<globalInfo>"+
					"<version>v5.0</version>"+
					"<interfaceCode>DZFP_FP_SUBMIT</interfaceCode>"+
					"<token>TJDCPT</token>"+
					 "<requestTime>20181031115009</requestTime>"+
				"</globalInfo>"+
				"<Data>"+
					data+
				"</Data>"+
			"</interface>";
//			XmlConfig all =PaserXml.Parse("bill.xml");
//			String content = all.getData().getContent().toString();
			String password = "WuMlCJRN8zO886dw";
//			byte[] encrypt = AES.encrypt(content, password);
//			String hexStrResult = Base64Util.getBase64(Tools.byte2HexString(encrypt));
//			System.out.println("==AES==");
//			content =all.getData().setContent(hexStrResult);
//			String RequestParam =Base64Util.getBase64(all.getData().getContent().toString());
//			String Signature =Tools.hamcsha(RequestParam.getBytes(), key.getBytes());
			System.out.println(xml);
			String RequestParam =Base64Util.getBase64(xml);
			byte[] encrypt = AES.encrypt(data,password);
			String Signature =Tools.hamcsha(Base64Util.getBase64(encrypt.toString()).getBytes(),key.getBytes());
//			String Signature =Tools.hamcsha(RequestParam.getBytes(),key.getBytes());
			System.out.println(RequestParam);
			System.out.println("=======");
			System.out.println(Signature);
			
//			System.out.println("http://test.51fapiaonb.cn:4011/DZFP_Hyf?RequestParam="+RequestParam+"&Signature="+Signature+"");
//			Tools.load("http://test2.51fapiaonb.cn:4011/DZFP_Hyf", 
//					"RequestParam="+RequestParam+"&Signature="+Signature+"");
			JSONObject jsonObject =new JSONObject();
			jsonObject.put("RequestParam", RequestParam);
			jsonObject.put("Signature", Signature);
			Json res_json=HttpUtil.httpPost("http://test2.51fapiaonb.cn:4011/DZFP_Hyf", jsonObject);
			System.out.println(res_json);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
}
