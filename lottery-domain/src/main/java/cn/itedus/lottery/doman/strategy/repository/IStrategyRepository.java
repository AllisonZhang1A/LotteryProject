package cn.itedus.lottery.doman.strategy.repository;

import cn.itedus.lottery.doman.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.infrastructure.po.Award;

import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 19:50
 * @Description: 策略表仓储服务
 */
public interface IStrategyRepository {

    /**
     * 查询抽奖策略实体
     * @param strategyId
     * @return
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 查询奖品信息
     * @param awardId
     * @return
     */
    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return           扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
