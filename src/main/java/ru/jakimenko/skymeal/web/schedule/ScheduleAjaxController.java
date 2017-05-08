package ru.jakimenko.skymeal.web.schedule;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.jakimenko.skymeal.View;
import ru.jakimenko.skymeal.model.Schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by konst on 07.05.17.
 */
@RestController
@RequestMapping("/ajax/admin/schedules")
public class ScheduleAjaxController extends AbstractScheduleController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public List<Schedule> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public Schedule get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid Schedule plane) {
        if (plane.isNew()) {
            super.create(plane);
        } else {
            super.update(plane);
        }
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {


        log.debug("yakimky - Single file upload! = {}", request);
        Iterator<String> itr =  request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        log.debug("yakimky -- {}", mpf.getOriginalFilename());
        try {
            InputStream stream = mpf.getInputStream();

// Create a workbook using the File System
            XSSFWorkbook myWorkBook = new XSSFWorkbook(stream);

            // Get the first sheet from workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            /** We now need something to iterate through the cells.**/
            Iterator<Row> rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){

                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator<Cell> cellIter = myRow.cellIterator();
                while(cellIter.hasNext()){

                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    //get cell index
                    log.debug("Cell column index: {}", myCell.getColumnIndex());
                    //get cell type
                    log.debug("Cell Type: {}", myCell.getCellType());

                    switch (myCell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            log.debug("Cell Value: {}", myCell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            log.debug("Cell Value: {}", myCell.getStringCellValue());
                            break;
                        default:
                            log.debug("Cell Value: {}", myCell.getRawValue());
                            break;
                    }
                }
            }
        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }


//            ufile.length = mpf.getBytes().length;
//            ufile.bytes= mpf.getBytes();
//            ufile.type = mpf.getContentType();
//            ufile.name = mpf.getOriginalFilename();



    }

}
