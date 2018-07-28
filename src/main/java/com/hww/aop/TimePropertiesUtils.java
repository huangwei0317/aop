package com.hww.aop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@SuppressWarnings("all")
@Component
public class TimePropertiesUtils {

    private static Properties prop = null;
    private static final SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    public TimePropertiesUtils() {
    }

    static void loadProperties() {
        prop = new Properties();

        try {
            InputStream is = TimePropertiesUtils.class.getResourceAsStream("/time.properties");
            prop.load(is);
            Iterator it = prop.stringPropertyNames().iterator();

            while(it.hasNext()) {
                String key = (String)it.next();
                prop.put(key, prop.getProperty(key));
            }

            is.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static String getValue(String key) {
        return StringUtils.isEmpty(key) ? null : prop.getProperty(key);
    }

    public static synchronized void setValue(String key, String value) {
        if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value)) {
            try {
                Date parse = null;
                if (value.matches("^[\\d]{4}(-[\\d]{1,2}){2}$")) {
                    parse = simpleDateFormat2.parse(value);
                    prop.setProperty(key, String.valueOf(parse.getTime()));
                } else if (value.matches("^[\\d]{4}(-[\\d]{1,2}){2} [\\d]{1,2}(:[\\d]{1,2}){2}$")) {
                    parse = simpleDateFormat1.parse(value);
                    prop.setProperty(key, String.valueOf(parse.getTime()));
                } else if (value.matches("^[\\d]+$")) {
                    prop.setProperty(key, value);
                }

                save();
                loadProperties();
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        } else {
            throw new NullPointerException("新增或修改的key或者value不能为空或空字符串");
        }
    }

    private static void save() {
        try {
            OutputStream os = new FileOutputStream(TimePropertiesUtils.class.getResource("/time.properties").getPath());
            prop.store(os, (String)null);
            os.flush();
            os.close();
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }

    static {
        loadProperties();
    }
}
