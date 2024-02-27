package top.liy233.mcm.quickonlinemode.utils.data;

public class GetCodeResultData {
    private int code;
    private String msg;
    private Data data;
    private boolean flag;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public GetCodeResultData() {
    }

    public GetCodeResultData(int code, String msg, Data data, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.flag = flag;
    }

    public class Data{
        private String code;
        private String state;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Data() {
        }

        public Data(String code, String state) {
            this.code = code;
            this.state = state;
        }
    }
}
