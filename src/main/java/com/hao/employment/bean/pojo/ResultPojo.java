package com.hao.employment.bean.pojo;

import com.hao.employment.common.enums.ResultStatusEnum;
import lombok.Data;

/*@author haoxueqiao
  @date 2019/4/3 17:33*/
@Data
public class ResultPojo {
    private int status;
    private String message;
    private Object data;
    public ResultPojo(){};

    /**
     * 返回结果
     * @param statusType
     *            返回状态 0 成功返回 2 异常 1 重新登录
     * @param message
     *            返回信息
     * @param data
     *            返回的数据
     */
    public ResultPojo(ResultStatusEnum statusType, String message, Object data) {
        this.status = statusType.getCode();
        if (message == null || "".equals(message)) {
            this.message = statusType.getMessage();
        } else {
            this.message = message;
        }
        this.data = data;
    }
}
