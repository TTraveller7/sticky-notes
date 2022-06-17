package bht.salvinto.stickynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {

    @RequestMapping(value = {"", "/index", "/index.html"})
    public String getIndexPage() {
        return "index";
    }
}
