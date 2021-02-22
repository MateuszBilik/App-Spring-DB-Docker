package com.hw4.app.controller;

import com.hw4.app.service.GetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EURUSD")
public class GetController {

    private final GetService getService;

    public GetController(GetService getService) {
        this.getService = getService;
    }

    @GetMapping("/{yyyy}/{MM}/{dd}/{hh}/{mm}")
    public String getDataForMinute(@PathVariable("yyyy") int year,
                                   @PathVariable("MM") int month,
                                   @PathVariable("dd") int day,
                                   @PathVariable("hh") int hour,
                                   @PathVariable("mm") int minute) {
        return getService.doGetForMinute(year, month, day, hour, minute);
    }

    @GetMapping("/{yyyy}/{MM}/{dd}/{hh}")
    public String getDataForHour(@PathVariable("yyyy") int year,
                                 @PathVariable("MM") int month,
                                 @PathVariable("dd") int day,
                                 @PathVariable("hh") int hour) {
        return getService.doGetForHour(year, month, day, hour);
    }

    @GetMapping("/{yyyy}/{MM}/{dd}")
    public String getDataForDay(@PathVariable("yyyy") int year,
                                @PathVariable("MM") int month,
                                @PathVariable("dd") int day) {
        return getService.doGetForDay(year, month, day);
    }

    @GetMapping("type/{type}/{yyyy}/{MM}/{dd}/{hh}/{mm}")
    public String getDataForMinuteWithType(@PathVariable("type") String type,
                                           @PathVariable("yyyy") int year,
                                           @PathVariable("MM") int month,
                                           @PathVariable("dd") int day,
                                           @PathVariable("hh") int hour,
                                           @PathVariable("mm") int minute) {
        return getService.doGetForMinuteWithType(type, year, month, day, hour, minute);
    }

    @GetMapping("type/{type}/{yyyy}/{MM}/{dd}/{hh}")
    public String getDataForHourWithType(@PathVariable("type") String type,
                                         @PathVariable("yyyy") int year,
                                         @PathVariable("MM") int month,
                                         @PathVariable("dd") int day,
                                         @PathVariable("hh") int hour) {
        return getService.doGetForHourWithType(type, year, month, day, hour);
    }

    @GetMapping("type/{type}/{yyyy}/{MM}/{dd}")
    public String getDataForDayWithType(@PathVariable("type") String type,
                                        @PathVariable("yyyy") int year,
                                        @PathVariable("MM") int month,
                                        @PathVariable("dd") int day) {
        return getService.doGetForDayWithType(type, year, month, day);
    }
}
