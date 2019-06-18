package AmbroseRen.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AmbroseRen.common.dao.ProductDao;
import AmbroseRen.common.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	
}
