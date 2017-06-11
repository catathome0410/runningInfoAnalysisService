package demo.service;

import demo.domain.RunningInformation;

import java.util.List;

/**
 * Created by vagrant on 6/11/17.
 */
public interface RunningInformationAnalysisService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInfos);

    void deleteAll();

    void deleteByRunningId(String id);

    List<RunningInformation> findAllRunningInformation();
}
