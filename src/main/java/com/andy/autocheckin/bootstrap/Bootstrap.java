package com.andy.autocheckin.bootstrap;

import com.andy.autocheckin.model.Holiday;
import com.andy.autocheckin.model.TransLog;
import com.andy.autocheckin.service.HolidayService;
import com.andy.autocheckin.service.TransLogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/25 AndyChen,new
 * </ul>
 * @since 2020/9/25
 */
@Component
public class Bootstrap implements CommandLineRunner {

    public Bootstrap(HolidayService holidayService, TransLogService transLogService) {
        this.holidayService = holidayService;
        this.transLogService = transLogService;
    }

    private HolidayService holidayService;

    private TransLogService transLogService;

    @Override
    public void run(String... args) throws Exception {

        final Holiday holiday = new Holiday();
//        holiday.setHoliday(new Timestamp(System.currentTimeMillis()));
//        holiday.setOid("123432423");
//        final Holiday holiday1 = holidayService.saveHoliday(holiday);
        final List<Holiday> allHoliday = holidayService.getAllHoliday();

        final TransLog transLog = new TransLog();
        transLog.setParameters("EmpId: 123");
        transLog.setStatus("200");
        transLog.setResponseString("I'm OK");
        transLog.setTime(new Timestamp(System.currentTimeMillis()));
        transLogService.saveTransLog(transLog);
        final TransLog transLog1 = new TransLog();
        transLog1.setParameters("EmpId: 456");
        transLog1.setStatus("500");
        transLog1.setResponseString("Oh, NO");
        transLog1.setTime(new Timestamp(System.currentTimeMillis()));
        transLogService.saveTransLog(transLog1);

        String s = "";

    }
}
