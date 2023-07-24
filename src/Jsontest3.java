import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * fileName:Jsontest3
 * 작성날짜:2023-07-24
 * desc :
 **/
public class Jsontest3 {
    public static void main(String[] args) throws MalformedURLException {

        final String url = "https://dapi.kakao.com/v2/local/search/address.json?query=";
        final String auth = "KakaoAK 799756801a9af938ed09dd21394c76c3";

        String query = "서울시 용산구 문배동 11-14";
        //




        try {
            String sendData = url+ URLEncoder.encode(query,"UTF-8");
            System.out.println("sendData = " + sendData);
            URL url1 = new URL(sendData);
            HttpURLConnection connection =(HttpURLConnection)url1.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization" , "KakaoAK 799756801a9af938ed09dd21394c76c3");


        //

            int reponsecode  = connection.getResponseCode();

            System.out.println("reponsecode = " + reponsecode);
            //
            BufferedReader bufferedReader ;
            if(reponsecode == 200){
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            }else{
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuffer response = new StringBuffer();
            while ((line=bufferedReader.readLine())!=null){
                response.append(line);
            }
            bufferedReader.close();

            JSONTokener tokener = new JSONTokener(response.toString());
            JSONObject object= new JSONObject(tokener);
            System.out.println("object = " + object.toString(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
