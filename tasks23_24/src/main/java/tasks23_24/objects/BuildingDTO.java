package tasks23_24.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class BuildingDTO {
        private Long id;
        private Date creationDate;
        private String type;
        @JsonProperty("address_id")
        private Long addressId;

}
