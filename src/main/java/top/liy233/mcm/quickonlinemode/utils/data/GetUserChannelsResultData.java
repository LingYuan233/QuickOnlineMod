package top.liy233.mcm.quickonlinemode.utils.data;

import org.lwjgl.system.CallbackI;

public class GetUserChannelsResultData {
    private boolean flag;
    private String msg;
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public GetUserChannelsResultData() {
    }

    public GetUserChannelsResultData(boolean flag, String msg, Data data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public class Data{
        private int total;
        private Channel[] list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Channel[] getList() {
            return list;
        }

        public void setList(Channel[] list) {
            this.list = list;
        }

        public Data() {
        }

        public Data(int total, Channel[] list) {
            this.total = total;
            this.list = list;
        }

        public class Channel{
            private int id;
            private String proxyName;
            private String proxyType;
            private String localIp;
            private int localPort;
            private boolean useEncryption;
            private boolean useCompression;
            private String domain;
            private String locations;
            private String hostHeaderRewrite;
            private int remotePort;
            private String sk;
            private String headerXFromWhere;
            private boolean status;
            private int nid;
            private double lastUpdate;
            private double lastLogin;
            private String friendlyNode;
            private boolean online;
            private String connectAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getProxyName() {
                return proxyName;
            }

            public void setProxyName(String proxyName) {
                this.proxyName = proxyName;
            }

            public String getProxyType() {
                return proxyType;
            }

            public void setProxyType(String proxyType) {
                this.proxyType = proxyType;
            }

            public String getLocalIp() {
                return localIp;
            }

            public void setLocalIp(String localIp) {
                this.localIp = localIp;
            }

            public int getLocalPort() {
                return localPort;
            }

            public void setLocalPort(int localPort) {
                this.localPort = localPort;
            }

            public boolean isUseEncryption() {
                return useEncryption;
            }

            public void setUseEncryption(boolean useEncryption) {
                this.useEncryption = useEncryption;
            }

            public boolean isUseCompression() {
                return useCompression;
            }

            public void setUseCompression(boolean useCompression) {
                this.useCompression = useCompression;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getLocations() {
                return locations;
            }

            public void setLocations(String locations) {
                this.locations = locations;
            }

            public String getHostHeaderRewrite() {
                return hostHeaderRewrite;
            }

            public void setHostHeaderRewrite(String hostHeaderRewrite) {
                this.hostHeaderRewrite = hostHeaderRewrite;
            }

            public int getRemotePort() {
                return remotePort;
            }

            public void setRemotePort(int remotePort) {
                this.remotePort = remotePort;
            }

            public String getSk() {
                return sk;
            }

            public void setSk(String sk) {
                this.sk = sk;
            }

            public String getHeaderXFromWhere() {
                return headerXFromWhere;
            }

            public void setHeaderXFromWhere(String headerXFromWhere) {
                this.headerXFromWhere = headerXFromWhere;
            }

            public boolean isStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }

            public int getNid() {
                return nid;
            }

            public void setNid(int nid) {
                this.nid = nid;
            }

            public double getLastUpdate() {
                return lastUpdate;
            }

            public void setLastUpdate(double lastUpdate) {
                this.lastUpdate = lastUpdate;
            }

            public double getLastLogin() {
                return lastLogin;
            }

            public void setLastLogin(double lastLogin) {
                this.lastLogin = lastLogin;
            }

            public String getFriendlyNode() {
                return friendlyNode;
            }

            public void setFriendlyNode(String friendlyNode) {
                this.friendlyNode = friendlyNode;
            }

            public boolean isOnline() {
                return online;
            }

            public void setOnline(boolean online) {
                this.online = online;
            }

            public String getConnectAddress() {
                return connectAddress;
            }

            public void setConnectAddress(String connectAddress) {
                this.connectAddress = connectAddress;
            }

            public Channel() {
            }

            public Channel(int id, String proxyName, String proxyType, String localIp, int localPort, boolean useEncryption, boolean useCompression, String domain, String locations, String hostHeaderRewrite, int remotePort, String sk, String headerXFromWhere, boolean status, int nid, double lastUpdate, double lastLogin, String friendlyNode, boolean online, String connectAddress) {
                this.id = id;
                this.proxyName = proxyName;
                this.proxyType = proxyType;
                this.localIp = localIp;
                this.localPort = localPort;
                this.useEncryption = useEncryption;
                this.useCompression = useCompression;
                this.domain = domain;
                this.locations = locations;
                this.hostHeaderRewrite = hostHeaderRewrite;
                this.remotePort = remotePort;
                this.sk = sk;
                this.headerXFromWhere = headerXFromWhere;
                this.status = status;
                this.nid = nid;
                this.lastUpdate = lastUpdate;
                this.lastLogin = lastLogin;
                this.friendlyNode = friendlyNode;
                this.online = online;
                this.connectAddress = connectAddress;
            }
        }
    }
}
