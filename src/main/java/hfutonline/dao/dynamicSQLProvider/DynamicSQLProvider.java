package hfutonline.dao.dynamicSQLProvider;

import hfutonline.entity.User;
import hfutonline.entity.BringIn;
import org.apache.ibatis.jdbc.SQL;

/**
 * 提供动态SQL
 * ClassName: DynamicSQLProvider <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 *
 * @author Jessie
 * @version  
 * @since JDK 1.8
 */
public class DynamicSQLProvider {
    /*
	public String update(User user){
        return new SQL() {
        	{  
                UPDATE("user");
                if (user.getUserName() != null)
                {  
                    SET("userName = #{user.userName}");
                }
                if (user.getPhoneNumber() != null)
                {  
                    SET("phoneNumber = #{user.phoneNumber}");
                }  
                if (user.getQq() != null)
                {  
                    SET("qq = #{user.qq}");
                }  
                if (user.getPassword() != null)
                {  
                    SET("password = #{user.password}");
                }  
                WHERE("id = #{user.id}");
            }  
        }.toString();
                
    }
    */
    public String update(BringIn bringIn){
	    return new SQL(){
            {
                UPDATE("bringIn");
                if (bringIn.getName()!=null){
                    SET("name=#{bringIn.name}");
                }
                if (bringIn.getDeadline()!=null){
                    SET("deadline=#{bringIn.deadline}");
                }
                if (bringIn.getGrade()!=null){
                    SET("grade=#{bringIn.grade}");
                }
                if (bringIn.getLocation()!=null){
                    SET("location=#{bringIn.location}");
                }
                if (bringIn.getNeed()!=null){
                    SET("need=#{bringIn.need}");
                }
                if (bringIn.getPay()!=null){
                    SET("pay=#{bringIn.pay}");
                }
                if (bringIn.getPeople()!=null){
                    SET("people=#{bringIn.people}");
                }
                if (bringIn.getPlace()!=null){
                    SET("place=#{bringIn.place}");
                }
                if (bringIn.getSex()!=null){
                    SET("sex=#{bringIn.sex}");
                }
                if (bringIn.getTime()!=null){
                    SET("time=#{bringIn.time}");
                }
                if (bringIn.getTitle()!=null){
                    SET("title=#{bringIn.title}");
                }
                if (bringIn.getType()!=null){
                    SET("type=#{bringIn.type}");
                }
                if (bringIn.getWorkplace()!=null){
                    SET("workplace=#{bringIn.workplace}");
                }
                if (bringIn.getWorktime()!=null){
                    SET("worktime=#{bringIn.worktime}");
                }
                WHERE("id=#{bringIn.id}");
            }
        }.toString();
    }
}
