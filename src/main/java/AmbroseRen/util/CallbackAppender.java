package AmbroseRen.util;

import java.lang.reflect.Method;  

import org.apache.log4j.AppenderSkeleton;  
import org.apache.log4j.spi.LoggingEvent;  
  
/** 
 *  
 * 这个Appender的作用，是使log输出重定向到某个函数里去 
 * @author lijun 
 * 
 */  
public class CallbackAppender extends AppenderSkeleton {  
    Method m_ian;  
      
    @Override  
    protected void append(LoggingEvent event) {  
        try {  
            String msg =  this.getLayout().format(event);  
            	System.out.println("msg="+msg);
            //调用方法重定向log输出.begin  
            if( m_ian!=null )  
            {  
                Object[] args = {msg};  
                m_ian.invoke(null, args);  
            }  
            //调用方法重定向log输出.end  
        } catch (Exception ie) {  
            ie.printStackTrace();  
        }  
    }     
      
    @Override  
    public void close() {  
        if (closed)  
            return;  
          
        //Close动作  
  
        //Close标记  
        closed = true;  
    }  
      
    @Override  
    public boolean requiresLayout() {  
        return true;  
    }  
      
    public void SetCallback(Method ian)  
    {  
        m_ian = ian;  
    }  
} 
