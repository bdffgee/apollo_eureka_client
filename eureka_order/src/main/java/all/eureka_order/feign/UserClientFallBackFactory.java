package all.eureka_order.feign;

import all.common.model.UserModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * className UserClientFallBackFactory
 *
 * @author 电脑
 * @date 2021/7/30 0:09
 */
@Component
public class UserClientFallBackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new IUserClient() {
            @Override
            public String testQuery(Integer uid) {
                return "UserClientFallBackFactory工厂产出的fallback"+uid;
            }

            @Override
            public UserModel queryModel(Integer uid) {
                return null;
            }
        };
    }
}
