package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 存储字符串键值对
     * @param key
     * @param value
     * @return
     * @author zj
     * @date 2020年07月22日
     */
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key, value);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 得到对应键的字符串值
     * @param key
     * @return
     * @author zj
     * @date 2020年07月22日
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 删除字符串键值对
     * @param key
     * @return
     * @author zj
     * @date 2020年07月22日
     */
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.del(key);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 存储对象
     * @param key
     * @param value
     * @return
     * @author zj
     * @date 2020年07月22日
     */
    public String setObject(String key, Object value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key.getBytes(), ObjectUtil.serialize(value));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 得到对应键的对象
     * @param key
     * @return
     * @author zj
     * @date 2020年07月22日
     */
    public Object getObject(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            byte[] byteArr =  jedis.get(key.getBytes());
            return ObjectUtil.unSerialize(byteArr);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取jedis对象
     * @param
     * @return
     * @author zj
     * @date 2020年07月22日
     */
    public Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
}