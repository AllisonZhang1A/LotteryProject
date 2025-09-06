package cn.itedus.lottery.doman.strategy.model.res;

import cn.itedus.lottery.doman.strategy.model.vo.DrawAwardVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 抽奖结果
 * @author：小傅哥，微信：fustack
 * @date: 2021/8/28
 * @Copyright：公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrawResult {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
     */
    private Integer drawState;

    /**
     * 中奖奖品信息
     */
    private DrawAwardVO drawAwardInfo;
}
