package com.andy.autocheckin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/9 AndyChen,new
 * </ul>
 * @since 2020/9/9
 */
@Controller
public class StatusController {

    @RequestMapping("/status")
    @ResponseBody()
    public String status() {
        return "{\"abc\": 123}";


    }


}
