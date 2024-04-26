package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkWithExcel {
    public static void main(String[] arg) {
        WorkWithExcel exceltry = new WorkWithExcel("D:\\1.xlsx");
        System.out.println("Курва почекай");
        System.out.println(exceltry.pochekai());
    }

    Map<Integer, List<String>> data = new HashMap<>();
    Sheet sheet;
    String path;

    //todo добавить в перебор
    public WorkWithExcel(String filePath) {
        this.path = filePath;
        try {
            FileInputStream file = new FileInputStream(new File(this.path));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                int col_index = 1;
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING: {
                            if (col_index == 18 || col_index == 26 || col_index == 42)
                                data.get(i).add(cell.toString());
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
                    //data.get(i).add(row.getCell(47).toString());
                    col_index++;
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("не повезло" + e.toString());
        }
    }

    public String pochekai() {
        String str = new String();
        try {
            FileInputStream file = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(file);
            for (List<String> row : this.data.values()) {
                int col_index = 0;
                for (String datarow : row) {
                    if (col_index == 2) {
                        //datarow.setCellValue("sdasdasdsadsadsasd");
                        //ааааааааааааааааааааааа
                        Sheet temp = workbook.getSheetAt(0);
                        Row myRow = temp.getRow(0);
                        Cell myCel = myRow.createCell(47);
                        myCel.setCellValue("s12321");
                        //temp.getRow(0).createCell(47, CellType.STRING);
                    }
                    str += datarow.toString() + "\n";
                    col_index++;

                }
                col_index = 0;
            }
            file.close();
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("не написал" + e.toString());
        }
        return str;
    }
}
