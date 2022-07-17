package ba.nsoft.yellowbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="market")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="market_type", discriminatorType = DiscriminatorType.INTEGER)
public class BaseMarket <T extends Outcome> {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    Status status;

    @OneToMany(targetEntity = Outcome.class)
    private List<T> outcomes;

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

    public List<T> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<T> outcomes) {
        this.outcomes = outcomes;
    }

    public boolean valid (){
        return this.status.equals(Status.ACTIVE);
    }
}
