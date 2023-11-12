package pokersite.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Friendship extends BaseEntity {
    @Id @Column(name = "id_friendship") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    private Integer id_user1;
    private Integer id_user2;
    private Timestamp dt_accepted;

    public Friendship() {

    }

    public Friendship(Integer ID, Integer id_user1, Integer id_user2, Timestamp dt_accepted) {
        this.ID = ID;
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
        this.dt_accepted = dt_accepted;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getId_user1() {
        return id_user1;
    }

    public void setId_user1(Integer ID) {
        id_user1 = ID;
    }

    public Integer getId_user2() {
        return id_user2;
    }

    public void setId_user2(Integer ID) {
        id_user2 = ID;
    }

    public Timestamp getDt_accepted() {
        return dt_accepted;
    }

    public void setDt_accepted(Timestamp dt) {
        dt_accepted = dt;
    }
}