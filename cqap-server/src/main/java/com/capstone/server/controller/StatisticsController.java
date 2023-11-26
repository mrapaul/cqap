package com.capstone.server.controller;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatisticsController
{
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(@Qualifier("StatisticsService") StatisticsService statisticsService)
    {
        this.statisticsService = statisticsService;
    }

    @RequestMapping("/stats/totalTicketCount")
    public @ResponseBody Long getTotalTicketCount()
    {
        return statisticsService.getTotalOrderCount();
    }

    @RequestMapping("/stats/totalPRTicketCount")
    public @ResponseBody Long getTotalPRTicketCount()
    {
        return statisticsService.getTotalPROrderCount();
    }

    @RequestMapping("/stats/totalTRTicketCount")
    public @ResponseBody Long getTotalTRTicketCount()
    {
        return statisticsService.getTotalTROrderCount();
    }

//    @RequestMapping("/stats/totalTicketsPerDay")
//    public @ResponseBody TicketsPerDayCollection getTotalTicketsPerDay()
//    {
//        return statisticsService.getTotalTicketsPerDay();
//    }
//
//    @RequestMapping("/stats/categoryModalityDistributions")
//    public @ResponseBody CategoryDistributions getCategoryModalityDistributions()
//    {
//        return statisticsService.getCategoryModalityDistribution();
//    }

}
