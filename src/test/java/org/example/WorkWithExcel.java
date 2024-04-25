package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkWithExcel {
    public static void main(String[] arg){
        WorkWithExcel exceltry = new WorkWithExcel("C:\\1.xlsx");
        System.out.println("Курва почекай");
        System.out.println(exceltry.pochekai());
    }
    Map<Integer, List<Cell>> data = new HashMap<>();
    //todo добавить в перебор
    public WorkWithExcel(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<Cell>());
                int col_index = 1;
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING: {
                            if (col_index == 18 || col_index == 26 || col_index == 42)
                                data.get(i).add(cell);
                            break;
                        }
                        case BOOLEAN: {
                            break;
                        }
                        case FORMULA: {
                            break;
                        }
                        default:


                    }

                    col_index++;

                }

                i++;
            }
        } catch (IOException e) {
            System.out.println("не повезло" + e.toString());
        }
    }

    public String pochekai(){
        String str = new String();
        for (List<Cell> row: this.data.values()){
            for (Cell datarow: row){
                str += datarow.toString() + "\n";
            }
        }
        return str;
    }
}
