package com.java_practice_code.summer.service;


import com.java_practice_code.summer.annotation.Autowired;
import com.java_practice_code.summer.annotation.Service;
import com.java_practice_code.summer.dao.HomeDao;

/**
 * @author ljx
 */
@Service("homeServiceImpl")
public class HomeServiceImpl implements HomeService {
    @Autowired("homeDaoImpl")
    private HomeDao homeDao;


    @Override
    public void index() {
        System.out.println("execute HomeServiceImpl.index()");
        System.out.println(homeDao.getWelcomeMsg());
    }
}
