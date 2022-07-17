package ba.nsoft.yellowbackend.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class EventMarketOutcome extends Outcome {
    @Column(name="odd")
    private double odd;

    @OneToOne(targetEntity = MarketOutcome.class)
    @JoinColumn(name="outcome_id")
    private MarketOutcome outcome;

    @Column(name="outcome_id", insertable=false, updatable=false)
    private String outcomeId;

    public String getOutcomeId() {
        return outcomeId;
    }

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }
}
