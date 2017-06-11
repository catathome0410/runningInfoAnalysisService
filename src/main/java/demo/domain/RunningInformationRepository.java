package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vagrant on 6/11/17.
 */
public interface RunningInformationRepository extends JpaRepository<RunningInformation, String> {

}
