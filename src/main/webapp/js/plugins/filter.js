 //单个过滤
 var reg=/<[^<>]+>/g;
 var reg1=/[ ]|[&nbsp;]/g;
 var reg2=/rdquo/g;
 var reg3=/ldquo/g;
//函数多次过滤
function removeHTMLTag(str) {
    str = str.replace(/<\/?[^>]*>/g, ''); //去除HTML tag
    str = str.replace(/[ | ]*\n/g, '\n'); //去除行尾空白
    str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
    str = str.replace(/ /ig, ''); //去掉 

    str = str.replace(/<[^<>]+>/g, ''); 
    str = str.replace(/[ ]|[&nbsp;]/g, ''); 
    str = str.replace(/rdquo/g, ''); 
    str = str.replace(/ldquo/g, '');
    return str;
}
//hash数组单个大量过滤
String.prototype.multiReplace = function(hash) {
var str = this,key;
for (key in hash) {
  if (Object.prototype.hasOwnProperty.call(hash, key)) {
 str = str.replace(new RegExp(key, 'g'), hash[key]);
  }
}
return str;
}
str = str.multiReplace({
'&(?!#?\\w+;)': '&amp;',
'"([^"]*)"': '“$1”',
'<': '&lt;',
'>': '&gt;',
'…': '&hellip;',
'“': '&ldquo;',
'”': '&rdquo;',
'‘': '&lsquo;',
'’': '&rsquo;',
'—': '&mdash;',
'–': '&ndash;'
});
//过滤特殊字符
function stripscript(s) {
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
        var rs = "";
    for (var i = 0; i < s.length; i++) {
        rs = rs + s.substr(i, 1).replace(pattern, '');
    }
    return rs;
}
