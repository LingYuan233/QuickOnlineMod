package top.liy233.mcm.quickonlinemod.utils.data;

public class GetUserResultData {
    private String msg;
    private boolean flag;
    private Data data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public GetUserResultData() {
    }

    public GetUserResultData(String msg, boolean flag, Data data) {
        this.msg = msg;
        this.flag = flag;
        this.data = data;
    }

    public class Data{
        private int outLimit;
        private int used;
        private String token;
        private boolean realname;
        private String regTime;
        private int inLimit;
        private String friendlyGroup;
        private int proxies;
        private int id;
        private String email;
        private String username;
        private String group;
        private int traffic;

        public int getOutLimit() {
            return outLimit;
        }

        public void setOutLimit(int outLimit) {
            this.outLimit = outLimit;
        }

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public boolean isRealname() {
            return realname;
        }

        public void setRealname(boolean realname) {
            this.realname = realname;
        }

        public String getRegTime() {
            return regTime;
        }

        public void setRegTime(String regTime) {
            this.regTime = regTime;
        }

        public int getInLimit() {
            return inLimit;
        }

        public void setInLimit(int inLimit) {
            this.inLimit = inLimit;
        }

        public String getFriendlyGroup() {
            return friendlyGroup;
        }

        public void setFriendlyGroup(String friendlyGroup) {
            this.friendlyGroup = friendlyGroup;
        }

        public int getProxies() {
            return proxies;
        }

        public void setProxies(int proxies) {
            this.proxies = proxies;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public int getTraffic() {
            return traffic;
        }

        public void setTraffic(int traffic) {
            this.traffic = traffic;
        }

        public Data() {
        }

        public Data(int outLimit, int used, String token, boolean realname, String regTime, int inLimit, String friendlyGroup, int proxies, int id, String email, String username, String group, int traffic) {
            this.outLimit = outLimit;
            this.used = used;
            this.token = token;
            this.realname = realname;
            this.regTime = regTime;
            this.inLimit = inLimit;
            this.friendlyGroup = friendlyGroup;
            this.proxies = proxies;
            this.id = id;
            this.email = email;
            this.username = username;
            this.group = group;
            this.traffic = traffic;
        }
    }
}
