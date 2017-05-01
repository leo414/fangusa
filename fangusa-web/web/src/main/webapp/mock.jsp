<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>index</title>
<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
</head>
<style>
.panel-success a {
	color: #3c763d
}
</style>
<%
String localip = "", hostname = "";
try {
	localip = java.net.InetAddress.getLocalHost().getHostAddress();
	hostname = java.net.InetAddress.getLocalHost().getHostName();
} catch (Exception e) {
	e.printStackTrace();
}
%>
<body>
	<div class="container" style="padding-top: 15px;">
		<div class="col-md-6">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h4 class="text-success">HOSTNAME:  <%=hostname%></h4>
					<h4 class="text-success">IP:  <%=localip%></h4>
				</div>
				<div class="panel-body">
                    <p>
                        <a href="test/mock_administrator" target="_blank">管理员请求测试</a>
                    </p>
					<p>
						<a href="test/send_to_mq" target="_blank">消息队列测试</a>
					</p>
					<p>
						<a href="mock/addPermission?orgCode=A13423&positionCode=300" target="_blank">审核岗位</a>
						<form id="renForm">
							岗位：<select name="positionCode">
								<option value="TODO">管理员</option>
							</select>
							组织：<input type="text" name="orgCode" value="A13423"/>
							公司：<select name="branchCompany">
								<option value="N00001">南京</option>
								<option value="A10001">北京</option>
							</select>
							城市：<select name="officeAddress">
								<option value="320100">南京</option>
								<option value="110000">北京</option>
							</select>
							<input type="button" value="设置人员" id="submit"/>
						</form>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	$("#submit").on("click", function(){
      	$.ajax({
        	url : "mock/addPermission",
        	type : "POST",
        	data : $("#renForm").serialize(),
        	success : function(){
          		alert("已获得对应权限");
        	}
      	})
    })
</script>