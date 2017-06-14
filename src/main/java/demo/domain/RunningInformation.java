package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
        NO_DATA, LOW, NORMAL, HIGH
    }

    private Long userId;
    private static Long userIdCounter = 0l;

    @Id
    private String runningId;

    @JsonIgnore
    private String latitude;
    @JsonIgnore
    private String longitude;
    @JsonIgnore
    private String runningDistance;

    private String totalRunningTime;
    private int heartRate;

    @JsonIgnore
    private String timestamp;
    private HealthWarningLevel healthWarningLevel = HealthWarningLevel.LOW;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
            @AttributeOverride(name = "address", column = @Column(name = "user_address"))
    })
    private UserInfo userInfo;

    public RunningInformation() {
        userIdCounter++;
        this.userId = userIdCounter;
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.runningId = runningId;
        userIdCounter++;
        this.userId = userIdCounter;
    }

    public void updateHealthWarningLevel() {
        if (this.heartRate >= 60 && this.heartRate <= 75) {
            this.healthWarningLevel = HealthWarningLevel.LOW;
        } else if (this.heartRate > 75 && this.heartRate <= 120) {
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        } else if (this.heartRate > 120) {
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        } else {
            this.healthWarningLevel = HealthWarningLevel.NO_DATA;
        }
    }
}
