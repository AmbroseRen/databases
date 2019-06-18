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
import net.sf.json.JSONObject;

public class HttpUtil {
	
	private static HttpClient  httpClient=null;
	private static HttpPost httppost=null;
	
	 public static Json httpPost(String url,JSONObject jsonparams){
	        return httpPost(url, jsonparams, false);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public static Json httpPost(String url,JSONObject jsonparams , boolean noNeedResponse){
	        //post请求返回结果
	    	Json j=new Json();
	    	httpClient = new DefaultHttpClient();
	        httppost= new HttpPost(url);
	        try {
	        	List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
				Iterator<String> sIterator = jsonparams.keys();  
	        	while(sIterator.hasNext()){  
	        	    // 获得key  
	        	    String key = sIterator.next();  
	        	    // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可  
	        	    String value = jsonparams.getString(key);  
	        	    nvps.add(new BasicNameValuePair(key, value));
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
	                    	j.setResult(str);
	            			j.setMsg("请求成功");
	            			j.setSuccess(true);
	                    }
	                } catch (Exception e) {
	                	e.printStackTrace();
	                }
	            }else{
	             	j.setResult(result.getStatusLine().getStatusCode());
	     			j.setMsg("请求失败");
	     			j.setSuccess(false);
	            }
	        } catch (IOException e) {
				j.setMsg(e.getMessage());
				j.setSuccess(false);
	        	e.printStackTrace();
	        }
	        return j;
	    }
	

}
