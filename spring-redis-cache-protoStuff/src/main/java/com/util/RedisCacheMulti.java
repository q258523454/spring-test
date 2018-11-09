package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * redis缓存
 */
@Component
public class RedisCacheMulti {

    public final static String CAHCENAME = "cache"; // 缓存名
    public final static int CAHCETIME = 3600;       // 默认缓存时间(秒)

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 存入redis，不带过期时间
     */
    public <T> boolean putCachePro(String key, T obj) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
        return result;
    }


    /**
     * 存入redis，带过期时间
     */
    public <T> void putCacheProWithExpireTime(String key, T obj, final long expireTime) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
    }

    public <T> T getCachePro(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserialize(result, targetClass);
    }


    public <T> boolean putListCachePro(String key, List<T> objList) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
        return result;
    }

    public <T> boolean putListCacheProWithExpireTime(String key, List<T> objList, final long expireTime) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
        return result;
    }


    public <T> List<T> getListCachePro(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserializeList(result, targetClass);
    }

    /**
     * 精确删除key
     *
     * @param key
     */
    public void deleteCache(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 模糊删除key
     *
     * @param pattern
     */
    public void deleteCacheWithPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }

    /**
     * 清空所有缓存
     */
    public void clearCache() {

        deleteCacheWithPattern(RedisCacheMulti.CAHCENAME + "|*");
    }


    // ---------------------------------------------------------------------
    // -------------------------- java自带原始序列转换 ------------------------
    // ---------------------------------------------------------------------

    public <T> boolean putCacheOrg(Object key, T value) {
        System.out.println("加入缓存");
        System.out.println("put key:" + key);
        System.out.println("put value:" + value);

        final byte[] keyb = key.toString().getBytes();
        final byte[] valueb = OriginalSerializeUtil.serialize(value);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(keyb, valueb);
                return true;
            }
        });
        return result;
    }


    public <T> boolean putCacheOrgWithExpireTime(Object key, T value, final long expireTime) {
        System.out.println("加入缓存");
        System.out.println("put key:" + key);
        System.out.println("put value:" + value);

        final byte[] keyb = key.toString().getBytes();
        final byte[] valueb = OriginalSerializeUtil.serialize(value);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(keyb, expireTime, valueb);
                return true;
            }
        });
        return result;
    }


    public Object getCacheOrg(Object key) {
        System.out.println("获取缓存:");
        System.out.println("object key = " + key.toString());
        final String keyf = key.toString();
        Object object = null;
        object = redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    System.out.println(keyf + " 缓存不存在.");
                    return null;
                } else {
                    return OriginalSerializeUtil.unserialize(value);
                }
            }
        });
        return object;
    }

    public boolean putListCacheOrg(String key, List<?> objList) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = OriginalSerializeUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(bkey, bvalue);
                return true;
            }
        });
        return result;
    }

    public boolean putListCacheOrgWithExpireTime(String key, List<?> objList, final long expireTime) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = OriginalSerializeUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
        return result;
    }


    public List<?> getListCacheOrg(final String key) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return OriginalSerializeUtil.unserializeList(result);
    }
}