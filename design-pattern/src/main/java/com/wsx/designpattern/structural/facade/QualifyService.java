package com.wsx.designpattern.structural.facade;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:01.
 * @Modified By:
 */

public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift){
        System.out.println("校验"+pointsGift);
        return true;
    }
}
