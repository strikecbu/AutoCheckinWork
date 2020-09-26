package com.andy.autocheckin.service;

import com.andy.autocheckin.model.Holiday;
import com.andy.autocheckin.repositories.HolidayRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/25 AndyChen,new
 * </ul>
 * @since 2020/9/25
 */
@Service
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;

    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public Holiday saveHoliday(Holiday holiday) {
        if (holiday.getOid() == null) {
            holiday.setOid(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        return holidayRepository.save(holiday);
    }

    @Override
    public List<Holiday> getAllHoliday() {
        final List<Holiday> list = new ArrayList();
        holidayRepository.findAll().forEach(list::add);
        return list;
    }
}
