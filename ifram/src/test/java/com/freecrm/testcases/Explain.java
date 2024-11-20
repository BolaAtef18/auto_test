package com.freecrm.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Explain {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\batef\\OneDrive\\Desktop\\FreeCRMTestData.xlsx");
        FileInputStream fis = new FileInputStream(file);

        //Apache POI

        //xlsx
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        String familyname = sheet.getRow(2).getCell(1).toString();
        //System.out.println(familyname);

        int rows =  sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        Object data[][] = new Object[rows][columns];

        for (int i=0;i<rows;i++){
            for (int k=0;k<columns;k++){
                data[i][k]= sheet.getRow(i).getCell(k);
            }
        }
        System.out.println(data[1][1]);


        workbook.close();
    }




}
