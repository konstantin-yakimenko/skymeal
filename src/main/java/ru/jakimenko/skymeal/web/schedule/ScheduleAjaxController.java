package ru.jakimenko.skymeal.web.schedule;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.jakimenko.skymeal.View;
import ru.jakimenko.skymeal.model.Schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    // /file
// 3.1.1 Single file upload
//    @PostMapping("/api/upload")
    // If not @RestController, uncomment this
    //@ResponseBody
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {


        log.debug("yakimky - Single file upload! = {}", request);
        //0. notice, we have used MultipartHttpServletRequest

        //1. get the files from the request object
        Iterator<String> itr =  request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        log.debug("yakimky -- {}", mpf.getOriginalFilename());

//        try {
//            //just temporary save file info into ufile
//            ufile.length = mpf.getBytes().length;
//            ufile.bytes= mpf.getBytes();
//            ufile.type = mpf.getContentType();
//            ufile.name = mpf.getOriginalFilename();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (uploadfile.isEmpty()) {
//            new Exception ("please select a file!");
//        }
        // saveUploadedFiles(Arrays.asList(uploadfile));
//        return new ResponseEntity("Successfully uploaded - " +
//                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }

}
