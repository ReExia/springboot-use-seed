package com.example.writereadmysql.service;

import com.example.writereadmysql.annotations.CustomerDataSource;
import com.example.writereadmysql.entity.Agency;
import com.example.writereadmysql.enums.DataSourceEnum;
import com.example.writereadmysql.mapper.AgencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyService {

    @Autowired
    private AgencyMapper agencyMapper;

    @CustomerDataSource(value = DataSourceEnum.USER_MASTER)
    public Integer insertMaster(Agency agency){
        return agencyMapper.insertSelective(agency);
    }

    @CustomerDataSource(value = DataSourceEnum.USER_SLAVE)
    public Integer insertSlave(Agency agency){
        return agencyMapper.insertSelective(agency);
    }

}
