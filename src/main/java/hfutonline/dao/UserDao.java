package hfutonline.dao;

import org.apache.ibatis.annotations.*;
import java.util.List;
import hfutonline.dao.dynamicSQLProvider.DynamicSQLProvider;
import hfutonline.entity.User;

/**
 * Created by lenovo on 2017/9/11.
 */


@Mapper
public interface UserDao {


        @Select("select * from user where id=#{id}")
        @Results({
                @Result(property = "id", column = "id"),
                @Result(property = "userName", column = "userName"),
                @Result(property = "password", column = "password"),
                @Result(property = "phoneNumber", column = "phoneNumber"),
                @Result(property = "qq", column = "qq")
        })
        User queryById(@Param("id") Integer id);


        @Select("select * from user where userName=#{userName}")
        @Results({
                @Result(property = "id", column = "id"),
                @Result(property = "userName", column = "userName"),
                @Result(property = "password", column = "password"),
                @Result(property = "phoneNumber", column = "phoneNumber"),
                @Result(property = "qq", column = "qq")
        })
        User queryByUserName(@Param("userName") String userName);

        /**
         * 添加一个学生对象
         * add:(这里用一句话描述这个方法的作用). <br/>
         * TODO(这里描述这个方法适用条件 – 可选).<br/>
         * TODO(这里描述这个方法的执行流程 – 可选).<br/>
         * TODO(这里描述这个方法的使用方法 – 可选).<br/>
         * TODO(这里描述这个方法的注意事项 – 可选).<br/>
         *
         * @author huangting
         * @param user
         * @return
         * @since JDK 1.8
         */
        @Insert("insert ignore into user(userName,phoneNumber,qq) values(#{user.userName}, #{user.phoneNumber}, #{user.qq})")
        Integer add(@Param("user") User user);

        /**
         * 学生列表
         * listAll:(这里用一句话描述这个方法的作用). <br/>
         * TODO(这里描述这个方法适用条件 – 可选).<br/>
         * TODO(这里描述这个方法的执行流程 – 可选).<br/>
         * TODO(这里描述这个方法的使用方法 – 可选).<br/>
         * TODO(这里描述这个方法的注意事项 – 可选).<br/>
         *
         * @author huangting
         * @return
         * @since JDK 1.8
         */
        @Select("select id, userName, phoneNumber, qq from user")
        @Results({
                @Result(property = "id", column = "id"),
                @Result(property = "userName", column = "userName"),
                @Result(property = "phoneNumber", column = "phoneNumber"),
                @Result(property = "qq", column = "qq"),
        })
        List<User> listAll();

        /**
         * 根据学生ID号删除学生
         * deleteById:(这里用一句话描述这个方法的作用). <br/>
         * TODO(这里描述这个方法适用条件 – 可选).<br/>
         * TODO(这里描述这个方法的执行流程 – 可选).<br/>
         * TODO(这里描述这个方法的使用方法 – 可选).<br/>
         * TODO(这里描述这个方法的注意事项 – 可选).<br/>
         *
         * @author huangting
         * @param id
         * @return
         * @since JDK 1.8
         */
        @Delete("delete from user where id=#{id}")
        Integer deleteById(@Param("id") Integer id);

        /**
         * 更新学生信息
         * update:(这里用一句话描述这个方法的作用). <br/>
         * TODO(这里描述这个方法适用条件 – 可选).<br/>
         * TODO(这里描述这个方法的执行流程 – 可选).<br/>
         * TODO(这里描述这个方法的使用方法 – 可选).<br/>
         * TODO(这里描述这个方法的注意事项 – 可选).<br/>
         *
         * @author huangting
         * @param user
         * @return
         * @since JDK 1.8
         */
        @UpdateProvider(type = DynamicSQLProvider.class, method = "update")
        Integer update(@Param("user") User user);


}
