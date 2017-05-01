package com.hhh.fangusa.dao;

import com.hhh.fangusa.model.search.ResourceSearch;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

public interface ResourceMapper {

    int deleteByIds(List<Long> ids);

    int deleteById(Long id);

    int insert(Resource record);

    int update(Resource record);

    List<Resource> select(ResourceSearch search);

    Resource selectById(Long id);

    int multiInsert(@Param("records") List<Resource> records);

    int multiUpdate(List<Resource> records);

}