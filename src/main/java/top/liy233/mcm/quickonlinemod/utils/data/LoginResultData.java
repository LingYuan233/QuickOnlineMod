package top.liy233.mcm.quickonlinemod.utils.data;

public class LoginResultData {
    private String msg;
    private int code;
    private Object data;
    private boolean flag;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LoginResultData() {
    }

    public LoginResultData(String msg, int code, Object data, boolean flag) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.flag = flag;
    }
}
