package tianki.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tiank on 9/21/2017.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class  More{

        @SerializedName("txt")
        public String info;
    }
}
