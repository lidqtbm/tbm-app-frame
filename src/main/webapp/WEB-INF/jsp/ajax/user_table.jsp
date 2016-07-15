<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered table-hover" id="baseTable">
    <thead>
    <tr>
        <th>${pd.INDEX}</th>
        <th hidden></th>
        <th hidden></th>
        <th hidden></th>
        <th hidden></th>
        <th>${pd.USER_LOGINAME}</th>
        <th>${pd.USER_EMAIL}</th>
        <th>${pd.USER_CREATE}</th>
        <th>${pd.USER_UPDATE}</th>
        <th>${pd.USER_DELETE}</th>
        <th>${pd.DELETE}</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty userlist}">
            <c:forEach items="${userlist}" var="userlist" varStatus="user">
                <tr class="">
                    <td>${user.index+1}</td>
                    <td hidden>${userlist.USER_ID}</td>
                    <td hidden>${userlist.CREATERIGHT}</td>
                    <td hidden>${userlist.UPDATERIGHT}</td>
                    <td hidden>${userlist.DELETERIGHT}</td>
                    <td>${userlist.USERNAME}</td>
                    <td>${userlist.EMAIL}</td>
                    <th>
                        <a href="javascript:void(0);" class="btn green icn-only" onclick="assignCreatBtn(this)"><i class="icon-user icon-white"></i></a>
                    </th>
                    <th>
                        <a href="javascript:void(0);" class="btn green icn-only" onclick="assignUpdateBtn(this)"><i class="icon-user icon-white"></i></a>
                    </th>
                    <th>
                        <a href="javascript:void(0);" class="btn green icn-only" onclick="assignDeleteBtn(this)"><i class="icon-user icon-white"></i></a>
                    </th>
                    <td>
                        <a href="javascript:void(0);" class="btn red" onclick="userDeleBtn(this)" data-toggle="modal"><i class="icon-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
    </tbody>
</table>