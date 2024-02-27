package top.liy233.mcm.quickonlinemode.config;

public class ConfigData {
    private String user;
    private String password;
    private String key;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ConfigData() {
    }

    public ConfigData(String user, String password, String key) {
        this.user = user;
        this.password = password;
        this.key = key;
    }
}
