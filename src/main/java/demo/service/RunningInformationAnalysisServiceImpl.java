package demo.service;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        for (RunningInformation rInfo : runningInfos) {
            rInfo.setHeartRate(60 + (int) (Math.random()*140) );
            rInfo.updateHealthWarningLevel();
        }
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
        return runningInformationRepository.findAll(new Sort(Sort.Direction.DESC, "healthWarningLevel") );
    }

    @Override
    public Page<RunningInformation> findAllRunningInformation(Pageable pageable) {
        return runningInformationRepository.findAll(pageable);
    }
}
