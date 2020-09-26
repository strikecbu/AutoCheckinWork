package com.andy.autocheckin.repositories;

import com.andy.autocheckin.model.TransLog;
import org.springframework.data.repository.CrudRepository;

public interface TransLogRepository extends CrudRepository<TransLog, Long> {
}
