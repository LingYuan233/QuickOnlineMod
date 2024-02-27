package top.liy233.mcm.quickonlinemod.utils.data;

public class LoginCallbackResultData {
    private String data;
    private boolean flag;
    private String msg;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginCallbackResultData() {
    }

    public LoginCallbackResultData(String data, boolean flag, String msg) {
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }
}
