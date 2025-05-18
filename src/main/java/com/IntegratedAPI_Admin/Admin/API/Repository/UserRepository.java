package com.IntegratedAPI_Admin.Admin.API.Repository;


import com.IntegratedAPI_Admin.Admin.API.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "SELECT cast(user_id AS varchar(10)),username,password_hash FROM groupapi.users WHERE user_id = cast(:userid as integer) AND username = :username AND password_hash = :password", nativeQuery = true)
    UserEntity validateUser(@Param("userid") String userid,
                            @Param("username") String username,
                            @Param("password") String password);
}


