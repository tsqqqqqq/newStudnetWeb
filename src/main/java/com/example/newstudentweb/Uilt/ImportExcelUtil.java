package com.example.newstudentweb.Uilt;


import com.example.newstudentweb.model.Student;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class ImportExcelUtil {
    /**
     * 导入的数据转换成对象
     * @param file
     * @return
     */
    public List<Student> getUserList(File file) throws Exception {
        List<Student> listAj = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(file);//io流的输入流
            @SuppressWarnings("resource")
            //XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
                    HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            // 循环工作表Sheet
            int numberOfSheet = hssfWorkbook.getNumberOfSheets();//获取总行数
            for (int numSheet = 0; numSheet < numberOfSheet; numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                listAj.addAll(getItemSheetData(hssfSheet));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listAj;
    }

    /**
     * 获取每个Sheet中的数据
     * @param hssfSheet
     * @return
     */
    private List<Student> getItemSheetData(HSSFSheet hssfSheet) throws Exception {
        List<Student> listAj = new ArrayList<>();
        // 循环行Row
        int rowNumCount = hssfSheet.getLastRowNum();
        for (int rowNum = 2; rowNum <= rowNumCount; rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow == null) {
                continue;
            }
            if(isInvalidRow(hssfRow)){
                continue;
            }
            listAj.add(getItemAj(hssfRow));
        }
        return listAj;
    }

    /**
     * 判断是否是无效行
     * @param hssfRow
     * @return
     * @throws Exception
     */
    private boolean isInvalidRow(HSSFRow hssfRow) throws Exception {
        Boolean flag = true;
        for(int i=1 ; i<55 ; i++){
            if(StringUtils.isNotEmpty(getValue(hssfRow.getCell(i)))){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 获取用户的属性
     * @param hssfRow
     */
    private Student getItemAj(HSSFRow hssfRow) throws Exception {
        Student g = new Student();
        g.setStudentName(getValue(hssfRow.getCell(0)));//学生姓名
        g.setStudentAge(Integer.valueOf(getValue(hssfRow.getCell(1))));//学生年龄
        g.setStudentSex(getValue(hssfRow.getCell(2)));//学生性别
        g.setStudentIdNum(getValue(hssfRow.getCell(3)));//学生身份证号码
        g.setStudentType(Integer.valueOf(getValue(hssfRow.getCell(4))));//学生类型
        g.setStudentExamNum(getValue(hssfRow.getCell(5)));//准考证号码
        g.setStudentPhone(getValue(hssfRow.getCell(6)));//联系方式
        g.setStudentAddr(getValue(hssfRow.getCell(7)));//地址
        g.setStudentEmail(getValue(hssfRow.getCell(8)));//邮件
        g.setStudentMoney(Integer.valueOf(getValue(hssfRow.getCell(9))));//缴费金额
        g.setMajorId(Integer.valueOf(getValue(hssfRow.getCell(10))));//专业ID
        return g;
    }

    /**
     * 取值
     * @param hssfCell
     * @return
     */
    private String getValue(HSSFCell hssfCell) throws Exception {
        if (null == hssfCell) {
            return null;
        }
        try {
            //日期
            if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    return format.format(hssfCell.getDateCellValue());
                } else {
                    Double reseve = hssfCell.getNumericCellValue();
                    return String.valueOf(reseve.longValue());
                }
            } else {
                //返回字符串类型的值
                return String.valueOf(hssfCell.getStringCellValue()).trim();
            }
        } catch (Exception e) {
            throw new Exception("读取Excel内容出错");
        }

    }
}