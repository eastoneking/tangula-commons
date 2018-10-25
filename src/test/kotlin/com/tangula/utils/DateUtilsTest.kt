package com.tangula.utils

import com.tangula.utils.DateUtils
import junit.framework.TestCase
import org.junit.Test
import java.util.*

class DateUtilsTest {

    @Test
    fun testDate2StrYyyMmDd(){

        TestCase.assertEquals("", DateUtils.date2StrYyyMmDd(null))
        TestCase.assertEquals("2000-01-01", DateUtils.date2StrYyyMmDd(Date(100,0,1,1,1,1 )))

    }

    @Test
    fun testStrYyyMmDd2Date(){
        TestCase.assertEquals(Date(100,0,1,0,0,0 ).time, DateUtils.strYyyMmDd2Date("2000-01-01")!!.time)
        TestCase.assertNull(DateUtils.strYyyMmDd2Date(null))
        TestCase.assertNull(DateUtils.strYyyMmDd2Date("aaaa"))
    }

    @Test
    fun testSeconds2HHmmssStr(){
        TestCase.assertEquals("00:00:00", DateUtils.seconds2HHmmssStr(0))
        TestCase.assertEquals("00:00:01", DateUtils.seconds2HHmmssStr(1))
        TestCase.assertEquals("00:00:10", DateUtils.seconds2HHmmssStr(10))
        TestCase.assertEquals("00:01:00", DateUtils.seconds2HHmmssStr(60))
        TestCase.assertEquals("00:01:01", DateUtils.seconds2HHmmssStr(61))
        TestCase.assertEquals("00:01:10", DateUtils.seconds2HHmmssStr(70))
        TestCase.assertEquals("00:01:11", DateUtils.seconds2HHmmssStr(71))
        TestCase.assertEquals("01:00:00", DateUtils.seconds2HHmmssStr(3600))
        TestCase.assertEquals("01:00:01", DateUtils.seconds2HHmmssStr(3601))
        TestCase.assertEquals("01:00:10", DateUtils.seconds2HHmmssStr(3610))
        TestCase.assertEquals("01:01:00", DateUtils.seconds2HHmmssStr(3600+60))
        TestCase.assertEquals("01:01:01", DateUtils.seconds2HHmmssStr(3600+60+1))
        TestCase.assertEquals("01:01:11", DateUtils.seconds2HHmmssStr(3600+60+11))
        TestCase.assertEquals("01:10:00", DateUtils.seconds2HHmmssStr(3600+600))
        TestCase.assertEquals("01:00:11", DateUtils.seconds2HHmmssStr(3611))
        TestCase.assertEquals("99:00:00", DateUtils.seconds2HHmmssStr(3600*99))
        TestCase.assertEquals("100:00:00", DateUtils.seconds2HHmmssStr(3600*100))
    }

    fun testMillisSecond2HhmmsssssStr(){
        TestCase.assertEquals("00:00:00.000", DateUtils.seconds2HHmmssStr(0*1000))
        TestCase.assertEquals("00:00:00.001", DateUtils.seconds2HHmmssStr(1))
        TestCase.assertEquals("00:00:00.999", DateUtils.seconds2HHmmssStr(999))
        TestCase.assertEquals("00:00:01.000", DateUtils.seconds2HHmmssStr(1000))
        TestCase.assertEquals("00:00:10.000", DateUtils.seconds2HHmmssStr(10000))
        TestCase.assertEquals("00:01:00.000", DateUtils.seconds2HHmmssStr(60000))
        TestCase.assertEquals("00:01:01.000", DateUtils.seconds2HHmmssStr(61000))
        TestCase.assertEquals("00:01:10.000", DateUtils.seconds2HHmmssStr(70000))
        TestCase.assertEquals("00:01:11.000", DateUtils.seconds2HHmmssStr(71000))
        TestCase.assertEquals("01:00:00.000", DateUtils.seconds2HHmmssStr(3600000))
        TestCase.assertEquals("01:00:01.000", DateUtils.seconds2HHmmssStr(3601000))
        TestCase.assertEquals("01:00:10.000", DateUtils.seconds2HHmmssStr(3610000))
        TestCase.assertEquals("01:01:00.000", DateUtils.seconds2HHmmssStr((3600+60)*1000))
        TestCase.assertEquals("01:01:01.000", DateUtils.seconds2HHmmssStr((3600+60+1)*1000))
        TestCase.assertEquals("01:01:11.000", DateUtils.seconds2HHmmssStr((3600+60+11)*1000))
        TestCase.assertEquals("01:10:00.000", DateUtils.seconds2HHmmssStr((3600+600)*1000))
        TestCase.assertEquals("01:00:11.000", DateUtils.seconds2HHmmssStr(3611000))
        TestCase.assertEquals("99:00:00.000", DateUtils.seconds2HHmmssStr(3600*99*1000))
        TestCase.assertEquals("100:00:00.000", DateUtils.seconds2HHmmssStr(3600*100*1000))
    }

}