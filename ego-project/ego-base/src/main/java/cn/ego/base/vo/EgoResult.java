package cn.ego.base.vo;

public class EgoResult  {
    private int status;
    private Object data;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static EgoResult build(Integer status, String msg, Object data) {
        return new EgoResult(status, msg, data);
    }

    public static EgoResult ok(Object data) {
        return new EgoResult(data);
    }

    public static EgoResult ok() {
        return new EgoResult(null);
    }

    public EgoResult() {

    }

    public static EgoResult build(Integer status, String msg) {
        return new EgoResult(status, msg, null);
    }

    public EgoResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public EgoResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }


}
