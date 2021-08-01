package all.apollo_user.controller;

import all.apollo_user.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * className UserController
 *
 * @author 电脑
 * @date 2021/7/27 17:25
 */
@RestController
public class UserController {

    @GetMapping("/query/{uid}")
    public String query(@PathVariable Integer uid){
        if (uid==1){
            int num=1/0;
        }else if (uid==2){
            try {
                Thread.sleep(54000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello Spring Cloud 我是用户模块"+uid+"我的端口号是[8092]";
    }
    @GetMapping("/queryModel/{uid}")
    public UserModel queryModel(@PathVariable("uid") Integer uid){
        return new UserModel(uid,25,"大宝贝");
    }


}
