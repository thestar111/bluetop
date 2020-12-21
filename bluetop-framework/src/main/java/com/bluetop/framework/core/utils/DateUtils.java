/**
 * 文 件 名:  DateUtils
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/12/14 0014
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.framework.core.utils;

import com.bluetop.framework.core.exception.SystemException;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static com.bluetop.framework.core.cons.IErrorCodeEnum.Param_does_not_correct;


/**
 * <时间工具类>
 *
 * @author zping
 * @version 2018/12/14 0014
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public final class DateUtils {


    /**
     * 东3区时间
     */
    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    /**
     * 14位
     */
    public static final String TIME_PATTERN_FOUR = "yyyyMMddHHmmss";

    /**
     * 8位
     */
    public static final String ISO_TIME_FORMAT = "yyyyMMdd";

    /**
     * 6位
     */
    public static final String TIME_MONTH_FORMAT = "yyyyMM";

    /**
     * 10位
     */
    public static final String TIME_EXPAND_FORMAT = "yyyy-MM-dd";

    /**
     * 18位
     */
    public static final String TIME_PATTERN_COMMON = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取特定时间格式的当前时间
     *
     * @return
     */
    public static String getCurrentDate(String pattern) {
        LocalDateTime currentDate = LocalDateTime.now();
        //今天获取昨天账期的
        return currentDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 根据时区获取当前时间（yyyy-MM-dd hh:mm:ss）
     *
     * @return
     */
    public static String getCurrentTimeOfZone(ZoneId zone) {
        //柏林时间
        ZoneId zoneOffset = ZoneOffset.of(zone.getId());
        LocalDateTime currentDate = LocalDateTime.now(zoneOffset);
        return currentDate.format(DateTimeFormatter.ofPattern(TIME_PATTERN_COMMON));
    }

    /**
     * 转化Long时间格式为YYYY-MM-dd HH:mm:ss时间格式
     *
     * @param times
     * @return
     */
    public static String convertTimeToString(Long times) {
        Assert.notNull(times, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern(TIME_PATTERN_COMMON);
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(times), ZoneId.systemDefault()));
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getYesterdayDate(String format) {
        LocalDate currentDate = LocalDate.now();
        currentDate = currentDate.plus(-1, ChronoUnit.DAYS);
        return currentDate.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间计算
     *
     * @param currentTime  开始时间
     * @param sourceFormat 时间格式化
     * @param targetFormat 时间格式化
     * @param hours        小时
     * @return
     */
    public static String plus(String currentTime, String sourceFormat, String targetFormat, long hours) {
        if (StringUtils.isEmpty(currentTime)) {
            return null;
        }
        LocalDateTime now = LocalDateTime.parse(currentTime, DateTimeFormatter.ofPattern(sourceFormat));
        now = now.plus(hours, ChronoUnit.HOURS);
        return now.format(DateTimeFormatter.ofPattern(targetFormat));
    }

    /**
     * 时间转换
     *
     * @param time          时间（yyyyMMddHHmmss）
     * @param sourcePattern 源格式
     * @param targetPattern 目标格式
     * @return
     */
    public static String parseTime(String time, String sourcePattern, String targetPattern) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        LocalDateTime now = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(sourcePattern));
        return now.format(DateTimeFormatter.ofPattern(targetPattern));
    }

    /**
     * 时间转换
     *
     * @param time          时间
     * @param sourcePattern 源格式
     * @param hours         时间操作小时
     * @return
     */
    public static String adjustTime(String time, String sourcePattern, long hours) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        LocalDateTime now = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(sourcePattern));
        now = now.plus(hours, ChronoUnit.HOURS);
        return now.format(DateTimeFormatter.ofPattern(TIME_PATTERN_COMMON));
    }

    /**
     * 时间转换
     *
     * @param date          时间（yyyyMMdd）
     * @param sourcePattern 源格式
     * @param targetPattern 目标格式
     * @return
     */
    public static String parseDate(String date, String sourcePattern, String targetPattern) {
        if (StringUtils.isEmpty(date)) {
            throw new SystemException(Param_does_not_correct);
        }
        LocalDate now = LocalDate.parse(date, DateTimeFormatter.ofPattern(sourcePattern));
        return now.format(DateTimeFormatter.ofPattern(targetPattern));
    }
}
