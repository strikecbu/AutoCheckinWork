package com.andy.autocheckin.service;

import com.andy.autocheckin.model.ApiData;
import com.iisigroup.colabase.json.model.ApiRequest;
import com.iisigroup.colabase.json.model.ResponseContent;
import com.iisigroup.colabase.ssl.service.impl.SslClientImpl;
import com.iisigroup.colabase.ssl.util.PostFormDataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/11 AndyChen,new
 * </ul>
 * @since 2020/9/11
 */
@Service
@Profile({"dev"})
public class ApiServiceDevImpl extends SslClientImpl<ResponseContent> implements ApiService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ApiServiceDevImpl() {
        super();
        logger.info("Dev ApiServiceDevImpl is on!");
    }

    @Override
    public ResponseContent checkinApi(String empId, Double Lng, Double lat) {
        final ApiData req = PostFormDataFactory.getInstance(ApiData.class);
        req.setHttpMethod(ApiRequest.HTTPMethod.GET);
        req.setIgnoreSSLcert(true);
        String temp = "https://beesmart.iisigroup.com/PunchByGPS?PunchLng=%s&EmpID=%s&WorkOff=1800&PunchLat=%s";

        final String targetUrl = String.format(temp, Lng, empId, lat);
        logger.info("TargetUrl and parameters: {}", targetUrl);
        req.setTargetUrl("https://www.google.com");

        return sendRequest(req);
    }

    @Override
    public ResponseContent checkinApi(String empId) {
        return checkinApi(empId, 121.5546303, 25.0585685);
    }
}