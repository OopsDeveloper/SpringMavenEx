package com.oopsdev.reply.service;

import com.oopsdev.article.persistence.ArticleDAO;
import com.oopsdev.commons.paging.Criteria;
import com.oopsdev.reply.domain.ReplyVO;
import com.oopsdev.reply.persistence.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private ReplyDAO replyDAO;

    @Autowired
    private ArticleDAO articleDAO;


    @Override
    public List<ReplyVO> getReplies(Integer articleNo) throws Exception {
        return replyDAO.list(articleNo);
    }

    @Transactional
    @Override
    public void addReply(ReplyVO replyVO) throws Exception {
        replyDAO.create(replyVO);
        /*articleDAO.updateReplyCnt(replyVO.getArticleNo(), 1);*/
    }

    @Override
    public void modifyReply(ReplyVO replyVO) throws Exception {
        replyDAO.update(replyVO);
    }

    @Transactional
    @Override
    public void removeReply(Integer replyNo) throws Exception {
        int articleNo = replyDAO.getArticleNo(replyNo);
        replyDAO.delete(replyNo);
        /*articleDAO.updateReplyCnt(articleNo, -1);*/
    }

    @Override
    public List<ReplyVO> getRepliesPaging(Integer articleNo, Criteria criteria) throws Exception {
        return replyDAO.listPaging(articleNo, criteria);
    }

    @Override
    public int countReplies(Integer articleNo) throws Exception {
        return replyDAO.countReplies(articleNo);
    }
}
