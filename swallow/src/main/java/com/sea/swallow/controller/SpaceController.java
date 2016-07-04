package com.sea.swallow.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sea.swallow.ibll.IArticleManage;
import com.sea.swallow.model.ResultInfo;

@Controller
@RequestMapping("/space")
public class SpaceController {
    @Resource(name="articleService")
    private IArticleManage articleService;
    
    /**
     * 写博文
     * @param request
     * @return
     */
    @RequestMapping("/writearticle")
    public ResultInfo<String> WriteArticle(HttpServletRequest request){
        try {
			return articleService.writeBlog(request);
		} catch (Exception e) {
			return new ResultInfo<String>(-1,"服务器请求失败","");
		}
    }
 }
