package all.eureka_order.controller;

import all.eureka_order.feign.IUserClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * className OrderController
 * Instance:实例  Template:模板,样本
 * @author 电脑
 * @date 2021/7/27 17:29
 */
@RestController
public class OrderController {

    @Resource
    EurekaClient eurekaClient;
    @Resource
    IUserClient iUserClient;

    @GetMapping("/query/{oid}")
    public String query(@PathVariable Integer oid){
        Application application = eurekaClient.getApplication("APOLLOUSER");
        List<InstanceInfo> list = application.getInstances();
        InstanceInfo instanceInfo = list.get(0);
        String host = instanceInfo.getHostName(); //ip地址
        int port = instanceInfo.getPort();  //端口号
        String url="http://"+host+":"+port+"/query/"+oid;
        RestTemplate restTemplate = new RestTemplate();
        String userStr = restTemplate.getForObject(url, String.class);
        return "我是订单模块{"+oid+"} ====获得apollo_user的返回值:"+userStr;
    }
//OpenFeign省略了查询另一个服务的ip地址,直接去服务上去查找调用
    @GetMapping("/feignQuery/{uid}")
   /* @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
    })*/
    public String feignQuery(@PathVariable Integer uid){
        String str = iUserClient.testQuery(uid);
        return "OpenFeign订单里调用的:"+str;
    }

    public String fallback(Integer oid){
        return "熔断发生了,请您自保吧---order发送";
    }

}
