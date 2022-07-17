package ba.nsoft.yellowbackend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(targetEntity = EventMarket.class)
    private List<EventMarket> markets;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startsAt;

    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    Status status;

    public List<EventMarket> getMarkets() {
        return markets;
    }

    public void setMarkets(List<EventMarket> markets) {
        this.markets = markets;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean valid () {
        /**
         * Not tested but it makes sense, to me at least.
         */
        return this.status.equals(Status.ACTIVE) && !this.startsAt.before(new Date());
    }
}
