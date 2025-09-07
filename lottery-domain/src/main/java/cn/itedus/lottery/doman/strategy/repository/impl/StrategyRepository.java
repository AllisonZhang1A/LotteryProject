package cn.itedus.lottery.doman.strategy.repository.impl;

import cn.itedus.lottery.doman.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.doman.strategy.repository.IStrategyRepository;
import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import cn.itedus.lottery.infrastructure.dao.IStrategyDao;
import cn.itedus.lottery.infrastructure.po.Award;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 19:50
 * @Description:
 */
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IActivityDao activityDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        return null;
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return null;
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return null;
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        return false;
    }
}
