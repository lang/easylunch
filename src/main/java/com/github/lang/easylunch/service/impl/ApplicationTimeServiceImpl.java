package com.github.lang.easylunch.service.impl;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.github.lang.easylunch.service.ApplicationTimeService;

@Service("applicationTimeService")
public class ApplicationTimeServiceImpl implements ApplicationTimeService {

    private int shiftHours = 0;

    public void shiftByHours(int hours) {
        shiftHours = hours;
    }

    public Calendar applicationTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, shiftHours);
        return cal;
    }

}
