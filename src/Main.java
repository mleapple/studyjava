import com.google.gson.Gson;
import kr.com.dto.BookDto;

/**
 * fileName:${NAME}
 * 작성날짜:2023-07-20
 * desc :
 **/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BookDto dto = new BookDto("자바", 1000,"예담",800);
        Gson g = new Gson();
        String json = g.toJson(dto);
        System.out.println("json = " + json);
        // {"title":"자바","price":1000,"company":"예담","page":800}
        BookDto b = g.fromJson(json,BookDto.class);

        System.out.println("json = " + b);
        System.out.println(dto instanceof  BookDto);
        System.out.println(b instanceof  BookDto);
        System.out.println(dto.toString());
        System.out.println(b.toString());
    }
}