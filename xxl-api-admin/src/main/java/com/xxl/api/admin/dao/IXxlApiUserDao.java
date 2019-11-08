package com.xxl.api.admin.dao;

import com.xxl.api.admin.core.model.BlueStarUserProfileDTO;
import com.xxl.api.admin.core.model.XxlApiUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuxueli on 17/3/29.
 */
@Mapper
public interface IXxlApiUserDao {

    public int add(XxlApiUser xxlApiUser);

    public int update(XxlApiUser xxlApiUser);

    public int delete(@Param("id") int id);

    public XxlApiUser findByUserName(@Param("userName") String userName);

    public XxlApiUser findById(@Param("id") int id);
    
    public XxlApiUser findByPid(@Param("pid") String pid);

    public List<XxlApiUser> loadAll();

    public List<XxlApiUser> pageList(@Param("offset") int offset,
                                        @Param("pagesize") int pagesize,
                                        @Param("userName") String userName,
                                        @Param("type") int type);
    public int pageListCount(@Param("offset") int offset,
                             @Param("pagesize") int pagesize,
                             @Param("userName") String userName,
                             @Param("type") int type);
    /**
     * 绑定Pid
     * @param user
     */
	public void setPid(XxlApiUser user);
    
}
