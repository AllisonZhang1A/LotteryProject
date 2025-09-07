package cn.itedus.lottery.doman.strategy.service.draw.impl;

import cn.itedus.lottery.doman.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.doman.strategy.service.draw.AbstractDrawBase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 20:01
 * @Description: 抽奖过程方法实现
 */
@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {
    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        return awardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // 执行抽奖算法
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);
        return awardId;
    }
}
