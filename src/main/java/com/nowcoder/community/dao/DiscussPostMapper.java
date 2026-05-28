package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    /**
     * 分页查询帖子列表，userId=0查全部帖子，！=0查对应用户id的帖子
     * @param userId
     * @param offset 偏移量（当前页起始位置，公式：offset = (当前页-1) * 每页条数）
     * @param limit 每页显示的帖子数量
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param注解用于给参数取别名,

    /**
     *
     * @param userId 同样用于筛选 “某用户的帖子总数”，如果是查全站帖子则传 0
     *               主要是为了计算最大分页数
     * @return
     */
    //即使只有一个参数，但#{userId}在<if>里
    //原因：MyBatis 编译时，会把单个参数的方法名参数名优化掉，变成 arg0 或 param1，
    // 动态 SQL 的 <if test="userId != null"> 找不到 userId 这个参数，就直接崩了
    int selectDiscussPostRows(@Param("userId") int userId);

}
