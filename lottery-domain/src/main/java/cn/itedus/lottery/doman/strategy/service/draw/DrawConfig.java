package cn.itedus.lottery.doman.strategy.service.draw;

import cn.itedus.lottery.common.enums.StrategyModeEnum;
import cn.itedus.lottery.doman.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 20:00
 * @Description: 抽奖统一配置信息类
 */
public class DrawConfig {

    @Resource
    private IDrawAlgorithm totalRateDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateDrawAlgorithm;

    /** 抽奖策略组 */
    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        drawAlgorithmGroup.put(StrategyModeEnum.TOTAL_RATE.getCode(),totalRateDrawAlgorithm);
        drawAlgorithmGroup.put(StrategyModeEnum.SINGLE_RATE.getCode(),singleRateDrawAlgorithm);
    }

}
