package cn.tulingxueyuan.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class User {
    @NotNull(message = "id不能为空")
    @Min(value=1,message = "id必须大于0")
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 4,max = 8,message = "用户名的长度必须在{min}和{max}位之间")
    @Pattern(regexp="^[0-9a-zA-Z]+$",message = "用户名只能输入0-9或者a-z")
    private String username;
    @Past(message = "您难道穿越了吗？")
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;
    @NumberFormat(style = NumberFormat.Style.CURRENCY )   //货币
    private Double balance;   //余额  ￥5000
    private String[] hobbies;
    @NumberFormat(pattern = "#,###.##")
    @Range(min = 2000,max = 1000000,message = "工资必须在{min}和{max}之间")    //Size的范围是int 不能用于验证Double
    private Double salary; //工资  10,000.00
    @Range(min=0,max=100,message = "任务完成度必须在{min}和{max}之间")        //Range的范围是Long所以，Range可以控制的范围更大
    @NumberFormat(style = NumberFormat.Style.PERCENT)  /*不加%会 *100来显示   加上会按你提交精度来显示*/
    private Double taskCount;// 任务完成百分比 90%

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Double taskCount) {
        this.taskCount = taskCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", balance=" + balance +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", salary=" + salary +
                ", taskCount=" + taskCount +
                '}';
    }
}
