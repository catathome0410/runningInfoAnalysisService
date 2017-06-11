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
        LOW, NORMAL, HIGH
    }

    @Id
    private String runningId;

    private String latitude;
    private String longitude;
    private String runningDistance;
    private String totalRunningTime;
    private int heartRate;
    private String timestamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
            @AttributeOverride(name = "address", column = @Column(name = "user_address"))
    })
    private UserInfo userInfo;

    public RunningInformation() {
        this.heartRate = (int) (60 + 140*Math.random() );
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        this.heartRate = (int) (60 + 140*Math.random() );
        this.runningId = runningId;
    }
}
