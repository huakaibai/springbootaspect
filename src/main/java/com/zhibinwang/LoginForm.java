package com.zhibinwang;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhibin.wang
 * @create 2019-10-31 10:14
 * @desc
 **/
@Data
public class LoginForm {

    //分组校验
    @NotNull( groups = {GroupA.class},message = "id不能为空")
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    @Email
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6,message = "密码长度最少6位")
    private String password;

    @NotBlank(message = "手机号不能为空")
    @Phone
    private String phone;
}
