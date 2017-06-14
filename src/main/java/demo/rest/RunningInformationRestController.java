package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */

@RestController
public class RunningInformationRestController {

    private RunningInformationAnalysisService runningInformationAnalysisService;

    @Autowired
    public RunningInformationRestController(RunningInformationAnalysisService runningInformationAnalysisService) {
        this.runningInformationAnalysisService = runningInformationAnalysisService;
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInfos) {
        this.runningInformationAnalysisService.saveRunningInformation(runningInfos);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAllRunningInfo(@RequestParam(name = "page") int page) {
        return runningInformationAnalysisService.findAllRunningInformation(new PageRequest(page, 2, Sort.Direction.DESC, "healthWarningLevel") );
    }

    @RequestMapping(value = "/runningInfo/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id) {
        runningInformationAnalysisService.deleteByRunningId(id);
    }
}
