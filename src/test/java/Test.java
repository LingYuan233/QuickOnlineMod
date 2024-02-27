import com.google.gson.Gson;
import top.liy233.mcm.quickonlinemode.utils.data.GetChannelsResultData;

public class Test {

    public static void main(String[] args) {
        Gson gson = new Gson();
        GetChannelsResultData data = gson.fromJson(Data.d, GetChannelsResultData.class);
        System.out.println(data.getData().getList()[0].getAllowPort());
    }
}
