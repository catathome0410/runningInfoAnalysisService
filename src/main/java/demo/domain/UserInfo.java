package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by vagrant on 6/11/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
public class UserInfo {
    private String username;
    private String address;

    public UserInfo() {
        this.username = "";
        this.address = "";
    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
