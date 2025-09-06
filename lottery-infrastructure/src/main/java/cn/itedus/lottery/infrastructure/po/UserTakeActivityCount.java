package cn.itedus.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 用户活动参与次数表
 * @author: 小傅哥，微信：fustack
 * @date: 2021/10/1
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
@TableName("`user_take_activity_count`")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTakeActivityCount {

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private String uId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 总计可领次数
     */
    private Integer totalCount;
    /**
     * 剩余领取次数
     */
    private Integer leftCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
