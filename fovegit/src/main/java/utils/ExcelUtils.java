package utils;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/** author zhengxuelin 20160108
  * ExcelUtils
 * 1；读取“.xls”格式使用  import org.apache.poi.hssf.usermodel.*;包的内容，例如：HSSFWorkbook
 * 2：读取“.xlsx”格式使用 import org.apache.poi.xssf.usermodel.*; 包的内容，例如：XSSFWorkbook
 *:3：读取两种格式使用    import org.apache.poi.ss.usermodel.*    包的内容，例如：Workbook
 * HSSFWorkbook	excel的文档对象
 * HSSFSheet	excel的表单Sheet
 * HSSFRow	excel的行
 * HSSFCell	excel的单元格
 * HSSFFont	excel字体
 * HSSFDataFormat	日期格式
 * HSSFHeader	sheet头
 * HSSFFooter	sheet尾（只有打印的时候才能看到效果）和这个样式
 * HSSFCellStyle	cell样式
 * HSSFDateUtil	日期
 * HSSFPrintSetup	打印
 * HSSFErrorConstants	错误信息表
 */

 public class ExcelUtils {
    private static Logger logger=Logger.getLogger(ExcelUtils.class);
    public static void main(String []args){
        ExcelUtils excelUtils=new ExcelUtils();
        excelUtils.readXlsx("D:\\个人资料\\1.xlsx");

    }

    public List readXlsx(String path)  {
        logger.info("进入ExcelUtils.readXlsx解析模块：path={}"+path);

        try {
            InputStream input = new FileInputStream(path);  //建立输入流
            Workbook wb  = null;
            //根据文件格式(2003(.xls)或者2007(.xlsx))来初始化
            if(path.contains("xlsx"))
                wb = new XSSFWorkbook(input);
            else
                wb = new HSSFWorkbook(input);
            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单
            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
            while (rows.hasNext()) {
                Row row = rows.next();  //获得行数据
                logger.info("Row #" + row.getRowNum());  //获得行号从0开始
                Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    logger.info("Cell #" + cell.getColumnIndex());
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            logger.info(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            logger.info(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            logger.info(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            logger.info(cell.getCellFormula());
                            break;
                        default:
                            logger.info("unsuported sell type");
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }





}




