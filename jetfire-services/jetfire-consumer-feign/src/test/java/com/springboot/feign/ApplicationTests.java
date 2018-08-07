package com.springboot.feign;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationTests {

    /**
     *
     *  啤酒2元一瓶，4个瓶盖换一瓶，2个空瓶换一瓶，问：10元钱可以喝几瓶
     */
     @Test
    public void contextLoads() {
        int beer = 10 / 2;//初始的啤酒数
        int bottel = beer;//初始的瓶子数
        int cap = beer;//初始的瓶盖数
        int temp;
        while (cap >= 4 || bottel >= 2) {
            if ((temp = cap / 4) > 0) {
                beer = beer + temp;
                cap = cap - 4 * temp + temp;
                bottel = bottel + temp;
            }

            if ((temp = bottel / 2) > 0) {
                beer = beer + temp;
                cap = cap + temp;
                bottel = bottel - 2 * temp + temp;
            }
        }
        System.out.println("10元共喝了" + beer + "瓶啤酒.");
    }

}
