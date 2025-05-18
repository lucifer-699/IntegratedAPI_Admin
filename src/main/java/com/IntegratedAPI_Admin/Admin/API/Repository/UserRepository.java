package com.IntegratedAPI_Admin.Admin.API.Repository;


import com.IntegratedAPI_Admin.Admin.API.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    @Query (value = "Select * from users where userid: userid and username: username and password: password",nativeQuery = true){
        UserEntity validateuser(String)
    }

}
