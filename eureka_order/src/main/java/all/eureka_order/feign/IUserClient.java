package all.eureka_order.feign;
import all.common.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * className IUserClient
 * Feign:假装,伪装
 * Spring Cloud OpenFeign
 * @author 电脑
 * @date 2021/7/28 15:49
 */

//去注册中心(eureka)寻找xxx名字的服务
//@FeignClient(name = "APOLLOUSER",fallback = UserClientFallBack.class)
@FeignClient(name = "APOLLOUSER",fallbackFactory = UserClientFallBackFactory.class)
public interface IUserClient {

    @GetMapping("/query/{uid}")
    String testQuery(@PathVariable("uid") Integer uid);

    @GetMapping("/queryModel/{uid}")
    UserModel queryModel(@PathVariable("uid") Integer uid);
}
