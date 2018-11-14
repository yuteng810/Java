package edu.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String realName;
    private String address;
    private String mobile;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o){
            return true;
        }
        if (o==null){
            return  false;
        }
        if (getClass()!=o.getClass()){
            return false;
        }
        Customer other= (Customer) o;

        if (id==null){
            if (other.id!=null){
                return false;
            }
            else if (!id.equals(other.id)){
                return false;
            }
            return true;

        }

    }
}
