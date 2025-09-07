package cn.itedus.lottery.doman.strategy.service.draw;

import cn.itedus.lottery.doman.strategy.model.req.DrawReq;
import cn.itedus.lottery.doman.strategy.model.res.DrawResult;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 20:01
 * @Description: 抽奖接口
 */
public interface IDrawExec {

    /**
     * 抽奖接口
     * @param req 抽奖请求参数
     * @return 抽奖结果
     */
    DrawResult doDrawExec(DrawReq req);
}
