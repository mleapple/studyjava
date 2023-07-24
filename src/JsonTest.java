import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * fileName:JsonTest
 * 작성날짜:2023-07-23
 * desc :
 **/
public class JsonTest {

    public static void main(String[] args){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","홍길동");
        jsonObject.put("phone","000-1111-2222");
        jsonObject.put("address","강남");
        System.out.println("jsonObject = " + jsonObject.toString());

        JSONArray st = new JSONArray
                ();
        st.put(jsonObject);
        st.put(jsonObject);
        JSONObject j2 = new JSONObject();
        j2.put("student" , st);

        System.out.println("j2= " + j2.toString(2));

    }
}
