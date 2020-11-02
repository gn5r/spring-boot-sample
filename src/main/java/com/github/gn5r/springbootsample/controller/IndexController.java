package com.github.gn5r.springbootsample.controller;

import com.github.gn5r.spring.boot.common.controller.AbstractController;
import com.github.gn5r.spring.boot.common.exception.RestRuntimeException;
import com.github.gn5r.spring.boot.common.logger.CmnLogger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends AbstractController {

    @GetMapping({ "", "/" })
    public String redirect() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        CmnLogger.APP.info("indexへアクセス");
        return "index";
    }

    @GetMapping("/err")
    public String error(Model model) {
        CmnLogger.APP.info("エラーページへ遷移" + "model:" + model);
        return "error";
    }

    @GetMapping("/exception")
    public String exception() throws RestRuntimeException {
        // return "exception";
        CmnLogger.APP.info("エラーのテストをします");
        throw new RestRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, "テストエラーです");
    }
}