import kr.com.vo.ExcelVO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * fileName:ExcelTest
 * 작성날짜:2023-07-24
 * desc :
 **/
public class ExcelTest {

    public static void main(String [] args){
        String fileName = "bookList.xls";
        List<ExcelVO> data = new ArrayList<>();

        // 파일 읽어오기
        try (FileInputStream fis = new FileInputStream(fileName)) {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
           Iterator<Row> rows = sheet.rowIterator();
            rows.next() ; // 헤더로우는 가져오지 말기

            String[] tmpDataset= new String[5];
            while (rows.hasNext()){
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator(); //열
                int i = 0;
                while(cells.hasNext()){
                    HSSFCell  cell=(HSSFCell) cells.next();
                    tmpDataset[i] = cell.toString();
                    i++;
                    // 열정보 담기
                    // title ,author , ...
                }
                ExcelVO vo = new ExcelVO(tmpDataset[0],tmpDataset[1],tmpDataset[2],tmpDataset[3],tmpDataset[4]);
                data.add(vo);
            }


     /*       File xlsx = new File( "Book.xls";);
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(xlsx));*/




            showdata(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 메모리 올리기
        // 데이터 핸들링하기
    }

    private static void showdata(List<ExcelVO> data) {
        for(ExcelVO vo:data){
            System.out.println("vo = " + vo);
        }
    }
}
