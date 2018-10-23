package me.jy.rds.canteentime.web;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import me.jy.rds.canteentime.dto.CanteentimeDto;
import me.jy.rds.canteentime.service.CanteentimeService;
import me.jy.rds.common.base.BaseResult;
import me.jy.rds.common.utils.EasyPoiUtil;
import me.jy.rds.org.model.OrgUser;
import me.jy.rds.org.service.OrgUserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.applet.Main;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/22 17:53
 */
@Controller
@RequestMapping("/canteentime")
public class CanteentimeController {

    @Autowired
    private CanteentimeService canteenTimeService;

    @Autowired
    private me.jy.rds.org.service.OrgUserService orgUserService;

    @RequestMapping("/uploadExcel")
    @ResponseBody
    public BaseResult uploadExcel(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        if(!file.isEmpty()){
//            List<CanteentimeDto> canteentimeDtos = EasyPoiUtil.importExcel(file, 1, 1, CanteentimeDto.class);
            return canteenTimeService.saveList(EasyPoiUtil.importExcel(file, 1, 1, CanteentimeDto.class));
//            ImportParams importParams = new ImportParams();
//            ExcelDataHandlerDefaultImpl<CanteentimeDto> excelDataHandlerDefault = new ExcelDataHandlerDefaultImpl<CanteentimeDto>() {
//                @Override
//                public Object importHandler(CanteentimeDto obj, String name, Object value) {
//                    System.out.println(obj);
//                    System.out.println(name);
//                    System.out.println(value);
//                    return super.importHandler(obj, name, value);
//                }
//            };
//            excelDataHandlerDefault.setNeedHandlerFields(new String[] { "姓名" });
//            importParams.setNeedVerfiy(true);
//            importParams.setTitleRows(1);
//            importParams.setHeadRows(1);
//            importParams.setDataHandler(excelDataHandlerDefault);
//            try {
//                ExcelImportResult<CanteentimeDto> result = ExcelImportUtil.importExcelMore(file.getInputStream(), CanteentimeDto.class,
//                        importParams);
//                List<CanteentimeDto> successList = result.getList();
//                List<CanteentimeDto> failList = result.getFailList();
           /* } catch (Exception e) {
                e.printStackTrace();

            }*/

//             List<CanteentimeDto> canteentimeDtos = EasyPoiUtil.importExcel(file, 1, 1, CanteentimeDto.class);
            /* if(canteentimeDtos.size()>0){
                 return canteentimeService.saveList(canteentimeDtos);
             }*/

        }

/*        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            Workbook hssfWorkbook = null;
            InputStream is = file.getInputStream();
            if (fileName.endsWith("xlsx")){
                hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
            }else if (fileName.endsWith("xls")){
                hssfWorkbook = new HSSFWorkbook(is);//Excel 2003
            }
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet <hssfWorkbook.getNumberOfSheets(); numSheet++) {
                Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    if(rowNum==1)continue;
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        Cell a = hssfRow.getCell(0);
                        Cell b = hssfRow.getCell(1);
                        System.out.println(a.toString());
                        System.out.println(b.toString());
                    }

                }
            }
        }*/
        return null;

    }



    }
