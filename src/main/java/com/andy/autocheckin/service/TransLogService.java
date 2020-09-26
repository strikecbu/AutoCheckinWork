package com.andy.autocheckin.service;

import com.andy.autocheckin.model.TransLog;

import java.util.List;

public interface TransLogService {
    TransLog saveTransLog(TransLog transLog);

    List<TransLog> getAllLog();
}
