package com.pharmacity.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelHelper {

    private String filePath;

    public ExcelHelper(String filePath) {
        this.filePath = filePath != null ? filePath : "./TestCase_Automation.xlsx";
    }

    // Method to update a specific cell in the Excel sheet
    public void updateCell(int row, int col, String value, String sheetName) {
        Workbook workbook = null;
        FileInputStream fis = null;

        try {
            File file = new File(filePath);
            if (file.exists()) {
                fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis); // Read the existing Excel file
            } else {
                System.out.println("File không tồn tại. Tạo file mới.");
                workbook = new XSSFWorkbook(); // Create a new workbook
            }

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Worksheet \"" + sheetName + "\" không tồn tại. Tạo mới...");
                sheet = workbook.createSheet(sheetName); // Create new sheet if not exist
            }

            Row excelRow = sheet.getRow(row);
            if (excelRow == null) {
                excelRow = sheet.createRow(row); // Create a new row if it doesn't exist
            }

            Cell cell = excelRow.getCell(col);
            if (cell == null) {
                cell = excelRow.createCell(col); // Create a new cell if it doesn't exist
            }

            cell.setCellValue(value); // Set the value of the cell

            // Write the updated content back to the file
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();

            System.out.println("Đã nhập dữ liệu \"" + value + "\" vào ô (" + (row +1) + ", " + (col + 1) + ") trong file " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật ô: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close(); // Close the input stream
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
