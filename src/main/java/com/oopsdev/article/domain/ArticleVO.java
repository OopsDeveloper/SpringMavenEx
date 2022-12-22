package com.oopsdev.article.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleVO {
    private Integer articleNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;
    private int replyCnt;
}
