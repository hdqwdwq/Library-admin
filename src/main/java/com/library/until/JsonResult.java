package com.library.until;

import lombok.Data;

@Data
public class JsonResult {
    private boolean success=true;
    private String msg="操作成功";

    public JsonResult() {
    }

    public JsonResult(boolean success, String msg) {
           this.success=false;
           this.msg="操作失败";
    }
}
