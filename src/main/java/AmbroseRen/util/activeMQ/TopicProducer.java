package AmbroseRen.util.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicProducer {

	public static void TopicSendMessage(String TopicQueueName, String msg) throws Exception {
		Connection connection = null;
		try {
			// 1、创建工厂连接对象，需要制定ip和端口号
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin",
					"tcp://192.168.0.67:61616");
			// 2、使用连接工厂创建一个连接对象
			connection = connectionFactory.createConnection();
			// 3、开启连接
			connection.start();
			// 4、使用连接对象创建会话（session）对象
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
			Topic topic = session.createTopic(TopicQueueName);
			// 6、使用会话对象创建生产者对象
			MessageProducer producer = session.createProducer(topic);
			// 7、使用会话对象创建一个消息对象
			TextMessage textMessage = session.createTextMessage(msg);
			// 8、发送消息
			producer.send(textMessage);
			System.out.println("发送消息为：" + msg);
			session.commit();
			// 9、关闭资源
			producer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		TopicSendMessage("fptsQueue", "{\"A\",\"B\"}");
	}

}
