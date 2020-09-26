package com.andy.autocheckin.service;

import com.andy.autocheckin.model.TransLog;
import com.andy.autocheckin.repositories.TransLogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/25 AndyChen,new
 * </ul>
 * @since 2020/9/25
 */
@Service
public class TransLogServiceImpl implements TransLogService {

    final private TransLogRepository repository;

    public TransLogServiceImpl(TransLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransLog saveTransLog(TransLog transLog) {
        return repository.save(transLog);
    }

    @Override
    public List<TransLog> getAllLog() {
        final List<TransLog> list = new ArrayList();
        repository.findAll().forEach(list::add);
        return list;
    }
}
