package all.eureka_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*@SpringBootApplication
@EnableEurekaClient*/
@EnableFeignClients
@SpringCloudApplication
@EnableCircuitBreaker //Hystrix
public class EurekaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderApplication.class, args);
    }

}
