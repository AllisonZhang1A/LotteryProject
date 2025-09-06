package cn.itedus.lottery.doman.strategy.model.aggregates;



import cn.itedus.lottery.doman.strategy.model.vo.StrategyBriefVO;
import cn.itedus.lottery.doman.strategy.model.vo.StrategyDetailBriefVO;

import java.util.List;

/**
 * @description: 抽奖策略聚合对象
 * @author: 小傅哥，微信：fustack
 * @date: 2021/9/4
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */

public class StrategyRich {

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 策略配置
     */
    private StrategyBriefVO strategy;

    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailList;
}
