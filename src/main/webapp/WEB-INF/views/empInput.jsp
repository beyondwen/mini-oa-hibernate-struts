<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<title>Insert title here</title>
</head>
<body>
<s:actionerror cssStyle="color:red"/>
	<!-- 对于回显数据：s:textfield name=提交的参数名称  value回显数据(从值栈获取)的名称,没有写value默认使用name获取值栈值 -->
	<s:form action="emp_save">
		<s:hidden name="emp.id" />
		<s:textfield name="emp.name" value="%{emp.name}" label="用户名" />
		<s:textfield name="emp.password" label="密码" />
		<!-- 	  s:checkboxlist属性list表示放入集合:栈顶,Map栈，自定义 -->
		<s:checkboxlist list="{'编程','看电影','黑5'}" name="emp.loves"
			value="%{emp.loves.split(', ')}" label="爱好" />
		<s:textfield name="emp.email" label="邮箱" />
		<s:textfield name="emp.salary" label="工资" />
		<s:date name="emp.hireDate" format="yyyy-MM-dd" var="hDate"/>
		<s:textfield name="emp.hireDate" value="%{hDate}" label="入职时间" onclick="WdatePicker({maxDate:new Date()})" cssClass="Wdate"/>
		<!-- 		s:select属性list表示放入集合:栈顶,Map栈，自定义 -->
		<!-- 		name="emp.dept.id"设置值：getEmp().getDept().setId(),回显值getEmp().getDept().getId() -->
		<!-- 		listKey="传递到后台的值emp.dept.id" listValue=""页面看到的，,都是写上集合里面对象的属性 -->
		<!-- 		 headerKey="" headerValue=""自动放到select标签顶部 -->
		<s:select list="#allDepts" name="emp.dept.did" listKey="did"
			listValue="dname" label="部门名称" headerKey="-1" headerValue="--请选择--" />
		<s:submit value="保存" />

	</s:form>
</body>
</html>