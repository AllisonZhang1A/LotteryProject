package cn.itedus.lottery.doman.strategy.service.algorithm;

import cn.itedus.lottery.doman.strategy.model.vo.AwardRateInfo;

import java.util.List;

/**
 * 抽奖算法接口
 *
 * @author yian.zhang
 * @since 2025/9/6
 */

public interface IDrawAlgorithm {

 /**
  * 程序启动时初始化概率元祖，在初始化完成后使用过程中不允许修改元祖数据
  * <p>
  * 元祖数据作用在于将百分比内(0.2、0.3、0.5)的数据，转换为一整条数组上分区数据，如下；
  * 0.2 = 0 ~ 0.2
  * 0.3 = 0 + 0.2 ~ 0.2 + 0.3 = 0.2 ~ 0.5
  * 0.5 = 0.5 ~ 1 （计算方式同上）
  * @param strategyId
  * @param awardRateInfoList
  */
 void initRateTuple(Long strategyId,List<AwardRateInfo> awardRateInfoList);

 /**
  * 生成随机数，索引到对应的奖品信息返回结果
  * @param strategyId 策略ID
  * @param excludeAwardIds 排除掉已经不能作为抽奖奖品的ID，留给风控和空库存
  * @return 中奖结果
  */
 String randomDraw(Long strategyId, List<String> excludeAwardIds);

 /**
  * 判断是否已经，做了数据初始化
  * @param strategyId    策略ID
  * @return              判断结果
  */
 boolean isExistRateTuple(Long strategyId);
}
