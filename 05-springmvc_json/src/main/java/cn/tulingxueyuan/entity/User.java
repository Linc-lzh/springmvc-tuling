package cn.tulingxueyuan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class User {
    private Integer id;
    private String name;
    @JsonIgnore    // 当返回javaBean 的json时 会忽略该属性
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")   // 用户转换json时格式化数据   JsonFormat和DateTimeFormat只需要设置一个可以了
    private Date birthady;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthady() {
        return birthady;
    }

    public void setBirthady(Date birthady) {
        this.birthady = birthady;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthady=" + birthady +
                '}';
    }

    public User() {
    }

    public User(Integer id, String name, String password, Date birthady) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthady = birthady;
    }
}
