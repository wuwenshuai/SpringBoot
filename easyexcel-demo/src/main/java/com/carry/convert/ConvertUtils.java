package com.carry.convert;


import org.springframework.beans.BeanUtils;

public class ConvertUtils {

    // entity -> dto
    public Object entityToDto(Object entity, Object dto) {
        if (entity == null) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    // entity -> vo
    public Object entityToVo(Object entity, Object vo) {
        if (entity == null) {
            return null;
        }
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }



}
