package com.ab.book_store.repository;

import com.ab.book_store.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

      Optional<UserInfo> findByUserName(String userName);
}
