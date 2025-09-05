package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.UserTakeActivityCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户活动参与次数表Dao
 * @author: 小傅哥，微信：fustack
 * @date: 2021/10/1
 * @github: https://github.com/fuzhengwei
 * @Copyright: 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Mapper
public interface IUserTakeActivityCountDao extends BaseMapper<UserTakeActivityCount> {

}
