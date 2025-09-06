package cn.itedus.lottery.common.enums;

import lombok.Getter;

/**
 * StrategyModeEnum
 *
 * @author yian.zhang
 * @since 2025/9/6
 */
@Getter
public enum StrategyModeEnum {

    SINGLE_RATE(1,"单项概率"),
    TOTAL_RATE(2,"总体概率");

    private final Integer code;
    private final String desc;

    StrategyModeEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

}
