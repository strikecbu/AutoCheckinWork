package com.andy.autocheckin.schedule;

import com.andy.autocheckin.model.Holiday;
import com.andy.autocheckin.model.TransLog;
import com.andy.autocheckin.service.ApiService;
import com.andy.autocheckin.service.HolidayService;
import com.andy.autocheckin.service.TransLogService;
import com.iisigroup.colabase.json.model.ResponseContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author AndyChen
 * @version <ul>
 * <li>2020/9/25 AndyChen,new
 * </ul>
 * @since 2020/9/25
 */
@Component
public class AutoCheckinSchedule {

    final private Logger logger = LoggerFactory.getLogger(getClass());

    final private HolidayService holidayService;

    final private TransLogService transLogService;

    final private ApiService sslClient;



    public AutoCheckinSchedule(HolidayService holidayService, TransLogService transLogService, ApiService sslClient) {
        this.holidayService = holidayService;
        this.transLogService = transLogService;
        this.sslClient = sslClient;
    }

    @Scheduled(cron = "0 15 9 * * ?", zone = "Asia/Taipei")
    public void checkinJob() throws InterruptedException {
        // random delay
        final Random random = new Random();
        final int delaySec = random.nextInt(360);
        doCheckin("1510002", delaySec);
    }

    @Scheduled(cron = "0 45 18 * * ?", zone = "Asia/Taipei")
    public void checkoutJob() throws InterruptedException {
        // random delay
        final Random random = new Random();
        final int delaySec = random.nextInt(360);
        doCheckin("1510002", delaySec);
    }

    public void doCheckin(String empId, int delaySec) throws InterruptedException {
        //是假日就不checkin
        final String timezone = "Asia/Taipei";
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(timezone));
        if(checkIsHoliday(instance.getTimeInMillis()))
            return;

        logger.info(String.format("Delay %s secs", delaySec));
        logger.info("System current time: {}", new Timestamp(System.currentTimeMillis()));
        Thread.sleep(delaySec * 1000);

        logger.info("Start checkin...");
        instance = Calendar.getInstance(TimeZone.getTimeZone(timezone));
        logger.info("Checkin {} timestamp: {}", timezone, new Timestamp(instance.getTimeInMillis()));
        final ResponseContent response = sslClient.checkinApi(empId);
        logger.info("Server response status: {}", response.getStatusCode());
        logger.info("Server response text: {}", response.getRawResponseData());

        final TransLog transLog = new TransLog();
        transLog.setTime(new Timestamp(instance.getTimeInMillis()));
        transLog.setParameters(String.format("EmpId: %s", empId));
        transLog.setStatus(String.valueOf(response.getStatusCode()));
        transLog.setResponseString(response.getRawResponseData().toString());
        transLogService.saveTransLog(transLog);
        logger.info("Checkin Job complete.");
    }



    public boolean checkIsHoliday(long timeMillis) {
        final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        final String today = format.format(new Date(timeMillis));
        final List<Holiday> collect = holidayService.getAllHoliday().stream().filter(holiday -> {
            final String holidayStr = format.format(holiday.getHoliday());
            return today.equals(holidayStr);
        }).collect(Collectors.toList());
        return collect.size() > 0;
    }

}
