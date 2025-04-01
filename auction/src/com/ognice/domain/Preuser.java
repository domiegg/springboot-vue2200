package com.ognice.domain;

import java.util.Date;
/**
*
* 用户 实体类
*
**/
public class Preuser {
    private Long id;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nickname;

	public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String username;

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Date created;

	public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}