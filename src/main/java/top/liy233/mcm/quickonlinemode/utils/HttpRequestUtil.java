package top.liy233.mcm.quickonlinemode.utils;

import com.google.gson.Gson;
import top.liy233.mcm.quickonlinemode.Main;
import top.liy233.mcm.quickonlinemode.process.URLs;
import top.liy233.mcm.quickonlinemode.utils.data.GetCodeResultData;
import top.liy233.mcm.quickonlinemode.utils.data.LoginCallbackResultData;
import top.liy233.mcm.quickonlinemode.utils.data.LoginRequestData;
import top.liy233.mcm.quickonlinemode.utils.data.LoginResultData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpRequestUtil {

    public static boolean login(LoginRequestData data) {
        try {
            Gson gson = new Gson();
            String loginData = gson.toJson(data);

            HttpURLConnection loginStage1 = send("POST", URLs.LOGIN_STAGE_1, loginData, null, null);
            String setCookie = loginStage1.getHeaderField("set-cookie");
            LoginResultData loginResultData = parse(loginStage1, LoginResultData.class);
//            Main.LOGGER.info("Stage 1: {}", setCookie);

            HttpURLConnection loginStage2 = send("POST", URLs.LOGIN_STAGE_2, null, null, setCookie);
            GetCodeResultData getCodeResultData = parse(loginStage2, GetCodeResultData.class);
            String code = getCodeResultData.getData().getCode();
//            Main.LOGGER.info("Stage 2: {}", code);

            String loginUrl = URLs.LOGIN_STAGE_3 + code;
//            Main.LOGGER.info("Login 3 URL: [{}]", loginUrl);
            HttpURLConnection loginStage3 = send("POST", loginUrl, null, null, null);
            LoginCallbackResultData loginCallbackResultData = parse(loginStage3, LoginCallbackResultData.class);
            String token = loginStage3.getHeaderField("Authorization");
//            Main.LOGGER.info("Stage 3: {}", token);
//            Main.LOGGER.info("Stage 3 msg: {}", loginCallbackResultData.getMsg());
            Main.TOKEN = token;

            loginStage1.disconnect();
            loginStage2.disconnect();
            loginStage3.disconnect();

            return true;
        } catch (Exception e){
            return false;
        }
    }


    public static <T> T parse(HttpURLConnection conn, Class<T> type) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                builder.append(responseLine.trim());
            }
        }
        return new Gson().fromJson(builder.toString(), type);
    }

    public static HttpURLConnection sendWithToken(String method_, String url_, String json_) throws IOException {
        return send(method_,  url_, json_, Main.TOKEN, null);
    }

    public static HttpURLConnection send(String method_, String url_, String json_, String token_, String cookie_) throws IOException {
        URL url = new URL(url_);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod(method_);
        conn.setRequestProperty("Content-Type", "application/json");
        if (token_ != null){
            conn.setRequestProperty("Authorization", token_);
        }
        if (cookie_ != null){
            conn.setRequestProperty("Cookie", cookie_);
        }
        conn.setDoOutput(true);
        if (json_ != null){
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json_.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        }
        conn.connect();
        return conn;
    }

    public static boolean isUrl(String addr){
        try {
            URL u = new URL("http://"+addr);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

}
