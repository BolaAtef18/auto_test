package com.freecrm.util;

import com.freecrm.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtils extends TestBase {


    public TestUtils() throws IOException {
        super();
    }

    public static void takePicture(String name) throws IOException {
        File srcFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("C:\\Users\\batef\\IdeaProjects\\ifram\\Snapshots\\"+name+".png"));

    }

    public static Object[][] getDataFromExcel(String sheetName) throws IOException {
        File file = new File("C:\\Users\\batef\\IdeaProjects\\ifram\\src\\test\\java\\com\\freecrm\\testdata\\FreeCRMTestData.xlsx");

        FileInputStream fis = new FileInputStream(file);

        //Apache POI

        //xlsx
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows =  sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        Object data[][] = new Object[rows][columns];

        for (int i=0;i<rows;i++){
            for (int k=0;k<columns;k++){
                data[i][k]= sheet.getRow(i).getCell(k).toString();
            }
        }

        return data;
    }
}
