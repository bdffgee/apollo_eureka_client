package all.eureka_order.feign;

import all.common.model.UserModel;
import org.springframework.stereotype.Component;

/**
 * className UserClientFallBack
 * 熔断反馈界面
 * @author 电脑
 * @date 2021/7/29 23:01
 */
@Component
public class UserClientFallBack implements IUserClient {
    @Override
    public String testQuery(Integer uid) {
        return "UserClientFallBack(看到这个就说明熔断了)---返回的字符串"+uid;
    }

    @Override
    public UserModel queryModel(Integer uid) {
        return null;
    }
}
