package com.andy.autocheckin.schedule;

import com.andy.autocheckin.model.TransLog;
import com.andy.autocheckin.service.TransLogService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles({"dev"})
class AutoCheckinScheduleTest {

    @Autowired
    private AutoCheckinSchedule schedule;

    @Autowired
    private TransLogService transLogService;

    @Test
    void checkIsHoliday() {
        final boolean b = schedule.checkIsHoliday(System.currentTimeMillis());
        String s = "";


    }

    @Test
    public void testApi() throws InterruptedException {
        schedule.doCheckin("xxxxx", 0);
        final List<TransLog> allLog = transLogService.getAllLog();

        Assert.assertTrue(allLog.size() > 0);
    }


}