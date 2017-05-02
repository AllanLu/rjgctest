<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
#textarea {
	position: absolute;
	width: 356px;
	height: 22px;
	left: 667px;
	top: 235px;
}
#button {
	position: absolute;
	left: 1029px;
	top: 233px;
	width: 57px;
	height: 26px;
	background-color: #D6D6D6;
}
#nav {
	line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;
}
#form1 {
	position: absolute;
	left: 967px;
	top: 576px;
	height: 46px;
	background-color: #FFFFFF;
	width: 464px;
	visibility: inherit;
}
body,td,th {
	color: #630;
	font-family: monospace;
	font-weight: bold;
}
.首页 {
	position: absolute;
	background-color: #CCCCCC;
	width: 79px;
	height: 27px;
	top: 632px;
	left: 777px;
}
</style>
</head>

<body>
<h1><img src="1.jpg" width="174" height="161" /><strong>购物车     </strong>
  <input type="submit" name="button" id="button" value="搜索" />
  <input name="textarea" type="text" id="textarea" value="" size="45" />
</h1>
<p>
  <label for="textarea"></label>
</p>

<p><strong> 全部商品
</strong></p>
<hr />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="2.png" width="313" height="290" /></p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>您的购物车还是空的，赶紧购物吧~
  </strong> &nbsp;&nbsp;&nbsp;
  <input name="button3" type="submit" class="首页" id="button3" value="返回首页" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;</p>
</body>
</html>