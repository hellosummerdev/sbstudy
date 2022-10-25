package com.sbstudy.user;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("userLoginDto")
public class UserLoginDto {
    private int seq;
    private String user_id;
    private String user_pwd;
    private String user_name;
    private boolean use_yn;
    private Date created_at;	 // java.util
    private Date modified_at;

}
