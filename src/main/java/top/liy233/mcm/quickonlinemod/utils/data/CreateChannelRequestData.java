package top.liy233.mcm.quickonlinemod.utils.data;

public class CreateChannelRequestData {
    public static CreateChannelRequestData create(int id, int port, int remotePort){
        return new CreateChannelRequestData(
                id,
                "QOM_"+id+"_"+remotePort,
                "tcp",
                "127.0.0.1",
                String.valueOf(port),
                remotePort,
                "",
                false,
                false,
                "",
                "",
                "",
                "",
                ""
        );
    }
    private int node_id;
    private String name;
    private String type;
    private String local_addr;
    private String local_port;
    private int remote_port;
    private String domin_bind;
    private boolean dataGzip;
    private boolean dataEncrypt;
    private String url_route;
    private String host_rewrite;
    private String request_from;
    private String request_pass;
    private String custom;

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocal_addr() {
        return local_addr;
    }

    public void setLocal_addr(String local_addr) {
        this.local_addr = local_addr;
    }

    public String getLocal_port() {
        return local_port;
    }

    public void setLocal_port(String local_port) {
        this.local_port = local_port;
    }

    public int getRemote_port() {
        return remote_port;
    }

    public void setRemote_port(int remote_port) {
        this.remote_port = remote_port;
    }

    public String getDomin_bind() {
        return domin_bind;
    }

    public void setDomin_bind(String domin_bind) {
        this.domin_bind = domin_bind;
    }

    public boolean isDataGzip() {
        return dataGzip;
    }

    public void setDataGzip(boolean dataGzip) {
        this.dataGzip = dataGzip;
    }

    public boolean isDataEncrypt() {
        return dataEncrypt;
    }

    public void setDataEncrypt(boolean dataEncrypt) {
        this.dataEncrypt = dataEncrypt;
    }

    public String getUrl_route() {
        return url_route;
    }

    public void setUrl_route(String url_route) {
        this.url_route = url_route;
    }

    public String getHost_rewrite() {
        return host_rewrite;
    }

    public void setHost_rewrite(String host_rewrite) {
        this.host_rewrite = host_rewrite;
    }

    public String getRequest_from() {
        return request_from;
    }

    public void setRequest_from(String request_from) {
        this.request_from = request_from;
    }

    public String getRequest_pass() {
        return request_pass;
    }

    public void setRequest_pass(String request_pass) {
        this.request_pass = request_pass;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public CreateChannelRequestData() {
    }

    public CreateChannelRequestData(int node_id, String name, String type, String local_addr, String local_port, int remote, String domin_bind, boolean dataGzip, boolean dataEncryption, String url_route, String host_rewrite, String request_from, String request_pass, String custom) {
        this.node_id = node_id;
        this.name = name;
        this.type = type;
        this.local_addr = local_addr;
        this.local_port = local_port;
        this.remote_port = remote;
        this.domin_bind = domin_bind;
        this.dataGzip = dataGzip;
        this.dataEncrypt = dataEncryption;
        this.url_route = url_route;
        this.host_rewrite = host_rewrite;
        this.request_from = request_from;
        this.request_pass = request_pass;
        this.custom = custom;
    }
}
