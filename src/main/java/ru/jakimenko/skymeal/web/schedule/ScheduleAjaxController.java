package ru.jakimenko.skymeal.web.schedule;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.jakimenko.skymeal.View;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.model.Schedule;
import ru.jakimenko.skymeal.service.IPlaneService;
import ru.jakimenko.skymeal.to.ScheduleTo;
import ru.jakimenko.skymeal.util.ScheduleUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by konst on 07.05.17.
 */
@RestController
@RequestMapping("/ajax/admin/schedules")
public class ScheduleAjaxController extends AbstractScheduleController {

    @Autowired
    @Qualifier("planeService")
    private IPlaneService planeService;

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
        List<Plane> planes = planeService.getAll();
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());
        List<ScheduleTo> scheduleTos = uploadSchedule(mpf);
        for (ScheduleTo scheduleTo : scheduleTos) {
            Schedule schedule = ScheduleUtil.createNewFromTo(scheduleTo);
            planes.stream()
                    .filter(p->p.getName()
                            .replaceAll("-","")
                            .equalsIgnoreCase(scheduleTo.getPlane()
                                    .replaceAll("-","")))
                    .findFirst().ifPresent(plane1 -> {
                        schedule.setPlane(plane1);
                        super.create(schedule);
                    });
        }
    }

    private List<ScheduleTo> uploadSchedule(MultipartFile mpf) {
        log.debug("yakimky -- {}", mpf.getOriginalFilename());
        List<ScheduleTo> res = new ArrayList<>();
        try {
            InputStream stream = mpf.getInputStream();
            XSSFWorkbook myWorkBook = new XSSFWorkbook(stream);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator<Cell> cellIter = myRow.cellIterator();
                ScheduleTo scheduleTo = createScheduleFromRow(cellIter);
                if (!scheduleTo.isEmpty()) {
                    res.add(scheduleTo);
                }
            }
        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }
        return res;
    }

    private ScheduleTo createScheduleFromRow(final Iterator<Cell> cellIter) {
        final ScheduleTo scheduleTo = new ScheduleTo();

        while(cellIter.hasNext()) {
            final XSSFCell cell = (XSSFCell) cellIter.next();
            if (cell.getColumnIndex() == 0 && cell.getCellType() == Cell.CELL_TYPE_STRING) {
                scheduleTo.setEmpty();
                return scheduleTo;
            }
            switch (cell.getColumnIndex()) {
                case 0:
                    Date date = cell.getDateCellValue();
                    scheduleTo.setDate(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
                    break;
                case 1:
                    scheduleTo.setNumber((int) cell.getNumericCellValue());
                    break;
                case 2:
                    Date regionDate = cell.getDateCellValue();
                    scheduleTo.setRegionDate(LocalDateTime.ofInstant(regionDate.toInstant(), ZoneId.systemDefault()));
                    break;
                case 3:
                    Date planStart = cell.getDateCellValue();
                    scheduleTo.setPlanStart(LocalDateTime.ofInstant(planStart.toInstant(), ZoneId.systemDefault()));
                    break;
                case 4:
                    Date planFinish = cell.getDateCellValue();
                    scheduleTo.setPlanFinish(LocalDateTime.ofInstant(planFinish.toInstant(), ZoneId.systemDefault()));
                    break;
                case 5:
                    scheduleTo.setAirportStart(cell.getStringCellValue());
                    break;
                case 6:
                    scheduleTo.setAirportFinish(cell.getStringCellValue());
                    break;
                case 7:
                    Date factStart = cell.getDateCellValue();
                    scheduleTo.setFactStart(LocalDateTime.ofInstant(factStart.toInstant(), ZoneId.systemDefault()));
                    break;
                case 8:
                    Date factFinish = cell.getDateCellValue();
                    scheduleTo.setFactFinish(LocalDateTime.ofInstant(factFinish.toInstant(), ZoneId.systemDefault()));
                    break;
                case 9:
                    Date factStartUtc = cell.getDateCellValue();
                    scheduleTo.setFactStartUtc(LocalDateTime.ofInstant(factStartUtc.toInstant(), ZoneId.systemDefault()));
                    break;
                case 10:
                    Date factFinishUtc = cell.getDateCellValue();
                    scheduleTo.setFactFinishUtc(LocalDateTime.ofInstant(factFinishUtc.toInstant(), ZoneId.systemDefault()));
                    break;
                case 11:
                    scheduleTo.setAirportFact(cell.getStringCellValue());
                    break;
                case 12:
                    scheduleTo.setPlane(cell.getStringCellValue());
                    break;
                case 14:
                    scheduleTo.setPasEconom((int) cell.getNumericCellValue());
                    break;
                case 15:
                    scheduleTo.setPasBusiness((int) cell.getNumericCellValue());
                    break;
                case 17:
                    scheduleTo.setPilots((int) cell.getNumericCellValue());
                    break;
                case 18:
                    scheduleTo.setStrewards((int) cell.getNumericCellValue());
                    break;
                default:
//                    log.error("Error while get cell Value: {}", cell.getRawValue());
//                    scheduleTo.setEmpty();
                    break;
            }
        }
        log.debug("----> {}", scheduleTo);
        return scheduleTo;
    }

}
