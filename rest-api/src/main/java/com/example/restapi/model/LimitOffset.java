package com.example.restapi.model;


public class LimitOffset {
    private Integer limit;
    private Integer offset;

    /**
     * 构建分页参数的对象
     *
     * @param limit
     * @param offset
     * @return
     */
    public static LimitOffset build(Integer limit, Integer offset) {
        LimitOffset limitOffset = new LimitOffset();
        limitOffset.setLimit(limit);
        limitOffset.setOffset(offset);
        return limitOffset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
