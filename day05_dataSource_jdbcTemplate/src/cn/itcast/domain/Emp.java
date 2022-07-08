package cn.itcast.domain;

import java.util.Date;

/**
 * @Classname Emp
 * @Date 2022/6/28 22:17
 * @Created by 李晓阳
 */

public class Emp {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private Date join_date;
    private int dept_id;

    public Emp() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", join_date=" + join_date +
                ", dept_id=" + dept_id +
                '}';
    }

    public Emp(int id, String name, String gender, double salary, Date join_date, int dept_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.join_date = join_date;
        this.dept_id = dept_id;
    }
}
