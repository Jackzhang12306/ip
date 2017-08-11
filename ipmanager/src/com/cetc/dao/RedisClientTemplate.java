/*package com.cetc.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

public class RedisClientTemplate {
//	private static final org.slf4j.Logger log=LoggerFactory.getLogger(RedisClientTemplate.class);  
    
    @Autowired  
    private RedisDataSource redisDataSource;  
  
    public RedisDataSource getRedisDataSource() {  
        return redisDataSource;  
    }  
  
    public void setRedisDataSource(RedisDataSource redisDataSource) {  
        this.redisDataSource = redisDataSource;  
    }  
      
    public void disconnect(){  
        ShardedJedis shardedJedis=redisDataSource.getRedisClient();  
        shardedJedis.disconnect();  
    }  
      
    *//** 
    * @Description: 在redis里设置单个值 
    * @author Mr.chen 
    * @date 2016-10-21 下午04:37:06 
     *//*  
    public String set(String key, String value){  
        String result=null;  
        ShardedJedis shardedJedis=redisDataSource.getRedisClient();  
        if(shardedJedis==null){  
            return result;  
        }  
        boolean broken=false;  
        try {  
            result=shardedJedis.set(key, value);  
        } catch (Exception e) {  
            broken=true;  
            e.printStackTrace();  
        }finally{  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
          
        return result;  
    }  
      
    *//** 
    * @Description: 获取redis单个值  
    * @author Mr.chen 
    * @date 2016-10-21 下午04:40:57 
     *//*  
    public String get(String key) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.get(key);  
  
        } catch (Exception e) {  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
      
    *//** 
    * @Description: 判断redis是否存在key 
    * @author Mr.chen 
    * @date 2016-10-21 下午04:41:39 
     *//*  
    public Boolean exists(String key) {  
        Boolean result = false;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.exists(key);  
        } catch (Exception e) {  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
      
    *//** 
    * @Description: 获取key返回存储值的类型  
    * @author Mr.chen 
    * @date 2016-10-21 下午04:42:08 
     *//*  
    public String type(String key) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.type(key);  
  
        } catch (Exception e) {  
           // //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
      
    *//** 
    * @Description: 在某段时间后实现 
    * @author Mr.chen 
    * @date 2016-10-21 下午04:43:25 
     *//*  
    public Long expire(String key, int seconds) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.expire(key, seconds);  
  
        } catch (Exception e) {  
          //  //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    *//** 
    * @Description: 在某个时间点失效  
    * @author Mr.chen 
    * @date 2016-10-21 下午04:43:40 
     *//*  
    public Long expireAt(String key, long unixTime) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.expireAt(key, unixTime);  
  
        } catch (Exception e) {  
          //  //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    *//** 
    * @Description: 以秒为单位，返回给定 key 的剩余生存时间 
    * @author Mr.chen 
    * @date 2016-10-21 下午04:44:00 
     *//*  
    public Long ttl(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.ttl(key);  
  
        } catch (Exception e) {  
           // //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    *//** 
    * @Description: 将 key 的值设为 value ，当且仅当 key 不存在 
    * @author Mr.chen 
    * @date 2016-10-21 下午04:44:17 
     *//*  
    public Long setnx(String key, String value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.setnx(key, value);  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将值 value 关联到 key ，并将 key 的生存时间设为 seconds (以秒为单位) 
     * @param key 
     * @param seconds 
     * @param value 
     * @return 
     *//*  
    public String setex(String key, int seconds, String value) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.setex(key, seconds, value);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将 key 所储存的值减去减量 integer  
     * @param key 
     * @param integer 
     * @return 
     *//*  
    public Long decrBy(String key, long integer) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.decrBy(key, integer);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将 key 中储存的数字值减一。 
     * @param key 
     * @return 
     *//*  
    public Long decr(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.decr(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将 key 所储存的值加上增量 integer  
     * @param key 
     * @param integer 
     * @return 
     *//*  
    public Long incrBy(String key, long integer) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.incrBy(key, integer);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将 key 中储存的数字值增一 
     * @param key 
     * @return 
     *//*  
    public Long incr(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.incr(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。 
     * 如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样。 
     * @param key 
     * @param value 
     * @return 
     *//*  
    public Long append(String key, String value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.append(key, value);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回名称为key的string的value的子串 
     * @param key 
     * @param start 
     * @param end 
     * @return 
     *//*  
    public String substr(String key, int start, int end) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.substr(key, start, end);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将哈希表 key 中的域 field 的值设为 value  
     * @param key 
     * @param field 
     * @param value 
     * @return 
     *//*  
    public Long hset(String key, String field, String value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hset(key, field, value);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回哈希表 key 中给定域 field 的值 
     * @param key 
     * @param field 
     * @return 
     *//*  
    public String hget(String key, String field) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hget(key, field);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中。 
     * @param key 
     * @param hash 
     * @return 
     *//*  
    public String hmset(String key, Map<String, String> hash) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hmset(key, hash);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回哈希表 key 中，一个或多个给定域的值 
     * @param key 
     * @param fields 
     * @return 
     *//*  
    public List<String> hmget(String key, String... fields) {  
        List<String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hmget(key, fields);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 为哈希表 key 中的域 field 的值加上增量 value 
     * @param key 
     * @param field 
     * @param value 
     * @return 
     *//*  
    public Long hincrBy(String key, String field, long value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hincrBy(key, field, value);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 查看哈希表 key 中，给定域 field 是否存在。 
     * @param key 
     * @param field 
     * @return 
     *//*  
    public Boolean hexists(String key, String field) {  
        Boolean result = false;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hexists(key, field);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 删除key 
     * @param key 
     * @return 
     *//*  
    public Long del(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.del(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 删除哈希表 key 中的一个或多个指定域。 
     * @param key 
     * @param field 
     * @return 
     *//*  
    public Long hdel(String key, String field) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hdel(key, field);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回哈希表 key 中域的数量。 
     * @param key 
     * @return 
     *//*  
    public Long hlen(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hlen(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回哈希表 key 中的所有域。 
     * @param key 
     * @return 
     *//*  
    public Set<String> hkeys(String key) {  
        Set<String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hkeys(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回哈希表 key 中所有域的值。 
     * @param key 
     * @return 
     *//*  
    public List<String> hvals(String key) {  
        List<String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hvals(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
     *//** 
      * 返回哈希表 key 中，所有的域和值。 
      * @param key 
      * @return 
      *//*  
    public Map<String, String> hgetAll(String key) {  
        Map<String, String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.hgetAll(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    // ================list ====== l表示 list或 left, r表示right====================  
    *//** 
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边) 
     * @param key 
     * @param string 
     * @return 
     *//*  
    public Long rpush(String key, String string) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.rpush(key, string);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将一个或多个值 value 插入到列表 key 的表头 
     * @param key 
     * @param string 
     * @return 
     *//*  
    public Long lpush(String key, String string) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.lpush(key, string);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回列表 key 的长度。 
     * @param key 
     * @return 
     *//*  
    public Long llen(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.llen(key);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
     *//** 
      * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定 
      * @param key 
      * @param start 
      * @param end 
      * @return 
      *//*  
    public List<String> lrange(String key, long start, long end) {  
        List<String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.lrange(key, start, end);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 只保留指定区间内的元素，不在指定区间之内的元素都将被删除 
     * @param key 
     * @param start 
     * @param end 
     * @return 
     *//*  
    public String ltrim(String key, long start, long end) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.ltrim(key, start, end);  
  
        } catch (Exception e) {  
//            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回列表 key 中，下标为 index 的元素。 
     * @param key 
     * @param index 
     * @return 
     *//*  
    public String lindex(String key, long index) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.lindex(key, index);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将列表 key 下标为 index 的元素的值设置为 value 
     * @param key 
     * @param index 
     * @param value 
     * @return 
     *//*  
    public String lset(String key, long index, String value) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.lset(key, index, value);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
  *//** 
   * 移除并返回列表 key 的头元素 
   * @param key 
   * @return 
   *//*  
    public String lpop(String key) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.lpop(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 移除并返回列表 key 的尾元素。 
     * @param key 
     * @return 
     *//*  
    public String rpop(String key) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.rpop(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    //return 1 add a not exist value ,  
    //return 0 add a exist value  
    *//** 
     * 将一个或多个 member 元素加入到集合 key 当中 
     * @param key 
     * @param member 
     * @return 
     *//*  
    public Long sadd(String key, String member) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.sadd(key, member);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回集合 key 中的所有成员。 
     * @param key 
     * @return 
     *//*  
    public Set<String> smembers(String key) {  
        Set<String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.smembers(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    *//** 
     * 返回集合 key 的基数(集合中元素的数量) 
     * @param key 
     * @return 
     *//*  
    public Long scard(String key) {  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        Long result = null;  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.scard(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中 
     * @param key 
     * @param score 
     * @param member 
     * @return 
     *//*  
    public Long zadd(String key, double score, String member) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.zadd(key, score, member);  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回有序集 key 中，指定区间内的成员 
     * @param key 
     * @param start 
     * @param end 
     * @return 
     *//*  
    public Set<String> zrange(String key, int start, int end) {  
        Set<String> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.zrange(key, start, end);  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略 
     * @param key 
     * @param member 
     * @return 
     *//*  
    public Long zrem(String key, String member) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.zrem(key, member);  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 为有序集 key 的成员 member 的 score 值加上增量 member 。 
     * @param key 
     * @param score 
     * @param member 
     * @return 
     *//*  
    public Double zincrby(String key, double score, String member) {  
        Double result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zincrby(key, score, member);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列 
     * @param key 
     * @param member 
     * @return 
     *//*  
    public Long zrank(String key, String member) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zrank(key, member);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回有序集 key 的基数 
     * @param key 
     * @return 
     *//*  
        public Long zcard(String key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zcard(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 返回有序集 key 中，成员 member 的 score 值。 
     * @param key 
     * @param member 
     * @return 
     *//*  
    public Double zscore(String key, String member) {  
        Double result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zscore(key, member);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
   *//** 
    * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量 
    * @param key 
    * @param min 
    * @param max 
    * @return 
    *//*  
    public Long zcount(String key, double min, double max) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zcount(key, min, max);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    *//** 
     * 批量存储 
     * @param key 
     * @param value 
     * @return 
     *//*  
    public String set(byte[] key, byte[] value) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.set(key, value);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 获取多个key的值 
     * @param key 
     * @return 
     *//*  
    public byte[] get(byte[] key) {  
        byte[] result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.get(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 判断多个key存在 
     * @param key 
     * @return 
     *//*  
    public Boolean exists(byte[] key) {  
        Boolean result = false;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.exists(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long expire(byte[] key, int seconds) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.expire(key, seconds);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long expireAt(byte[] key, long unixTime) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.expireAt(key, unixTime);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long ttl(byte[] key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.ttl(key);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long append(byte[] key, byte[] value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.append(key, value);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
   *//** 
    * 批量增加到hash 
    * @param key 
    * @param field 
    * @param value 
    * @return 
    *//*  
    public Long hset(byte[] key, byte[] field, byte[] value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.hset(key, field, value);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 批量获取field域值 
     * @param key 
     * @param field 
     * @return 
     *//*  
    public byte[] hget(byte[] key, byte[] field) {  
        byte[] result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.hget(key, field);  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public String hmset(byte[] key, Map<byte[], byte[]> hash) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.hmset(key, hash);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public List<byte[]> hmget(byte[] key, byte[]... fields) {  
        List<byte[]> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.hmget(key, fields);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
      
    public Boolean hexists(byte[] key, byte[] field) {  
        Boolean result = false;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.hexists(key, field);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    *//** 
     * 批量删除hash的key 
     * @param key 
     * @param field 
     * @return 
     *//*  
    public Long hdel(byte[] key, byte[] field) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.hdel(key, field);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    public Long rpush(byte[] key, byte[] string) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.rpush(key, string);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long lpush(byte[] key, byte[] string) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.lpush(key, string);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long llen(byte[] key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.llen(key);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public List<byte[]> lrange(byte[] key, int start, int end) {  
        List<byte[]> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.lrange(key, start, end);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
     
    public String lset(byte[] key, int index, byte[] value) {  
        String result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.lset(key, index, value);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
    public Long lrem(byte[] key, int count, byte[] value) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.lrem(key, count, value);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public byte[] lpop(byte[] key) {  
        byte[] result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.lpop(key);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public byte[] rpop(byte[] key) {  
        byte[] result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.rpop(key);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  *//** 
   *   批量增加到set 
   * @param key 
   * @param member 
   * @return 
   *//*  
    public Long sadd(byte[] key, byte[] member) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.sadd(key, member);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Set<byte[]> smembers(byte[] key) {  
        Set<byte[]> result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.smembers(key);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long scard(byte[] key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.scard(key);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Long zadd(byte[] key, double score, byte[] member) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zadd(key, score, member);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
     
    public Long zcard(byte[] key) {  
        Long result = null;  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
  
            result = shardedJedis.zcard(key);  
  
        } catch (Exception e) {  
  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public JedisShardInfo getShardInfo(String key) {  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        JedisShardInfo result = null;  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.getShardInfo(key);  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Collection<JedisShardInfo> getAllShardInfo() {  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        Collection<JedisShardInfo> result = null;  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.getAllShardInfo();  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
  
    public Collection<Jedis> getAllShards() {  
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();  
        Collection<Jedis> result = null;  
        if (shardedJedis == null) {  
            return result;  
        }  
        boolean broken = false;  
        try {  
            result = shardedJedis.getAllShards();  
  
        } catch (Exception e) {  
            //(e.getMessage(), e);  
            broken = true;  
        } finally {  
            redisDataSource.returnResource(shardedJedis, broken);  
        }  
        return result;  
    }  
}
*/