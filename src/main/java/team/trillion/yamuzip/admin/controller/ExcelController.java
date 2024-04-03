package team.trillion.yamuzip.admin.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.trillion.yamuzip.admin.model.dto.CalcDTO;
import team.trillion.yamuzip.admin.model.service.CalcService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Controller
public class ExcelController {

    private final CalcService calcService;

    public ExcelController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/admin/excel")
    public void downloadExcel(@RequestParam(name = "selectMonth", required = false) String selectMonth,
                              HttpServletResponse response){

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("monthlyCalc");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("정산번호");
        headerRow.createCell(1).setCellValue("주문번호");
        headerRow.createCell(2).setCellValue("정산금액");
        headerRow.createCell(3).setCellValue("예금주");
        headerRow.createCell(4).setCellValue("계좌번호");
        headerRow.createCell(5).setCellValue("은행명");
        headerRow.createCell(6).setCellValue("서비스진행일");

        List<CalcDTO> excelList = calcService.createExcel(selectMonth);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        for (int i = 0; i < excelList.size(); i++) {
            Row bodyRow = sheet.createRow(i + 1);
            bodyRow.createCell(0).setCellValue(i + 1);
            bodyRow.createCell(1).setCellValue(excelList.get(i).getOrderCode());
            bodyRow.createCell(2).setCellValue(excelList.get(i).getPayPrice());
            bodyRow.createCell(3).setCellValue(excelList.get(i).getAccName());
            bodyRow.createCell(4).setCellValue(excelList.get(i).getAccNumber());
            bodyRow.createCell(5).setCellValue(excelList.get(i).getAccBank());
            // 날짜 출력 포맷 변경
            bodyRow.createCell(6).setCellValue(formatter.format(excelList.get(i).getReserveDatetime()));
        }

        String fileName = null;
        try {
            fileName = URLEncoder.encode(selectMonth+"yamuzip.xls", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setContentType("application/vnd.ms-excel");

        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
