package demo.service;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */

@Service
public class RunningInformationAnalysisServiceImpl implements RunningInformationAnalysisService {

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationAnalysisServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInfos) {
        return runningInformationRepository.save(runningInfos);
    }

    @Override
    public void deleteAll() {
        runningInformationRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String id) {
        runningInformationRepository.delete(id);
    }

    @Override
    public List<RunningInformation> findAllRunningInformation() {
        List<RunningInformation> runningInfos = new ArrayList<>();
        runningInformationRepository.findAll().forEach(runningInfos::add);
        return runningInfos;
    }
}
