package com.fancv.EventBusDemo;

/**
 * 发送消息对象
 */
public class MessageEvent {
    /**
     * 消息类型
     */
    String type;

    /**
     * 消息内容
     */

    String message;


    String fromUserId;


    String toUserId;


    String businessId;

    /**
     * 操作类型  发送  撤回
     */

    String operation;

    public MessageEvent(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
