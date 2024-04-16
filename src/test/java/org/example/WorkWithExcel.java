package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.jxls.common.CellData.CellType.FORMULA;
import static org.jxls.common.CellData.CellType.BOOLEAN;
import static org.jxls.common.CellData.CellType.STRING;

public class WorkWithExcel {
    Map<Integer, List<String>> data = new HashMap<>();

    public WorkWithExcel(String filePath){
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                System.out.println("Начало");
                int col_index = 1;
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING: {
                            if (col_index == 18 || col_index == 26 || col_index == 42)
                                System.out.println(col_index + " " + cell.getRichStringCellValue().getString());
                            break;
                        }
                        case BOOLEAN: {
                            break;
                        }
                        case FORMULA: {
                            break;
                        }
                        default: data.get(i).add(" ");

                    } col_index++;

                }
                i++;
            }
        } catch (Exception e)
        {
            System.out.println("не повездо" + e.toString());
        }
    }
}
