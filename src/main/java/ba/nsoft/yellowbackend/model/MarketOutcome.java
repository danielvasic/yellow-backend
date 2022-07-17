package ba.nsoft.yellowbackend.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class MarketOutcome extends Outcome {
    @Column(name="name", length = 50, nullable = true)
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
