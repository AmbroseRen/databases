package AmbroseRen.network.http;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import AmbroseRen.web.Json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpRequest {
	public static void main(String[] args) {
		JSONObject jbject=new JSONObject();
		jbject.put("aisino_id", "1271101");
		JSONObject resJson = httpPost("http://192.168.0.67:8080/AOS/product/Aisino_id2Cbs_inv_aisino", jbject);
		List<String> list =new ArrayList<String>();
		if(resJson.getBoolean("success")){
			JSONArray res=(JSONArray) resJson.get("company_cde");
//			list=JSONArray.toList(res, Djxx.class);
			System.out.println(res.toArray());
		}
	}
	
	public static JSONObject httpPost(String url,JSONObject jsonparams){
        return httpPost(url, jsonparams, false);
    }
	
	 @SuppressWarnings("unchecked")
	 public static JSONObject httpPost(String url,JSONObject jsonparams , boolean noNeedResponse){
		  //post请求返回结果
	    	Json j=new Json();
	    	HttpClient httpClient = new DefaultHttpClient();
	        JSONObject jsonResult = null;
	        HttpPost  httppost= new HttpPost(url);
	        try {
	        	List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
				Iterator<String> sIterator = jsonparams.keys();  
	        	while(sIterator.hasNext()){  
	        	    // 获得key  
	        	    String key = sIterator.next();  
	        	    // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可  
	        	    String value = jsonparams.getString(key);  
	        	    if(!("null").equals(value)){
	        	    	 nvps.add(new BasicNameValuePair(key, value));
	        	    }
	        	}  
	        	httppost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
	            HttpResponse result = httpClient.execute(httppost);
	            url = URLDecoder.decode(url, "UTF-8");
	            /**请求发送成功，并得到响应**/
	            if (result.getStatusLine().getStatusCode() == 200) {
	                String str = "{}";
	                try {
	                    /**读取服务器返回过来的json字符串数据**/
	                    str = EntityUtils.toString(result.getEntity());
	                    if (noNeedResponse) {
	                        return null;
	                    }
	                    /**把json字符串转换成json对象**/
	                    if(!StringUtils.isBlank(str)){
	                    	j.setObj(str);
	            			j.setMsg("请求成功");
	            			j.setSuccess(true);
	                    	jsonResult = JSONObject.fromObject(j);
	                    }
	                } catch (Exception e) {
	                	e.printStackTrace();
	                }
	            }else{
	             	j.setObj(result.getStatusLine().getStatusCode());
	     			j.setMsg("请求失败");
	     			j.setSuccess(false);
	             	jsonResult = JSONObject.fromObject(j);
	            }
	        } catch (IOException e) {
				j.setMsg(e.getMessage());
				j.setSuccess(false);
	        	jsonResult = JSONObject.fromObject(j);
	        	e.printStackTrace();
	        }
	        return jsonResult;
	}

}
