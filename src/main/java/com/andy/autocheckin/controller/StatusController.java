package com.andy.autocheckin.controller;

import com.andy.autocheckin.service.ApiService;
import com.iisigroup.colabase.json.model.ResponseContent;
import com.iisigroup.colabase.ssl.service.SslClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/9 AndyChen,new
 * </ul>
 * @since 2020/9/9
 */
@Controller
public class StatusController {

    public StatusController(SslClient<ResponseContent> sslClient, ApiService apiService) {
        this.sslClient = sslClient;
        this.apiService = apiService;
    }

    private final SslClient<ResponseContent> sslClient;

    private final ApiService apiService;

    @RequestMapping("/status")
    @ResponseBody()
    public String status() {

        final Calendar instance = Calendar.getInstance();
        final String timezone = instance.getTimeZone().getDisplayName();
        final Timestamp timestamp = new Timestamp(instance.getTimeInMillis());
        return "timezone: " + timezone + ", timestamp: " + timestamp;
    }

    @RequestMapping("/testGet/{empId}")
    @ResponseBody()
    public String testGet(@PathVariable String empId) {
        if(empId == null)
            empId = "XXX";
        ResponseContent responseContent = apiService.checkinApiWithRandomLocation(empId);
//        final ResponseContent responseContent = sslClient.sendRequest(req);
        return responseContent.getRawResponseData().toString();
    }


}
