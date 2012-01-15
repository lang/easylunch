package com.github.lang.easylunch.service;

import java.util.Calendar;

public interface ApplicationTimeService {

    /**
     * Shifts applicationTime relative to system time by the numer of
     * hours (positive or negative) given.
     *
     * Useful for testing and demonstration purposes.
     */
    void shiftByHours(int hours);

    Calendar applicationTime();

}
