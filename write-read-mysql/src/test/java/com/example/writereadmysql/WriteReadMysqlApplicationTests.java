package com.example.writereadmysql;

import com.alibaba.fastjson.JSON;
import com.example.writereadmysql.datasource.DataSourceConfig;
import com.example.writereadmysql.entity.Agency;
import com.example.writereadmysql.mapper.AgencyMapper;
import com.example.writereadmysql.service.AgencyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WriteReadMysqlApplicationTests {

    @Autowired
    AgencyService agencyService;

    @Test
    public void contextLoads() {

        Agency agency = new Agency();

        agency.setName("jack-finsihed");
        agency.setAboutUs("cbout me");
        agency.setEmail("xxxxx@qq.com");
        agency.setAddress("china");
        agency.setMobile("12312341234");
        agency.setWebSite("www.xxx.com");

        agencyService.insertMaster(agency);
        agencyService.insertSlave(agency);

        System.out.println("finished");
    }


}
