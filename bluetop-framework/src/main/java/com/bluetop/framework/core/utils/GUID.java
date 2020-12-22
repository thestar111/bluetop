package com.bluetop.framework.core.utils;

import java.util.UUID;

/**
 * <获取UID信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/22 10:05 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public final class GUID {

    public GUID() {
    }

    /**
     * 获取UID
     *
     * @return
     */
    public static String get() {
        UUID uuid = UUID.randomUUID();
        StringBuffer sb = new StringBuffer();
        get(sb, uuid.getMostSignificantBits());
        get(sb, uuid.getLeastSignificantBits());
        return sb.toString();
    }

    /**
     * 获取随机ID
     *
     * @param sb
     * @param bits
     * @return
     */
    private static StringBuffer get(StringBuffer sb, long bits) {
        for (int var3 = 13; var3-- > 0; bits >>>= 5) {
            long low = bits & 31L;
            if (low < 10L) {
                sb.append((char) ((int) (48L + low)));
            } else {
                sb.append((char) ((int) (65L + (low - 10L))));
            }
        }
        return sb;
    }
}
