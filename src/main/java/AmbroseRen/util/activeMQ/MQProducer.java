package AmbroseRen.util.activeMQ;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.alibaba.druid.support.json.JSONUtils;

import net.sf.json.JSONObject;

public class MQProducer {
    //默认连接地址
//    private static final String BROKEURL = "failover:(tcp://192.168.0.238:61616)";
	private static final String BROKEURL = "failover:(tcp://192.168.0.67:61616)";
    /** 默认用户名 */
    public static final String USERNAME = "admin";
    /** 默认密码 */
    public static final String PASSWORD = "admin";
    //发送的消息数量
    private static final int SENDNUM = 10;
    
    public static void sendMessage(String queue,String msg) {
    	 ConnectionFactory connectionFactory;
    	 Connection connection = null;
    	 final Session session;
         Destination destination;
         final MessageProducer messageProducer;
//         connectionFactory = new ActiveMQConnectionFactory("admin","aisino", JMSProducer.BROKEURL);
         connectionFactory = new ActiveMQConnectionFactory("admin","admin", MQProducer.BROKEURL);
         try {
        	 //通过连接工厂获取连接
             connection = connectionFactory.createConnection();
             //启动连接
             connection.start();
             //创建session
             session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
             //创建一个名称为HelloWorld的消息队列	或用Queue队列（一对一）
             destination = session.createQueue(queue);
             //一对多消息队列
//             Topic topic = session.createTopic(queue);
             //创建消息生产者
             messageProducer = session.createProducer(destination);
             //发送消息
    		 TextMessage message = session.createTextMessage(msg);
        	 messageProducer.send(message);	
        	 System.out.println("发送条消息："+msg);
             session.commit();
             //关闭流资源
             messageProducer.close();
             session.close();
             connection.close();
         }catch(Exception e) {
        	 e.printStackTrace();
         }finally {
        	 if(connection != null){
                 try {
                     connection.close();
                 } catch (JMSException e) {
                     e.printStackTrace();
                 }
        	 }
       }
    }
    public static void main(String[] args) {
    	/*Map<String,Integer> map =new HashMap<String,Integer>();
		map.put("语文", 97);
		map.put("数学", 96);
		map.put("英语", 75);
		map.put("物理", 78);
		map.put("化学", 65);
		String jsonString = JSONUtils.toJSONString(map);
		JSONObject json=JSONObject.fromObject(jsonString);
		String jxs=json.toString();
		sendMessage("fpqzQueue", jxs);*/
    	for (int i = 0; i < 2; i++) {
    		sendMessage("fptsQueue", "{\"ceshi\":\"测试fptsQueue消息发送"+i+"*440\"}");
//    		sendMessage("fptsQueue", "{\"ceshi\":测试fptsQueue消息"+i+"发送}");
		}
//		MQProducer.sendMessage(queue, msg);
	}
}
