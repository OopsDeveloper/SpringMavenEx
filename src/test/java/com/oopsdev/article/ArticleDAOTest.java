package com.oopsdev.article;

import com.oopsdev.article.domain.ArticleVO;
import com.oopsdev.article.persistence.ArticleDAO;
import com.oopsdev.commons.paging.Criteria;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Autowired
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setTitle("새로운 글 작성 테스트 제목");
        article.setContent("새로운 글 작성 테스트 내용");
        article.setWriter("새로운 글 작성자");
        articleDAO.create(article);
    }

    @Test
    public void testRead() throws Exception {
        logger.info(articleDAO.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setArticleNo(1001);
        article.setTitle("글 수정 테스트 제목");
        article.setContent("글 수정 테스트 내용");
        articleDAO.update(article);
    }

    @Test
    public void testDelete() throws Exception {
        articleDAO.delete(1001);
    }

    @Test
    public void testListPaging() throws Exception {
        int page = 3;

        List<ArticleVO> articles = articleDAO.listPaging(page);

        for (ArticleVO article : articles) {
            logger.info(article.getArticleNo() + ":" + article.getTitle());
        }
    }

    @Test
    public void testListCriteria() throws Exception {

        Criteria criteria = new Criteria();
        criteria.setPage(3);
        criteria.setPerPageNum(20);

        List<ArticleVO> articles = articleDAO.listCriteria(criteria);

        for (ArticleVO article : articles) {
            logger.info(article.getArticleNo() + ":" + article.getTitle());
        }
    }
}
