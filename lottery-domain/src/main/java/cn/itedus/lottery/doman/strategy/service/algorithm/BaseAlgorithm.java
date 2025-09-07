package cn.itedus.lottery.doman.strategy.service.algorithm;

import cn.itedus.lottery.doman.strategy.model.vo.AwardRateInfo;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽奖算法基类
 * 提供通用功能：随机数生成、数据缓存、排除奖品处理
 *
 * @author yian.zhang
 * @since 2025/9/6
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm {
    
    /**
     * 安全随机数生成器
     */
    protected SecureRandom secureRandom = new SecureRandom();
    
    /**
     * 奖品区间值
     */
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    /**
     * 初始化概率区间
     * <p>
     * 1.单项概率 -> 使用桶概率的算法，不涉及奖品概率重新计算的问题，那么也就是说我们分配好的概率结果是可以固定下来的。
     * 2.总体概率 -> 使用总体概率的算法，需要在每次抽奖时重新计算概率，因为每次抽奖后奖品的概率会变化。
     * </p>
     * @param strategyId 策略ID
     * @param awardRateInfoList
     */
    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        // 1. 数据校验
        if (awardRateInfoList == null || awardRateInfoList.isEmpty()) {
            throw new IllegalArgumentException("策略ID: " + strategyId + " 的奖品概率列表不能为空");
        }
        
        // 2. 缓存数据
        awardRateInfoMap.put(strategyId, awardRateInfoList);
        
        // TODO:调用子类特定的初始化方法

    }

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 1. 获取缓存数据（共用逻辑）
        List<AwardRateInfo> awardRateList = awardRateInfoMap.get(strategyId);
        if (awardRateList == null || awardRateList.isEmpty()) {
            return null;
        }
        
        // 2. 调用子类特定的抽奖方法
        return doDraw(strategyId, excludeAwardIds);
    }

    /**
     * 子类去实现抽奖概率区间
     * @param strategyId
     * @param awardRateInfoList
     */
    protected abstract void doInit(Long strategyId,List<AwardRateInfo> awardRateInfoList);

    /**
     * 抽象方法，子类去实现特定的抽奖计算
     * @param strategyId
     * @param excludeAwardIds
     * @return
     */
    protected abstract String doDraw(Long strategyId, List<String> excludeAwardIds);


    /**
     * 判断是否已经初始化了概率
     * @param strategyId    策略ID
     * @return
     */
    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return awardRateInfoMap.containsKey(strategyId);
    }
}
