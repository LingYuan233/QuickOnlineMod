package top.liy233.mcm.quickonlinemod.utils.data;


public class GetChannelsResultData {
    private boolean flag;
    private String msg;
    private ChannelsData data;

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

    public ChannelsData getData() {
        return data;
    }

    public void setData(ChannelsData data) {
        this.data = data;
    }

    public GetChannelsResultData() {
    }

    public GetChannelsResultData(boolean flag, String msg, ChannelsData data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public class ChannelsData {
        private int total;
        private ChannelData[] list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public ChannelData[] getList() {
            return list;
        }

        public void setList(ChannelData[] list) {
            this.list = list;
        }

        public ChannelsData() {
        }

        public ChannelsData(int total, ChannelData[] list) {
            this.total = total;
            this.list = list;
        }
    }
    public class ChannelData {
        boolean allowEc;
        int bandwidth;
        double bandwidthMagnification;
        int classify;
        String comments;
        String group;
        String hostname;
        int id;
        double maxOnlineMagnification;
        String name;
        boolean needRealname;
        Object port; // Changed to Object type to handle both String and Integer
        int status;
        int unitcostEc;
        String description;

        public void setAllowPort(String allowPort) {
            this.allowPort = allowPort;
        }

        ProtocolSupport protocolSupport;
        String allowPort;
        boolean fullyLoaded;

        public boolean isAllowEc() {
            return allowEc;
        }

        public void setAllowEc(boolean allowEc) {
            this.allowEc = allowEc;
        }

        public int getBandwidth() {
            return bandwidth;
        }

        public void setBandwidth(int bandwidth) {
            this.bandwidth = bandwidth;
        }

        public double getBandwidthMagnification() {
            return bandwidthMagnification;
        }

        public void setBandwidthMagnification(int bandwidthMagnification) {
            this.bandwidthMagnification = bandwidthMagnification;
        }

        public int getClassify() {
            return classify;
        }

        public void setClassify(int classify) {
            this.classify = classify;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getMaxOnlineMagnification() {
            return maxOnlineMagnification;
        }

        public void setMaxOnlineMagnification(double maxOnlineMagnification) {
            this.maxOnlineMagnification = maxOnlineMagnification;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isNeedRealname() {
            return needRealname;
        }

        public void setNeedRealname(boolean needRealname) {
            this.needRealname = needRealname;
        }

        public Object getPort() {
            return port;
        }

        public void setPort(Object port) {
            this.port = port;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUnitcostEc() {
            return unitcostEc;
        }

        public void setUnitcostEc(int unitcostEc) {
            this.unitcostEc = unitcostEc;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ProtocolSupport getProtocolSupport() {
            return protocolSupport;
        }

        public void setProtocolSupport(ProtocolSupport protocolSupport) {
            this.protocolSupport = protocolSupport;
        }

        public Object getAllowPort() {
            return allowPort;
        }


        public boolean isFullyLoaded() {
            return fullyLoaded;
        }

        public void setFullyLoaded(boolean fullyLoaded) {
            this.fullyLoaded = fullyLoaded;
        }

        public ChannelData() {
        }

        public ChannelData(boolean allowEc, int bandwidth, int bandwidthMagnification, int classify, String comments, String group, String hostname, int id, double maxOnlineMagnification, String name, boolean needRealname, Object port, int status, int unitcostEc, String description, ProtocolSupport protocolSupport, String allowPort, boolean fullyLoaded) {
            this.allowEc = allowEc;
            this.bandwidth = bandwidth;
            this.bandwidthMagnification = bandwidthMagnification;
            this.classify = classify;
            this.comments = comments;
            this.group = group;
            this.hostname = hostname;
            this.id = id;
            this.maxOnlineMagnification = maxOnlineMagnification;
            this.name = name;
            this.needRealname = needRealname;
            this.port = port;
            this.status = status;
            this.unitcostEc = unitcostEc;
            this.description = description;
            this.protocolSupport = protocolSupport;
            this.allowPort = allowPort;
            this.fullyLoaded = fullyLoaded;
        }


    }

    public class ProtocolSupport {
        boolean tcp;
        boolean udp;
        boolean xtcp;
        boolean stcp;
        boolean http;
        boolean https;

        public boolean isTcp() {
            return tcp;
        }

        public void setTcp(boolean tcp) {
            this.tcp = tcp;
        }

        public boolean isUdp() {
            return udp;
        }

        public void setUdp(boolean udp) {
            this.udp = udp;
        }

        public boolean isXtcp() {
            return xtcp;
        }

        public void setXtcp(boolean xtcp) {
            this.xtcp = xtcp;
        }

        public boolean isStcp() {
            return stcp;
        }

        public void setStcp(boolean stcp) {
            this.stcp = stcp;
        }

        public boolean isHttp() {
            return http;
        }

        public void setHttp(boolean http) {
            this.http = http;
        }

        public boolean isHttps() {
            return https;
        }

        public void setHttps(boolean https) {
            this.https = https;
        }

        public ProtocolSupport() {
        }

        public ProtocolSupport(boolean tcp, boolean udp, boolean xtcp, boolean stcp, boolean http, boolean https) {
            this.tcp = tcp;
            this.udp = udp;
            this.xtcp = xtcp;
            this.stcp = stcp;
            this.http = http;
            this.https = https;
        }
    }

}



