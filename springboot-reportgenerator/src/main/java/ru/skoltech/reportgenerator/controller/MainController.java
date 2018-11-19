package ru.skoltech.reportgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rost.
 */
@Controller
public class MainController {
    @ResponseBody
    @RequestMapping("/")
    public String getString(){
        return "Well Done";
    }
}
