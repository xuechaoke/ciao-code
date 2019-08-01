package ciao.code.spring.example.demo05httpclient.hutoolhttpclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应数据
 *
 * @author huangbin 694968711@qq.com
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pt100Result implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    private int code = 1;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    private User data;

    public Pt100Result ok(User data) {
        this.setData(data);
        return this;
    }

    public boolean success() {
        return code == 1 ? true : false;
    }

    public Pt100Result error() {
        this.code = 500;
        this.msg = "错误";
        return this;
    }

    public Pt100Result error(int code) {
        this.code = code;
        this.msg = "错误";
        return this;
    }

    public Pt100Result error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Pt100Result error(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }


}
