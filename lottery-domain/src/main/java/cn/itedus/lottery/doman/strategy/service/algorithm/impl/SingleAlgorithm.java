package cn.itedus.lottery.doman.strategy.service.algorithm.impl;

import cn.itedus.lottery.doman.strategy.model.vo.AwardRateVO;
import cn.itedus.lottery.doman.strategy.service.algorithm.BaseAlgorithm;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单项概率
 *
 * @author yian.zhang
 * @since 2025/9/6
 */

public class SingleAlgorithm extends BaseAlgorithm {

    /**
     * 桶数组缓存 - 线程安全
     * Key: 策略ID, Value: 长度为100的奖品ID数组
     */
    private final Map<Long, String[]> bucketArrayMap = new ConcurrentHashMap<>();

    /**
     * 默认桶数量
     */
    private static final int DEFAULT_BUCKET_SIZE = 100;

    /**
     * 初始化概率区间
     * @param strategyId
     * @param strategyMode
     * @param awardRateInfoList
     */
    @Override
    protected void doInit(Long strategyId, Integer strategyMode, List<AwardRateVO> awardRateInfoList) {
        // 数据验证
        if (awardRateInfoList == null || awardRateInfoList.isEmpty()) {
            throw new IllegalArgumentException("策略ID: " + strategyId + " 的奖品概率列表不能为空");
        }
        
        // 验证概率总和是否为1
        BigDecimal totalRate = awardRateInfoList.stream()
                .map(AwardRateVO::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        if (totalRate.subtract(BigDecimal.ONE).abs().compareTo(new BigDecimal("0.01")) > 0) {
            throw new IllegalArgumentException("策略ID: " + strategyId + " 的概率总和不等于1，当前总和: " + totalRate);
        }
        
        // 创建100个桶的数组
        String[] buckets = new String[DEFAULT_BUCKET_SIZE];
        int currentIndex = 0;
        
        // 遍历奖品信息列表，取出每一个奖品的概率
        for(AwardRateVO awardRateVO : awardRateInfoList){
            String awardId = awardRateVO.getAwardId();
            BigDecimal awardRate = awardRateVO.getAwardRate();

            //计算这个奖品要占用多少个桶
            // 如果这个奖品中奖概率是0.1，那就是0.1 * 100 = 10个桶
            int expectedBucket = awardRate.multiply(new BigDecimal(DEFAULT_BUCKET_SIZE)).intValue();

            //把奖品ID填充到对应数量的桶里面去
            for(int i=0;i<expectedBucket && currentIndex<DEFAULT_BUCKET_SIZE;i++){
                buckets[currentIndex] = awardId;
                currentIndex++;
            }
        }
        // 如果还有剩余桶位（由于精度问题），用最后一个奖品填满
        if (currentIndex < DEFAULT_BUCKET_SIZE && !awardRateInfoList.isEmpty()) {
            String lastAwardId = awardRateInfoList.get(awardRateInfoList.size() - 1).getAwardId();
            for (int i = currentIndex; i < DEFAULT_BUCKET_SIZE; i++) {
                buckets[i] = lastAwardId;
            }
        }
        // 线程安全地缓存桶数组
        bucketArrayMap.put(strategyId, buckets);
        //TODO:随机打乱bucketArrayMap
        //TODO:缓存到Redis里面
    }

    /**
     * 根据策略ID进行抽奖
     * @param strategyId 策略ID
     * @param excludeAwardIds 排除的奖品ID列表
     * @return 奖品id
     */
    @Override
    protected String doDraw(Long strategyId, List<String> excludeAwardIds) {
        // 根据策略ID获取对应的概率桶
        // TODO: 从redis里获取
        String[] rateBucket = bucketArrayMap.get(strategyId);
        
        // 空值检查
        if (rateBucket == null || rateBucket.length == 0) {
            return null;
        }
        
        String awardId;
        int attempts = 0;
        int maxAttempts = 100; // 防止无限循环，最多尝试100次
        
        // 使用循环代替递归，避免栈溢出
        do {
            // 使用线程安全的随机数生成器
            int randomNum = secureRandom.nextInt(DEFAULT_BUCKET_SIZE);
            awardId = rateBucket[randomNum];
            attempts++;
            
            // 如果尝试次数过多，直接返回当前奖品（避免死循环）
            if (attempts >= maxAttempts) {
                break;
            }
            
        } while (excludeAwardIds != null && excludeAwardIds.contains(awardId));
        
        return awardId;
    }
}
