package AmbroseRen.network.http;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import AmbroseRen.web.Json;

import net.sf.json.JSONObject;

public class HttpRequestUtils {
 
	
	private static HttpClient  httpClient=null;
	private static HttpPost httppost=null;
	private static   HttpGet httpget=null;
	private static final String token="1D20DCDEF9FA0BFB71848ABCFFB82CFB";
    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     * @throws Exception 
     */
    public static JSONObject httpPost(String url,JSONObject jsonparams) throws Exception{
        return httpPost(url, jsonparams, false);
    }
 
    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
    public static JSONObject httpPost(String url,JSONObject jsonparams , boolean noNeedResponse) throws Exception{
        //post请求返回结果
    	Json j=new Json();
    	httpClient = new DefaultHttpClient();
        JSONObject jsonResult = null;
        httppost= new HttpPost(url);
    	List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
    	nvps.add(new BasicNameValuePair("pztoken", token));
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
            String str = "";
            try {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity());
                if (noNeedResponse) {
                    return null;
                }
            	jsonResult = JSONObject.fromObject(str);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }else{
         	jsonResult = JSONObject.fromObject(j);
        }
        return jsonResult;
    }
    
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
        	httpClient= new DefaultHttpClient();
            //发送get请求
        	httpget= new HttpGet(url);
            HttpResponse response = httpClient.execute(httpget);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                System.out.println("请求失败------");
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return jsonResult;
    }
    public static void closeHttp(){
    	if(httppost!=null){
    		httppost.releaseConnection();
    	}
    	if(httpget!=null){
    		httpget.releaseConnection();
    	}
    }
    public static String sendPost(String url, String data) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,ContentType.create("text/xml", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils.toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
     }
    public static void main(String[] args) {
    	Map<String,String> map=new HashMap<String,String>();
    	map.put("decodstr", "59FD4179DC10686FEDE4C2357A2B701F7FC4C33640435A973EAEBB4DE2775420D0155B6F9482B3F9F54DB5EAACADC7D000C8F7CC3A20B72DA5549CC90A7C1066");
    	String ee = map.get("decodstr");
    	JSONObject result=HttpRequestUtils.httpGet("http://192.168.0.2:8080/fwgl/HomeCotroller/loginPage?pztoken="+ee);
    	System.out.println(result);
    }
}
