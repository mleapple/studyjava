import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonToken;
import kr.com.dto.BookDto;
import kr.com.dto.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

/**
 * fileName:TestJson2
 * 작성날짜:2023-07-23
 * desc :
 **/
public class TestJson2 {
    public static void main(String[] args) {
        String source = "info.json";
        InputStream is = TestJson2.class.getResourceAsStream(source);// 현재 만들어진 클래스에서 source 를 얻어와라
        if (is == null) throw new NullPointerException("connot find reousrce");
        JSONTokener tokener = new JSONTokener(is);

        JSONObject jsonOb = new JSONObject(tokener);

        System.out.println("jsonOb = " + jsonOb);

        //JSONArray jsonArray = jsonOb.getJSONArray("student");
        JSONArray jsonArray = jsonOb.getJSONArray("student");


        System.out.println("jsonArray = " + jsonArray);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            //   Student  st = (Student)obj.
            Gson g = new Gson();
            Student b = g.fromJson(obj.toString(), Student.class);
            System.out.println("Student = " + b);
            System.out.println("Student = " + b.getAddress() + " : " +b.getName() + " : " +b.getPhone());

        }
    }

       /* InputStream is2 = TestJson2.class.getResourceAsStream(source);

        JsonToken jsonToken = new J*/

}
