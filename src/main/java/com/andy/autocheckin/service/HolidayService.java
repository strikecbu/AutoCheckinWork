package com.andy.autocheckin.service;

import com.andy.autocheckin.model.Holiday;

import java.util.List;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/25 AndyChen,new
 * </ul>
 * @since 2020/9/25
 */
public interface HolidayService {
    Holiday saveHoliday(Holiday holiday);

    List<Holiday> getAllHoliday();
}
