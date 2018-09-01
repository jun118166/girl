package com.exfox.gril.exception;

import com.exfox.gril.enums.ResutlEnum;

public class GirlException extends  RuntimeException {
    private Integer code;

    public GirlException(ResutlEnum resutlEnum) {
        super(resutlEnum.getMsg());
        this.code = resutlEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
