package com.sbstudy.user;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userDto")
public class UserDto {

    private long seq;
    private String id;
    private String password;
    private String name;

}
