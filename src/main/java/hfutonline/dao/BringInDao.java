package hfutonline.dao;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import java.util.List;
import hfutonline.dao.dynamicSQLProvider.DynamicSQLProvider;
import hfutonline.entity.BringIn;
/**
 * Created by lenovo on 2017/9/12.
 */
@Mapper
public interface BringInDao {

    @Select("select * from bringin where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "time", column = "time"),
            @Result(property = "title", column = "title"),
            @Result(property = "type", column = "type"),
            @Result(property = "location", column = "location"),
            @Result(property = "worktime", column = "worktime"),
            @Result(property = "workplace", column = "workplace"),
            @Result(property = "pay", column = "pay"),
            @Result(property = "people", column = "people"),
            @Result(property = "deadline", column = "deadline"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "play", column = "play"),
            @Result(property = "need", column = "need"),
    })
   List<BringIn> listBringInById(@Param("id") Integer id);

    @Select("select count(*) from bringin")
    Integer total();

    @Select("select * from bringin order by id desc limit(start=#{start},count=#{count})")
    List<BringIn> page(Integer start, Integer count);


    /*@Select("select * from bringin where userName=#{userName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNumber", column = "phoneNumber"),
            @Result(property = "qq", column = "qq")
    })
    User queryByUserName(@Param("userName") String userName);
    */

    /**
     * listAll
     */
    @Select("select * from bringin")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "time", column = "time"),
            @Result(property = "title", column = "title"),
            @Result(property = "type", column = "type"),
            @Result(property = "location", column = "location"),
            @Result(property = "worktime", column = "worktime"),
            @Result(property = "workplace", column = "workplace"),
            @Result(property = "pay", column = "pay"),
            @Result(property = "people", column = "people"),
            @Result(property = "deadline", column = "deadline"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "play", column = "play"),
            @Result(property = "need", column = "need"),
    })
    List<BringIn> listAll();

    /**
     * 添加一个bringin对象
     *
     * @author Jessie
     * @param bringIn
     * @return
     * @version JDK1.8
     */
    @Insert("insert ignore into bringin(name,time,title,type,location,worktime,workplace,pay,people,deadline,sex,grade,place,need) values(#{bringIn.name}, #{bringIn.time}, #{bringIn.title},#{bringIn.type}, #{bringIn.location}, #{bringIn.worktime}, #{bringIn.workplace}, #{bringIn.pay}, #{bringIn.people},#{bringIn.deadline}, #{bringIn.sex}, #{bringIn.grade}, #{bringIn.place}, #{bringIn.need})")
    Integer add(@Param("bringIn") BringIn bringIn);

    /**
     * delete
     * @author Jessie
     * @return
     */
    @Delete("delete from bringin where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

    /**
     * update
     */
    @UpdateProvider(type = DynamicSQLProvider.class, method = "update")
    Integer update(@Param("bringIn") BringIn bringIn);


}
