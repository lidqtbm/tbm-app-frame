<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div id="baseTable">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>${pd.INDEX}</th>
            <th>${pd.ROLE_NAME}</th>
            <th>${pd.DELETE}</th>
            <th>${pd.ROLE_UPDATE}</th>
            <th hidden></th>
            <th hidden></th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty rolesList}">
                <c:forEach items="${rolesList}" var="rolesList" varStatus="role">
                    <tr>
                        <td>${role.index+1}</td>
                        <td>${rolesList.ROLE_NAME}</td>
                        <td hidden>${rolesList.RIGHTS}</td>
                        <td hidden>${rolesList.ROLE_ID}</td>
                        <td>
                            <a href = "javascript:void(0);" class="btn red icn-only" onclick="deleteBtn(this)"><i class="icon-remove icon-white"></i></a>
                        </td>
                        <td>
                            <a href="javascript:void(0);" class="btn green icn-only" onclick="assignBtn(this)"><i class="icon-user icon-white"></i></a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
        </tbody>
    </table>
</div>
