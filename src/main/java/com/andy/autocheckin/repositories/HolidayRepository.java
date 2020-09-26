package com.andy.autocheckin.repositories;

import com.andy.autocheckin.model.Holiday;
import org.springframework.data.repository.CrudRepository;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/24 AndyChen,new
 * </ul>
 * @since 2020/9/24
 */
public interface HolidayRepository extends CrudRepository<Holiday, String> {
}
