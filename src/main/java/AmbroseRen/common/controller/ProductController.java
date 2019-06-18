package AmbroseRen.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import AmbroseRen.common.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductServiceImpl productService;
	
	@RequestMapping("productTest")
	public String productTest(){
		System.out.println("==productTest==");
		return "product/productTest";
	}
}
