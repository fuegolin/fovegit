package com.fovegit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by zhengxuelin on 2016/1/5.
 */
@Controller
@RequestMapping(value="/jovegit")
public class IndexController {
    private static Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping(value="/index")
    public String homepage() {
        logger.info("进入主页");
        //return "WEB-INF/views/home.jsp";
        return "/home";
    }

    @RequestMapping(value="/poiexcel")
    public String poiexcel() {
        logger.info("进入poiexcel");



        return "/home";
    }

}
