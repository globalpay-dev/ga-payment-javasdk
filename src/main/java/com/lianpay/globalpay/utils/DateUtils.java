package com.lianpay.globalpay.utils;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class DateUtils {
    public static final class DateFormatHolder {
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal();
        DateFormatHolder() {
        }

        public static SimpleDateFormat formatFor(String pattern) {
            SoftReference<Map<String, SimpleDateFormat>> ref = (SoftReference)THREADLOCAL_FORMATS.get();
            Map<String, SimpleDateFormat> formats = ref == null ? null : (Map)ref.get();
            if (formats == null) {
                formats = new HashMap();
                THREADLOCAL_FORMATS.set(new SoftReference(formats));
            }

            SimpleDateFormat format = (SimpleDateFormat)((Map)formats).get(pattern);
            if (format == null) {
                format = new SimpleDateFormat(pattern);
                format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                ((Map)formats).put(pattern, format);
            }

            return format;
        }

        public static void clearThreadLocal() {
            THREADLOCAL_FORMATS.remove();
        }
    }
}
