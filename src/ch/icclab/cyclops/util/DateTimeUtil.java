/*
 * Copyright (c) 2015. Zuercher Hochschule fuer Angewandte Wissenschaften
 *  All Rights Reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License"); you may
 *     not use this file except in compliance with the License. You may obtain
 *     a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *     WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *     License for the specific language governing permissions and limitations
 *     under the License.
 */

package ch.icclab.cyclops.util;

import org.joda.time.LocalDateTime;

/**
 * Author: Srikanta
 * Created on: 24-Nov-14
 * Description: Utility class related to date time manipulation
 * Change Log
 * Name        Date     Comments
 */
public class DateTimeUtil {

    /**
     * Generates the 1 hr time range (from and to) by computing the present server time
     * @return
     */
    public String[] getRange(){
        String from, to;
        String sMonth = null;
        String sDay = null;
        String stHour = null;
        String sHour = null;
        String sMin = null;
        String sSec = null ;
        int year, month, day, hour, min, sec, tHour;
        String[] dateTime = new String[2];

        LocalDateTime currentDate = LocalDateTime.now();
        year = currentDate.getYear();
        month = currentDate.getMonthOfYear();
        if(month <= 9){
            sMonth = "0" + month;
        }else{
            sMonth = month + "";
        }
        day = currentDate.getDayOfMonth();
        if(day <= 9){
            sDay = "0" + day;
        }else{
            sDay = day + "";
        }
        hour = currentDate.getHourOfDay();
        if(hour <= 9){
            sHour = "0" + hour;
        }else{
            sHour = hour + "";
        }
        min = currentDate.getMinuteOfHour();
        if(min <= 9){
            sMin = "0" + min;
        }else{
            sMin = min + "";
        }
        sec = currentDate.getSecondOfMinute();
        if(sec <= 9){
            sSec = "0" + sec;
        }else{
            sSec = sec + "";
        }
        to = year+"-"+sMonth+"-"+sDay+"T"+sHour+":"+sMin+":"+sSec;

        tHour = hour - 1;
        if(tHour <= 9){
            stHour = "0" + tHour;
        }else{
            stHour = tHour + "";
        }
        from = year+"-"+sMonth+"-"+sDay+"T"+stHour+":"+sMin+":"+sSec;

        dateTime[0] = to;
        dateTime[1] = from;

        return dateTime;
    }
}
