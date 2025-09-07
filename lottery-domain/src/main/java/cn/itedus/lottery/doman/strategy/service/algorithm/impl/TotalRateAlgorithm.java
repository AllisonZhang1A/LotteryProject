package cn.itedus.lottery.doman.strategy.service.algorithm.impl;

import cn.itedus.lottery.doman.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.doman.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 20:09
 * @Description: 总体概率计算
 */
@Component("totalRateDrawAlgorithm")
public class TotalRateAlgorithm extends BaseAlgorithm {


    @Override
    protected void doInit(Long strategyId, List<AwardRateInfo> awardRateInfoList) {

    }

    @Override
    protected String doDraw(Long strategyId, List<String> excludeAwardIds) {
        return "";
    }
}
