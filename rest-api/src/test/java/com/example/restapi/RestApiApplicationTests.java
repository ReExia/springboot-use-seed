package com.example.restapi;

import com.example.restapi.mapper.AgencyMapper;
import com.example.restapi.vo.Agency;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiApplicationTests {


    @Autowired
    AgencyMapper agencyMapper;

    /**
     * 分页示例
     */
    @Test
    public void pageExample() {
        PageHelper.startPage(0,1,true);
        List<Agency> agencyMappers = agencyMapper.selectAll();
        PageInfo<Agency> pageInfo = new PageInfo<Agency>(agencyMappers);
    }

}
