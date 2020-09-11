package com.andy.autocheckin.service;

import com.iisigroup.colabase.json.model.ResponseContent;
import com.iisigroup.colabase.ssl.service.SslClient;
import com.iisigroup.colabase.ssl.service.impl.SslClientImpl;
import org.springframework.stereotype.Service;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/11 AndyChen,new
 * </ul>
 * @since 2020/9/11
 */
@Service
public class ApiServiceImpl extends SslClientImpl<ResponseContent> implements SslClient<ResponseContent> {

}
