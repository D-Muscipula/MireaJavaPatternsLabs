package task18.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "address_text")
    private String addressText;
    @Column(name = "zip_code")
    private String zipCode;
    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Building> buildingList;

}
