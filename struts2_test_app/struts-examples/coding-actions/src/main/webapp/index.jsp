<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
</head>
<sx:head />

<body>
<h1>Welcome To Struts 2!</h1>


<s:form action="hello" method="GET">
    <s:textfield name="userName" label="%{'Your name'}"/>
    <s:textfield name="userAge" label="%{'Your age'}"/>
    <s:submit value="%{'GET with query string to data and UI form tags'}"/>
</s:form>

</br>
<s:form action="error" method="GET">
    <s:textfield name="errorMessage" label="%{'Error message'}"/>
    <s:submit value="%{'GET with query string to actionerror tag'}"/>
</s:form>

<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>

   <br/>
</body>

</html>
