package com.ric.netctoss.service;

import com.ric.netctoss.entity.AdminInfo;

public interface AdminInfoService {

    AdminInfo login(String username, String password);

}
