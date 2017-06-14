package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 6/11/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    enum HealthWarningLevel{
        LOW, NORMAL, HIGH, NO_DATA
    }

    private Long userId;

    @Id
    private String runningId;
    private String latitude;
    private String longitude;
    private String runningDistance;
    private String totalRunningTime;
    private int heartRate;
    private String timestamp;
    private HealthWarningLevel healthWarningLevel = HealthWarningLevel.LOW;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
            @AttributeOverride(name = "address", column = @Column(name = "user_address"))
    })
    private UserInfo userInfo;

    public RunningInformation() {

    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.runningId = runningId;
    }

    public void updateHealthWarningLevel() {
        if (this.heartRate >= 60 && this.heartRate <= 75) {
            this.healthWarningLevel = HealthWarningLevel.LOW;
        } else if (this.heartRate > 75 && this.heartRate <= 120) {
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        } else if (this.heartRate > 200) {
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        } else {
            this.healthWarningLevel = HealthWarningLevel.NO_DATA;
        }
    }
}
