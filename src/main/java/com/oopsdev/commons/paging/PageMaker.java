package com.oopsdev.commons.paging;

public class PageMaker {
    private int totalCount; //전체 게시글의 갯수
    private int startPage; //시작 페이지 번호
    private int endPage; //끝 페이지 번호
    private boolean prev; //이전 링크
    private boolean next; //다음 링크

    private int displayPageNum = 10; //하단의 페이지 번호의 갯수

    private Criteria criteria;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcDate();
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    private void calcDate() {
        endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);

        startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;

        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }
}
