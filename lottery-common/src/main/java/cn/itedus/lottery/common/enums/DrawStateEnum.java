package cn.itedus.lottery.common.enums;

import lombok.Getter;

/**
 * @Auther: zhangyian
 * @Date: 2025/9/7 20:35
 * @Description: 抽奖状态枚举
 */
@Getter
public enum DrawStateEnum {

    /**
     * 未中奖
     */
    FAIL(0,"未中奖"),

    /**
     * 已中奖
     */
    SUCCESS(1, "已中奖"),

    /**
     * 兜底奖
     */
    Cover(2,"兜底奖");

    private Integer code;
    private String info;

    DrawStateEnum(Integer code, String info) {
        this.code = code;
        this.info = info;
    }
}
