package pokersite.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Issue extends BaseEntity{
    @Id @Column(name = "id_issue") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    private String title;
    private String body;
    private Timestamp dt_sent;
    public Issue() {
    }
    public Issue(Integer ID, String title, String description, Timestamp dt_sent) {
        this.ID = ID;
        this.title = title;
        this.body = description;
        this.dt_sent = dt_sent;
    }
    public Integer getID() {
        return ID;
    }
    public void setId(Integer ID) {
        this.ID = ID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Timestamp getDt_sent() {
        return dt_sent;
    }
    public void setDt_sent(Timestamp dt_sent) {
        this.dt_sent = dt_sent;
    }
}
