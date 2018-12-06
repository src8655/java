<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="width:400px;margin:0 auto;margin-top:30px;margin-bottom:10px;font-size:35px;font-weight:bold;overflow:hidden;text-align:center;border-top:1px solid #cccccc;border-bottom:1px solid #cccccc;padding:20px 0 20px 0;">
	<spring:message code="board.title" />
</h1>
<div style="overflow:hidden;text-align:center;">
	<a href="${querystring}&lang=kr" class="btn_st" style="display:inline-block;float:normal;margin:5px;">한국어</a>
	<a href="${querystring}&lang=en" class="btn_st" style="display:inline-block;float:normal;margin:5px;">English</a>
</div>