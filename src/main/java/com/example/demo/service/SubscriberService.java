/**
 * 
 */
package com.example.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.example.demo.entiry.Joke;

/**
 * @author balaj
 *
 *The subscriber side is relatively very simple. 
 *Here we just print the value on the console by subscribing (listening) to the channel. 
 *We can include multiple channel names.
 */
@Service
public class SubscriberService {
	
	@Autowired
    private ReactiveRedisOperations<String, Joke> reactiveRedisTemplate;

    @Value("${topic.name:joke-channel}")
    private String topic;

    @PostConstruct
    private void init(){
        this.reactiveRedisTemplate
                .listenTo(ChannelTopic.of(topic))
                .map(ReactiveSubscription.Message::getMessage)
                .subscribe(System.out::println);
    }

}
