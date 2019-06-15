package ciao.code.spring.example.demo04redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service/*(value = "redisService")*/
public class RedisServiceImpl implements RedisService {

    private static String redisCode = "utf-8";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

//    private RedisMessageListenerContainer listenerContainer;

    /**
     * @param keys
     */

    @Override
    public long del(final String... keys) {
        return (long) redisTemplate.execute((RedisCallback) connection -> {
            long result = 0;
            for (int i = 0; i < keys.length; i++) {
                result = connection.del(keys[i].getBytes());
            }
            return result;
        });
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    @Override
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute((RedisCallback) connection -> {
            connection.set(key, value);
            if (liveTime > 0) {
                connection.expire(key, liveTime);
            }
            return 1L;
        });
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, String value, long liveTime) {
        this.set(key.getBytes(), value.getBytes(), liveTime);
    }

    /**
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    /**
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);
    }

    /**
     * @param key
     * @return
     */
    public String get(final String key) {
        return (String) redisTemplate.execute((RedisCallback) connection -> {
            try {
                return new String(connection.get(key.getBytes()), redisCode);
            } catch (Exception e) {
                return null;
            }
        });
    }

    public Set<String> Setkeys(String pattern) {
        return redisTemplate.keys(pattern);
    }


    /**
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return (boolean) redisTemplate.execute((RedisCallback) connection -> connection.exists(key.getBytes()));
    }

    @Override
    public long ttl(final String key) {

        return (Long) redisTemplate.execute((RedisCallback) connection -> connection.ttl(key.getBytes()));

    }

    /**
     * @return
     */
    public String flushDB() {
        return (String) redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return "ok";
        });
    }

    /**
     * @return
     */
    public long dbSize() {
        return (long) redisTemplate.execute((RedisCallback) connection -> connection.dbSize());
    }

    /**
     * @return
     */
    public String ping() {
        return (String) redisTemplate.execute((RedisCallback) connection -> connection.ping());
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long leftPush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public String leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long rightPush(String key, String value) {
        redisTemplate.expire(key, 7, TimeUnit.DAYS);
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public String rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public Long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * @param key
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<String> range(String key, int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * @param key
     * @param i
     * @param value
     */
    @Override
    public void remove(String key, long i, String value) {
        redisTemplate.opsForList().remove(key, i, value);
    }

    /**
     * @param key
     * @param index
     * @return
     */
    @Override
    public String index(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * @param key
     * @param index
     * @param value
     */
    @Override
    public void set(String key, long index, String value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * @param key
     * @param start
     * @param end
     */
    @Override
    public void trim(String key, long start, int end) {
        redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long addSet(String key, String value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public String popSet(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    @Override
    public Set<String> membersSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public Long removeSet(String key, String value) {
        return redisTemplate.opsForSet().remove(key, value);
    }

    @Override
    public void hashMapPutAll(String key, HashMap<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public void hashMapPut(String key, String hashKey, String value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    @Override
    public Object getHashMapValue(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public void hashMapDel(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    @Override
    public boolean exists(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    @Override
    public List<Object> multiGetHashMap(String key, Collection<Object> hashKey) {
        return redisTemplate.opsForHash().multiGet(key, hashKey);
    }

    /**
     * 发布
     *
     * @param channel 频道
     * @param msg     消息
     * @return
     */
/*    @Override
    public Long publish(final String channel, final String msg) {

        return (Long) redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {

                return connection.publish(channel.getBytes(), msg.getBytes());
            }
        });
    }

    @Override
    public void subscribe(MessageListener listener, String... topic) {
        listenerContainer.addMessageListener(listener, (Collection) Arrays.asList(topic));
    }

    public RedisMessageListenerContainer getListenerContainer() {
        return listenerContainer;
    }

    @Autowired
    @Qualifier("myMessageContainer")
    public void setListenerContainer(RedisMessageListenerContainer listenerContainer) {
        this.listenerContainer = listenerContainer;
    }*/


}
