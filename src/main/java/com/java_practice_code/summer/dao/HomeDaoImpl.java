package com.java_practice_code.summer.dao;


import com.java_practice_code.summer.annotation.Repository;

/**
 * @author ljx
 */
@Repository("homeDaoImpl")
public class HomeDaoImpl implements HomeDao {
    @Override
    public String getWelcomeMsg() {
        System.out.println("execute HomeDaoImpl.getWelcomeMsg()");
        return "Welcome to Summer Framework";
    }
}
