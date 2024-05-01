package task16.objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "building")
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
