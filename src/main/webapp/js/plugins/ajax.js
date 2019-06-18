function getXhr(){
		var xhr =null;
		if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();			
		}else{
			xhr = new ActiveXObject('MicroSoft.XmlHttp');
		}
		return xhr;
}
function f1(e){
	alert("Hello World"+e);
		
}
function $(id){
	return document.getElementById(id);
}
function $F(id){
	return $(id).value;
}