package AmbroseRen.system.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	/**
	 * 将Java对象转换为json字符串
	 */
	public static void test1() throws JsonProcessingException {
		Stock s =new Stock();
		s.setCode("60078");
		s.setName("中国嘉陵");
		s.setPrice(9);
		//使用jackson提供的api
		ObjectMapper om =new ObjectMapper();
		String jsonStr  =om.writeValueAsString(s);
		System.out.println(jsonStr);
	}
	public static void test2() throws JsonProcessingException {
		List<Stock> stocks =new ArrayList<Stock>();
		Random r =new Random();
		for(int i=0;i<3;i++){
			Stock s =new Stock();
			s.setCode("60078"+r.nextInt(10));
			s.setName("中国嘉陵"+r.nextInt(10));
			s.setPrice(r.nextInt(10));
			stocks.add(s);
		}
		ObjectMapper om =new ObjectMapper();
		String jsonStr =om.writeValueAsString(stocks);
		System.out.println(jsonStr);
	}
	public static void main(String[] args) throws JsonProcessingException {
		test1();
		System.out.println("---");
		test2();
	}
}
