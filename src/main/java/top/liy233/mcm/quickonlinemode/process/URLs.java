package top.liy233.mcm.quickonlinemode.process;

import org.lwjgl.system.CallbackI;

public class URLs {
    public static final String ROOT_URL = "https://of-dev-api.bfsea.xyz";

    public static final String LOGIN_STAGE_1 = "https://openid.17a.ink/api/public/login";
    public static final String LOGIN_STAGE_2 = "https://openid.17a.ink/api/oauth2/authorize?response_type=code&redirect_uri=https://of-dev-api.bfsea.xyz/oauth_callback&client_id=openfrp";
    public static final String LOGIN_STAGE_3 = "https://of-dev-api.bfsea.xyz/oauth2/callback?code=";

    public static final String GET_USER_INFO = ROOT_URL + "/frp/api/getUserInfo";
    public static final String CREATE_CHANNEL = ROOT_URL + "/frp/api/newProxy";
    public static final String DELETE_CHANNEL = ROOT_URL + "/frp/api/removeProxy";
    public static final String GET_NODE_LIST = ROOT_URL + "/frp/api/getNodeList";
    public static final String GET_USER_CHANNELS = ROOT_URL + "/frp/api/getUserProxies";
}
