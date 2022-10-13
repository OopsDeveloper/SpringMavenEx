<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            게시판
            <small>목록페이지</small>
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-edit"></i> article</li>
            <li class="active"><a href="${path}/article/paging/list"> list</a></li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content container-fluid">
        <div class="col-lg-12">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">게시글 목록</h3>
                </div>
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th style="width: 30px">#</th>
                            <th>제목</th>
                            <th style="width: 100px">작성자</th>
                            <th style="width: 150px">작성시간</th>
                            <th style="width: 60px">조회</th>
                        </tr>
                        <c:forEach items="${articles}" var="article">
                            <tr>
                                <td>${article.articleNo}</td>
                                <td><a href="${path}/article/paging/read?articleNo=${article.articleNo}&page=${pageMaker.criteria.page}&perPageNum=${pageMaker.criteria.perPageNum}">${article.title}</a></td>
                                <td>${article.writer}</td>
                                <td><fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a HH:mm"/></td>
                                <td><span class="badge bg-red">${article.viewCnt}</span></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="box-footer">
                    <div class="text-center">
                        <form id="listPageForm">
                            <input type="hidden" name="page" value="${pageMaker.criteria.page}">
                            <input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
                        </form>
                        <ul class="pagination">
                            <c:if test="${pageMaker.prev}">
                                <%--<li><a href="${path}/article/listPaging?page=${pageMaker.startPage - 1}">이전</a></li>--%>
                                <%--<li><a href="${path}/article/listPaging${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>--%>
                                <li><a href="${pageMaker.startPage - 1}">이전</a></li>
                            </c:if>
                            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                                <li <c:out value="${pageMaker.criteria.page == idx ? 'class=active' : ''}"/>>
                                        <%--<a href="${path}/article/listPaging?page=${idx}">${idx}</a>--%>
                                        <%--<a href="${path}/article/listPaging${pageMaker.makeQuery(idx)}">${idx}</a>--%>
                                    <a href="${idx}">${idx}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                <%--<li><a href="${path}/article/listPaging?page=${pageMaker.endPage + 1}">다음</a></li>--%>
                                <%--<li><a href="${path}/article/listPaging?${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>--%>
                                <li><a href="${pageMaker.endPage + 1}">다음</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
                <div class="box-footer">
                    <div class="pull-right">
                        <button type="button" class="btn btn-success btn-flat" id="writeBtn">
                            <i class="fa fa-pencil"></i> 글쓰기
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script>
    var result = "${msg}";

    checkModal(result);

    // 파라미터: 데이터,타이틀값,새로운 히스토리 엔트리의 URL 값
    history.replaceState({}, null, null);

    function checkModal(result) {
        if (result === '' || history.state) {
            return;
        }
        if (result == "regSuccess") {
            alert("게시글 등록이 완료되었습니다.");
        } else if (result == "modSuccess") {
            alert("게시글 수정이 완료되었습니다.");
        } else if (result == "delSuccess") {
            alert("게시글 삭제가 완료되었습니다.");
        }
    }

    $(".pagination li a").on("click", function (event) {
        event.preventDefault();

        var targetPage = $(this).attr("href");
        var listPageForm = $("#listPageForm");
        listPageForm.find("[name='page']").val(targetPage);
        listPageForm.attr("action","/article/paging/list").attr("method","get");
        listPageForm.submit();
    });


</script>
