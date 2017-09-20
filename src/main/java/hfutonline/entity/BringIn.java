package hfutonline.entity;

import java.util.Date;

/**
 * Created by lenovo on 2017/9/11.
 */
public class BringIn {

    private Integer id;
    private String name;
    private Integer people;
    private Date time;
    private String title;
    private String type;
    private String location;
    private String worktime;
    private String workplace;
    private String pay;
    private String deadline;
    private String sex;
    private String grade;
    private String place;
    private String need;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Integer getPeople(){
        return people;
    }

    public void setPeople(Integer people){
        this.people=people;
    }

    public Date getTime(){
        return time;
    }

    public void setTime(Date time){
        this.time=time;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public String getWorktime(){
        return worktime;
    }

    public void setWorktime(String worktime){
        this.worktime=worktime;
    }

    public String getWorkplace(){
        return workplace;
    }

    public void setWorkplace(String workplace){
        this.workplace=workplace;
    }

    public String getPay(){
        return pay;
    }

    public void setPay(String pay){
        this.pay=pay;
    }

    public String getDeadline(){
        return deadline;
    }

    public void setDeadline(String deadline){
        this.deadline=deadline;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex=sex;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }

    public String getPlace(){
        return place;
    }

    public void setPlace(String place){
        this.place=place;
    }

    public String getNeed(){
        return need;
    }

    public void setNeed(String need){
        this.need=need;
    }

    @Override
    public String toString() {
        return "BringIn[id=" + id + " , name=" + name + " , people="+people+",time="+time+",title="+title+",type="+type+"," +
                "location="+location+",worktime="+worktime+",workplace="+workplace+",pay="+pay+",deadline="+deadline+",sex="
                +sex+",grade="+grade+",place="+place+",need="+need+"]";
    }
}
