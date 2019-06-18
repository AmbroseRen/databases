package AmbroseRen.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AmbroseRen.system.dao.SystemDao;
import AmbroseRen.system.service.SystemService;

@Service("systemService")
public class SystemServiceImpl implements SystemService{
	
	@Autowired
	private SystemDao systemDao;
	
	
}
