package com.andy.autocheckin.controller;

import com.andy.autocheckin.model.TransLog;
import com.andy.autocheckin.service.TransLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/26 AndyChen,new
 * </ul>
 * @since 2020/9/26
 */
@Controller
public class TransLogController {

    final private TransLogService transLogService;

    public TransLogController(TransLogService transLogService1) {
        this.transLogService = transLogService1;
    }

    @RequestMapping("/getTrans")
    public String getTransDashboard(Model model) {
        final List<TransLog> allLog = transLogService.getAllLog();
        model.addAttribute("trans", allLog);
        return "trans_board";
    }
}
