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
            <small>조회페이지</small>
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-edit"></i> article</li>
            <li class="active"><a href="${path}/article/paging/search/read"> read</a></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

        <div class="col-lg-12">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">글제목 : ${article.title}</h3>
                </div>
                <div class="box-body" style="height: 700px">
                    ${article.content}
                </div>
                <div class="box-footer">
                    <div class="user-block">
                        <img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg" alt="user image">
                        <span class="username">
                                <a href="#">${article.writer}</a>
                            </span>
                        <span class="description"><fmt:formatDate pattern="yyyy-MM-dd a HH:mm" value="${article.regDate}"/></span>
                    </div>
                </div>
                <div class="box-footer">
                    <form role="form" method="post">
                        <input type="hidden" name="articleNo" value="${article.articleNo}">
                        <input type="hidden" name="page" value="${searchCriteria.page}">
                        <input type="hidden" name="perPageNum" value="${searchCriteria.perPageNum}">
                        <input type="hidden" name="searchType" value="${searchCriteria.searchType}">
                        <input type="hidden" name="keyword" value="${searchCriteria.keyword}">
                    </form>
                    <button type="submit" class="btn btn-primary listBtn"><i class="fa fa-list"></i> 목록</button>
                    <div class="pull-right">
                        <button type="submit" class="btn btn-warning modBtn"><i class="fa fa-edit"></i> 수정</button>
                        <button type="submit" class="btn btn-danger delBtn"><i class="fa fa-trash"></i> 삭제</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="box box-warning">
            <div class="box-header with-border">
                <a class="link-black text-lg"><i class="fa fa-pencil margin-r-5"></i> 댓글 쓰기</a>
            </div>
            <div class="box-body">
                <form>
                    <div class="form-group">
                        <textarea class="form-control" id="newReplyText" rows="3" placeholder="댓글내용..."style="resize: none"></textarea>
                    </div>
                    <div class="col-sm-2" hidden>
                        <input class="form-control" id="newReplyWriter" type="text" value="${login.userId}" readonly>
                    </div>
                    <button type="button" class="btn btn-default btn-block replyAddBtn">
                        <i class="fa fa-save"></i> 댓글 저장
                    </button>
                </form>
                <%--
                <c:if test="${not empty login}">
                    <form>
                        <div class="form-group">
                            <textarea class="form-control" id="newReplyText" rows="3" placeholder="댓글내용..."style="resize: none"></textarea>
                        </div>
                        <div class="col-sm-2" hidden>
                            <input class="form-control" id="newReplyWriter" type="text" value="${login.userId}" readonly>
                        </div>
                        <button type="button" class="btn btn-default btn-block replyAddBtn">
                            <i class="fa fa-save"></i> 댓글 저장
                        </button>
                    </form>
                </c:if>
                <c:if test="${empty login}">
                    <a href="${path}/user/login" class="btn btn-default btn-block" role="button">
                        <i class="fa fa-edit"></i> 로그인 한 사용자만 댓글 등록이 가능합니다.
                    </a>
                </c:if>
                --%>
            </div>
        </div>

        <div class="box box-success collapsed-box">
            <%--댓글 유무 / 댓글 갯수 / 댓글 펼치기, 접기--%>
            <div class="box-header with-border">
                <a class="link-black text-lg"><i class="fa fa-comments-o margin-r-5 replyCount"></i> </a>
                <div class="box-tools">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>
            </div>
            <%--댓글 목록--%>
            <div class="box-body repliesDiv">

            </div>
            <%--댓글 페이징--%>
            <div class="box-footer">
                <div class="text-center">
                    <ul class="pagination pagination-sm no-margin">

                    </ul>
                </div>
            </div>
        </div>

        <%--댓글 수정 modal 영역--%>
        <div class="modal fade" id="modModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">댓글수정</h4>
                    </div>
                    <div class="modal-body" data-rno>
                        <input type="hidden" class="replyNo"/>
                        <%--<input type="text" id="replytext" class="form-control"/>--%>
                        <textarea class="form-control" id="replyText" rows="3" style="resize: none"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-primary modalModBtn">수정</button>
                    </div>
                </div>
            </div>
        </div>

        <%--댓글 삭제 modal 영역--%>
        <div class="modal fade" id="delModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">댓글 삭제</h4>
                        <input type="hidden" class="rno"/>
                    </div>
                    <div class="modal-body" data-rno>
                        <p>댓글을 삭제하시겠습니까?</p>
                        <input type="hidden" class="rno"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">아니요.
                        </button>
                        <button type="button" class="btn btn-primary modalDelBtn">네. 삭제합니다.</button>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script id="replyTemplate" type="text/x-handlebars-template">
    {{#each.}}
    <div class="post replyDiv" data-replyNo={{replyNo}}>
        <div class="user-block">
            <%--댓글 작성자 프로필사진--%>
            <img class="img-circle img-bordered-sm" src="/dist/img/user1-128x128.jpg" alt="user image">
            <%--댓글 작성자--%>
            <span class="username">
                <%--작성자 이름--%>
                <a href="#">{{replyWriter}}</a>
                <%--댓글 삭제 버튼--%>
                <a href="#" class="pull-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal">
                    <i class="fa fa-times"> 삭제</i>
                </a>
                <%--댓글 수정 버튼--%>
                <a href="#" class="pull-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal">
                    <i class="fa fa-edit"> 수정</i>
                </a>
            </span>
            <%--댓글 작성일자--%>
            <span class="description">{{prettifyDate regDate}}</span>
        </div>
        <%--댓글 내용--%>
        <div class="oldReplyText">{{{escape replyText}}}</div>
        <br/>
    </div>
    {{/each}}
</script>
<script>
    $(function () {
        var formObj = $("form[role='form']");
        console.log(formObj);

        $(".modBtn").on("click", function () {
            formObj.attr("action", "/article/paging/search/modify");
            formObj.attr("method", "get");
            formObj.submit();
        });

        $(".delBtn").on("click", function () {
            formObj.attr("action", "/article/paging/search/remove");
            formObj.submit();
        });

        $(".listBtn").on("click", function () {
            self.location = "/article/paging/search/list"
        });
    });
</script>
