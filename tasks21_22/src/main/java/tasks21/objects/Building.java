package tasks21.objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "building")
@ToString
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable=false)
    Address address;

}
