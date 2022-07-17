package ba.nsoft.yellowbackend.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class EventMarket extends BaseMarket<EventMarketOutcome> {

    @OneToOne(targetEntity = Market.class, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="market_id")
    private BaseMarket<EventMarketOutcome> market;

    @Column(name="market_id", insertable=false, updatable=false)
    private String marketId;

    public String getMarketId() {
        return marketId;
    }
}
