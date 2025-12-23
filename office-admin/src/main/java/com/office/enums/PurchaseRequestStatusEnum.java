package com.office.enums;

public enum PurchaseRequestStatusEnum {
    PENDING(1L, "待处理"),
    PUBLIC(2L, "已生成订单"),
    PRIVATE(3L, "已完成"),
    SECRET(4L, "已取消");
    private Long value;
    private String text;

    PurchaseRequestStatusEnum(Long value, String text) {
        this.value = value;
        this.text = text;
    }
    public static PurchaseRequestStatusEnum getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }
        PurchaseRequestStatusEnum[] values = PurchaseRequestStatusEnum.values();
        for (PurchaseRequestStatusEnum purchaseRequestStatusEnum : values) {
            if (purchaseRequestStatusEnum.getValue().equals(value.longValue())) {
                return purchaseRequestStatusEnum;
            }
        }
        return null;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
