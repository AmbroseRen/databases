<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <c:set var="BasePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="bdsharebuttonbox fr clearfix">
		  <a href="#" class="bds_more" data-cmd="more"></a>
		  <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
		  <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
		  <a href="#" class="bds_douban" data-cmd="douban" title="分享到豆瓣网"></a>
		  <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
		  <a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
		  <a href="#" class="bds_huaban" data-cmd="huaban" title="分享到花瓣"></a>
		</div>
		<script>window._bd_share_config = {
		    "common": {
		      "bdSnsKey": {},
		      "bdText": "",
		      "bdMini": "2",
		      "bdMiniList": false,
		      "bdPic": "",
		      "bdStyle": "0",
		      "bdSize": "24"
		    },
		    "share": {},
		    "image": {
		      "viewList": ["tsina", "renren", "douban", "weixin", "sqq", "huaban"],
		      "viewText": "分享到：",
		      "viewSize": "16"
		    },
		    "selectShare": {
		      "bdContainerClass": null,
		      "bdSelectMiniList": ["tsina", "renren", "douban", "weixin", "sqq", "huaban"]
		    }
		  };
		  with(document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = '${BasePath }/static/share/js/share.js?v=89860593.js?cdnversion=' + ~ ( - new Date() / 36e5)];
		</script>
</body>
</html>