package com.demo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jieyingjian
 * @since 2019-07-31
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private String name;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
            "name=" + name +
            ", id=" + id +
            ", age=" + age +
        "}";
    }
}
