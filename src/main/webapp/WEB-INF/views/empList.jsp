<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:actionmessage cssStyle="color:blue"/>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>爱好</th>
			<th>邮箱</th>
			<th>工资</th>
			<th>入职日期</th>
			<th>部门名称</th>
			<th>操作</th>
		</tr>
		<!--   s:iterator循环标签，value就是取值如果取栈顶的值直接写属性名，如果是map栈加上# -->
		<!-- s:iterator标签在循环取值，会自动把集合对象里面的迭代出来，并且显示一个(放入值栈里面)之后会自动删除 -->
		<!-- 如果在标签库里面使用了var属性，在后续标签里面要使用必须加上#,会把迭代的对象放到Map栈 -->
		<s:iterator value="emps" status="s">
			<s:if test="#s.odd">
				<tr>
			</s:if>
			<s:else>
				<tr bgcolor="gray">
			</s:else>
			<td>${id}</td>
			<td>${name}</td>
			<td>${password}</td>
			<td>${loves}</td>
			<td>${email}</td>
			<td>${salary}</td>
			<td>
			  <s:date name="hireDate" format="yyyy-MM-dd" var="hDate"/>
			  ${hDate}
			</td>
			<td>${dept.dname}</td>
			<td><s:a action="emp_input">
					<s:param name="emp.id" value="%{id}" /> 
			  编辑</s:a> <s:a action="emp_delete">
					<s:param name="emp.id" value="%{id}" /> 
			  删除</s:a></td>
			</tr>
		</s:iterator>
	</table>
	<s:a action="emp_input">添加</s:a>
	<!-- <hr/> -->
	<%-- <s:iterator value="emps" > --%>
	<!-- 	  <tr> -->
	<%-- 	    <td><s:property value="id"/></td> --%>
	<%-- 	    <td><s:property value="name"/></td> --%>
	<%-- 	    <td><s:property value="password"/></td> --%>
	<%-- 	    <td><s:property value="loves"/></td> --%>
	<%-- 	    <td><s:property value="email"/></td> --%>
	<%-- 	    <td><s:property value="salary"/></td> --%>
	<%-- 	    <td><s:property value="hireDate"/></td> --%>
	<%-- 	    <td><s:property value="dept.name"/></td> --%>
	<!-- 	  </tr> -->
	<%--   </s:iterator> --%>

	<!-- <hr/> -->
	<%-- <s:iterator value="emps" var="emp"> --%>
	<!-- 	  <tr> -->
	<%-- 	    <td><s:property value="#emp.id"/></td> --%>
	<%-- 	    <td><s:property value="#emp.name"/></td> --%>
	<%-- 	    <td><s:property value="#emp.password"/></td> --%>
	<%-- 	    <td><s:property value="#emp.loves"/></td> --%>
	<%-- 	    <td><s:property value="#emp.email"/></td> --%>
	<%-- 	    <td><s:property value="#emp.salary"/></td> --%>
	<%-- 	    <td><s:property value="#emp.hireDate"/></td> --%>
	<%-- 	    <td><s:property value="#emp.dept.name"/></td> --%>
	<!-- 	  </tr> -->
	<%--   </s:iterator> --%>

</body>
</html>