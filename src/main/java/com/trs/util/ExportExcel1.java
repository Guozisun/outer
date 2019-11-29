package com.trs.util;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: databaseGrab
 * Author: 果子
 * Create Time:2019/8/23 10:05
 */
public class ExportExcel1 {

        /*
         * author:命运的信徒
         *  date:2019-07-31
         *  arm:通过java程序往excel里面续写数据
         */
        public static void main(String[] args) {
            String url="D:/hyj/20190825164044.xls";
            FileInputStream fs;
            try {
                fs = new FileInputStream(url);
                POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
                HSSFWorkbook wb=new HSSFWorkbook(ps);
                HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
                HSSFRow row=sheet.getRow(0);
                int hang=0;
                if("".equals(row)||row==null){
                    hang=0;
                }else{
                    hang=sheet.getLastRowNum();
                    hang=hang+1;
                }
                //分别得到最后一行的行号，和一条记录的最后一个单元格
                FileOutputStream out=new FileOutputStream(url);  //向d://test.xls中写数据
                row=sheet.createRow((short)(hang)); //在现有行号后追加数据
                row.createCell(0).setCellValue("安徽"); //设置第一个（从0开始）单元格的数据
                row.createCell(1).setCellValue("安庆"); //设置第二个（从0开始）单元格的数据
                out.flush();
                wb.write(out);
                out.close();
                System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  //获取d://test.xls
        }

    public static void excelPort (String fileName,Map<String,String>dataset){
            System.out.println(dataset.get("MEMBERID"));
        FileInputStream fs;
        try {
            fs = new FileInputStream(fileName);
            POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
            HSSFWorkbook wb=new HSSFWorkbook(ps);
            HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
            HSSFRow row=sheet.getRow(0);
            int hang=0;
            if("".equals(row)||row==null){
                hang=0;
            }else{
                hang=sheet.getLastRowNum();
                hang = hang+1;
            }
            System.out.println(hang);
            //分别得到最后一行的行号，和一条记录的最后一个单元格
            FileOutputStream out=new FileOutputStream(fileName);  //向d://test.xls中写数据
            row = sheet.createRow(hang);
            Set<String> mapKey = dataset.keySet();
            Iterator<String> iterator = mapKey.iterator();
            int num = 0;
            while (iterator.hasNext()) {
                Cell cell = row.createCell(num);
                num++;
                String key = iterator.next();
                Object obj = dataset.get(key);
                System.out.println("obj:"+obj);
                cell.setCellValue((String) obj);
//
            }

            out.flush();
            wb.write(out);
            out.close();
            System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  //获取d://test.xls



    }
}
