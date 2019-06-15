package ciao.code.spring.example.demo04redis.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface RedisService {

    /**
     * 通过key删除
     *
     * @param keys
     */
    long del(String... keys);

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime 单位秒
     */
    void set(String key, String value, long liveTime);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    void set(byte[] key, byte[] value);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    abstract Set<String> Setkeys(String pattern);

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 获取key的剩余过期时间
     *
     * @param key
     * @return
     */
    long ttl(String key);

    /**
     * 清空redis 所有数据
     *
     * @return
     */
    String flushDB();

    /**
     * 查看redis里有多少数据
     */
    long dbSize();

    /**
     * 检查是否连接成功
     *
     * @return
     */
    String ping();

    /**
     * 左进
     * list
     *
     * @param key
     * @param value
     * @return
     */
    Long leftPush(String key, String value);

    /**
     * 左出
     * list
     *
     * @param key
     * @return
     */
    String leftPop(String key);

    /**
     * 右进
     * list
     *
     * @param key
     * @param value
     * @return
     */
    Long rightPush(String key, String value);

    /**
     * 右出
     * list
     *
     * @param key
     * @return
     */
    String rightPop(String key);

    /**
     * 栈/队列长
     * list
     *
     * @param key
     * @return
     */
    Long listLength(String key);

    /**
     * 范围检索
     * list
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> range(String key, int start, int end);

    /**
     * 移除
     * list
     *
     * @param key
     * @param i
     * @param value
     */
    void remove(String key, long i, String value);

    /**
     * 检索
     * list
     *
     * @param key
     * @param index
     * @return
     */
    String index(String key, long index);

    /**
     * 置值
     * list
     *
     * @param key
     * @param index
     * @param value
     */
    void set(String key, long index, String value);

    /**
     * 裁剪
     * list
     *
     * @param key
     * @param start
     * @param end
     */
    void trim(String key, long start, int end);

    /**
     * 添加set
     *
     * @param key
     * @param value
     * @return
     */
    Long addSet(String key, String value);

    /**
     * @param key
     * @return
     */
    String popSet(String key);

    /**
     * @param key
     * @return
     */
    Set<String> membersSet(String key);

    /**
     * 移除set元素
     *
     * @param key
     * @param value
     * @return
     */
    Long removeSet(String key, String value);

    /**
     * Map
     * putAll
     *
     * @param key
     * @param map
     */
    void hashMapPutAll(String key, HashMap<String, String> map);

    /**
     * Map
     * put
     *
     * @param key
     * @param hashKey
     * @param value
     */
    void hashMapPut(String key, String hashKey, String value);

    /**
     * Map
     * 获取单个value
     *
     * @param key
     * @param hashKey
     * @return
     */
    Object getHashMapValue(String key, String hashKey);

    /**
     * @param key
     * @param hashKey
     */
    void hashMapDel(String key, String hashKey);

    /**
     * @param key
     * @param hashKey
     * @return
     */
    boolean exists(String key, String hashKey);

    /**
     * Map
     * 获取多个value
     *
     * @param key
     * @param hashKey
     * @return
     */
    List<Object> multiGetHashMap(String key, Collection<Object> hashKey);

    /**
     * 向频道发布消息
     *
     * @param channel 频道
     * @param msg     消息
     */
//    Long publish(String channel, String msg);

    /**
     * 订阅频道，并监听消息
     *
     * @param listener 消息监听器
     * @param topic    频道名
     */
//    void subscribe(MessageListener listener, String... topic);

}
