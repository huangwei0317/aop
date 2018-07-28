package com.hww.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AopApplicationTests {



    @Test
    public void contextLoads() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"admin1","2017-01-09 12:12:12"));
        users.add(new User(2,"admin1","2017-01-08 12:12:11"));
        users.add(new User(3,"admin1","2017-01-15 12:12:12"));
        users.add(new User(4,"admin1","2017-01-03 12:12:12"));
        User user = users.stream().sorted((o1, o2) -> {
            if (StringUtils.isEmpty(o1.getTime())) {
                return -1;
            } else if (StringUtils.isEmpty(o2.getTime())) {
                return 1;
            } else {
                Date d1 = null;
                Date d2 = null;
                try {
                    d1 = sdf.parse(o1.getTime());
                    d2 = sdf.parse(o2.getTime());
                    return d1.getTime() > d2.getTime() ? 1 : (d1.getTime() == d2.getTime() ? 0 : -1);
                } catch (ParseException var6) {
                    var6.printStackTrace();
                    return 0;
                }
            }
        }).collect(Collectors.toList()).get(users.size() - 1);
        System.out.println(user);
    }

}
