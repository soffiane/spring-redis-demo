package com.boudissa.springredisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(timeToLive = 30)
public class Product implements Serializable {
    @Id
    private Long id;
    private String name;
    private double price;
}
