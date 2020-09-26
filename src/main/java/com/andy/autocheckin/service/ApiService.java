package com.andy.autocheckin.service;

import com.iisigroup.colabase.json.model.ResponseContent;
import com.iisigroup.colabase.ssl.service.SslClient;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/25 AndyChen,new
 * </ul>
 * @since 2020/9/25
 */
public interface ApiService extends SslClient<ResponseContent> {

    ResponseContent checkinApi(String empId, Double Lng, Double lat);
    ResponseContent checkinApi(String empId);
}
