package com.andy.autocheckin.controller;

import com.andy.autocheckin.model.ApiData;
import com.iisigroup.colabase.json.model.ApiRequest;
import com.iisigroup.colabase.json.model.ResponseContent;
import com.iisigroup.colabase.ssl.service.SslClient;
import com.iisigroup.colabase.ssl.util.PostFormDataFactory;
import org.springframework.stereotype.Controller;
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

    public StatusController(SslClient sslClient) {
        this.sslClient = sslClient;
    }

    private SslClient sslClient;

    @RequestMapping("/status")
    @ResponseBody()
    public String status() {

        final Calendar instance = Calendar.getInstance();
        final String timezone = instance.getTimeZone().getDisplayName();
        final Timestamp timestamp = new Timestamp(instance.getTimeInMillis());
        return "timezone: " + timezone + ", timestamp: " + timestamp;
    }

    @RequestMapping("/testGet")
    @ResponseBody()
    public String testGet() {
        final ApiData req = PostFormDataFactory.getInstance(ApiData.class);
        req.setHttpMethod(ApiRequest.HTTPMethod.POST);
        req.setIgnoreSSLcert(true);
//        req.setTargetUrl("https://beesmart.iisigroup.com/PunchByGPS");
        String targetUrl = "https://beesmart.iisigroup.com/PunchByGPS?PunchLng=121.5546303&EmpID=xxxxx&WorkOff=1800&PunchLat=25.0585685";
//        targetUrl = targetUrl.replace("xxxxx", "1510002");
        req.setTargetUrl(targetUrl);
//        req.setPunchLng("121.5546303");
//        req.setPunchLat("25.0585685");
//        req.setEmpID("xxxxx");
//        req.setWorkOff("1800");

        final ResponseContent responseContent = sslClient.sendRequest(req);

        return responseContent.getResponseJson().toString();
    }


}
