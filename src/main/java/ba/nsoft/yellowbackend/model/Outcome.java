package ba.nsoft.yellowbackend.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="outcome_type", discriminatorType = DiscriminatorType.INTEGER)
public class Outcome {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
