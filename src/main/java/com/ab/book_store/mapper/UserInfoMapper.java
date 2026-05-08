package com.ab.book_store.mapper;

import com.ab.book_store.dto.UserInfoDto;
import com.ab.book_store.entity.UserInfo;

public class UserInfoMapper {

    public static UserInfoDto toDto(UserInfo userInfo){

        return new UserInfoDto(userInfo.getUserId(),userInfo.getUserName(),userInfo.getPassword(),userInfo.getRole());
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto){

        return new UserInfo(userInfoDto.getUserId(),userInfoDto.getUserName(),userInfoDto.getPassword(),userInfoDto.getRole());
    }
}
