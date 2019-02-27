package com.example.writereadmysql.mapper;

import com.example.writereadmysql.common.mapper.SysBaseMapper;
import com.example.writereadmysql.entity.Agency;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgencyMapper extends SysBaseMapper<Agency> {
}
