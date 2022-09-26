package com.oopsdev.article.controller;

import com.oopsdev.article.domain.ArticleVO;
import com.oopsdev.article.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleService articleService;

    @RequestMapping(value="/write", method = RequestMethod.GET)
    public String writeGET() {
        logger.info("write GET...");
        return "/article/write";
    }

    @RequestMapping(value="/write", method = RequestMethod.POST)
    public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("write POST....");
        logger.info(articleVO.toString());
        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");
        return "redirect:/article/list";
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public String list(Model model) throws Exception{
        logger.info("list...");
        model.addAttribute("articles", articleService.listAll());
        return "/article/list";
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
        logger.info("read...");
        model.addAttribute("article", articleService.read(articleNo));
        return "/article/read";
    }
}
