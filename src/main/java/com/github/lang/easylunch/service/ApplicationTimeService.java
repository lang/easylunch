package com.github.lang.easylunch.service;

import java.util.Calendar;

public interface ApplicationTimeService {

    /**
     * Shifts applicationTime relative to system time by the number of
     * hours (positive or negative) given.
     *
     * Useful for testing and demonstration purposes.
     */
    void shiftByHours(int hours);

    Calendar applicationTime();

}
