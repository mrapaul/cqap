package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CountriesController
{
    @RequestMapping("/countries/findAll")
    public @ResponseBody Countries findAll()
    {
        return new Countries(getCountries());
    }

    @RequestMapping(value="countries/findTimezones", method=RequestMethod.POST)
    public @ResponseBody Timezones find(@RequestBody Country aCountry)
    {
        return new Timezones(getTimezones(aCountry));
    }

    public static List<Country> getCountries()
    {
        List<Country> myCountries = new ArrayList<>();
        String[] myISOCountries = Locale.getISOCountries();
        Arrays.sort(myISOCountries);
        for (String myCountryCode : myISOCountries)
        {
            Locale myLocale = new Locale("", myCountryCode);
            Calendar myCalendar = Calendar.getInstance(myLocale);
            String myTimeZone = myCalendar.getTimeZone().getDisplayName();
            myCountries.add(new Country(myLocale.getDisplayCountry(), myCountryCode, myTimeZone));
        }

        return myCountries;
    }

    public static Set<String> getTimezones(Country aCountry)
    {
        Set<String> myTimezones = new HashSet<>();
        for (String myId :  com.ibm.icu.util.TimeZone.getAvailableIDs(aCountry.getCode()))
        {
            myTimezones.add(TimeZone.getTimeZone(myId).getDisplayName());
        }
        return myTimezones;
    }
}
