<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<tiles:insertAttribute name="head"/>
<body class="hold-transition skin-blue sidebar-mini layout-boxed">

<div class="wrapper">

    <!-- Main Header -->
    <tiles:insertAttribute name="main_header"/>

    <!-- Left side column. contains the logo and sidebar -->
    <tiles:insertAttribute name="left_column"/>

    <tiles:insertAttribute name="body"/>

    <!-- Main Footer -->
    <tiles:insertAttribute name="main_footer"/>

</div>
<!-- ./wrapper -->

<tiles:insertAttribute name="plugin_js"/>

</body>
