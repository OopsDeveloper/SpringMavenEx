<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            에러, 예외 페이지
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-edit"></i> common_error</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

        <h3><i class="fa fa-warning text-red"></i> ${exception.getMessage()}</h3>
        <ul>
            <c:forEach items="${exception.getStackTrace()}" var="stack">
                <li>${stack.toString()}</li>
            </c:forEach>
        </ul>

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
