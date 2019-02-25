package com.example.restapi.common.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SysBaseMapper<T>
        extends BaseMapper<T>,
        MySqlMapper<T> {
}
