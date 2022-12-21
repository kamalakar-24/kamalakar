package com.test.Books.FeignServiceUtil;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value="STUDENTS")
public class StudentLoadBalancer {
	
	@LoadBalanced
	
	@Bean
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}

}
