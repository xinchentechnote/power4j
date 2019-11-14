package com.wsx.designpattern.behavioral.strastegy;

import java.util.HashMap;
import java.util.Map;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:13.
 * @Modified By:
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();
    private static PromotionStrategy defaultPromotionStrategy;

    static {
        defaultPromotionStrategy = new DefaultPromotionStrategy();
        PROMOTION_STRATEGY_MAP.put("lijian", new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put("manjian", new ManJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put("fanxian", new FanXianPromotionStrategy());
    }

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        return PROMOTION_STRATEGY_MAP.getOrDefault(promotionKey, defaultPromotionStrategy);
    }


}
