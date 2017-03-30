<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>
<sx:head />
<body>

<s:if test="hasActionMessages()">
    <div class="welcome">
        <s:actionmessage/>
    </div>
</s:if>

<p> <i> not escaped PROPERTY tag:</i> <s:property value="%{messageStore}"/> </p>

<p> <i>escaped PROPERTY tag:</i> <s:property value="%{messageStore}" escapeHtml="false"/></p>

</br>

<s:form action="hello">
    <s:textfield key="user.name" label="%{'escaped textfield tag'}" escapeHtml="false"/>
    <s:textfield key="user.age" label="%{'textfield tag'}" />
    <s:label key="user.name" label="%{'label tag'}"/>
    <s:label label="%{'hidden tag'}"/> <s:hidden name="hidden" value="%{user.name}" label="%{'hidden tag'}"/>
    <s:textarea label="textarea Tag" name="user.name" cols="5" rows="5" />
</s:form>

<s:bean name="org.apache.struts.helloworld.model.User" var="userBean">
    <s:param name="name" value="user.name"/>
    </s:bean>
<i> Bean property escaped: </i> <s:property value="#userBean.name"/> <br/>
<i> Bean property not escaped </i> : <s:property value="#userBean.nick" escapeHtml="false"/>

</br>
<sx:tabbedpanel id="tabContainer">
    <sx:div label="Escaped"> <s:property value="#userBean.name"/></sx:div >
    <sx:div label="Not escaped"> <s:property value="#userBean.name" escapeHtml="false"/></sx:div>
</sx:tabbedpanel>


<p><a href="<s:url action='index'/>">Home Page</a></p>
</body>

</html>
