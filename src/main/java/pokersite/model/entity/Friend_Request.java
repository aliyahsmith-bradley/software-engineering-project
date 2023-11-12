package pokersite.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
/*@Table(name = "friend_request")*/
public class Friend_Request extends BaseEntity {
    @Id @Column(name = "id_friend_request") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    private Integer id_user_sender;
    private Integer id_user_receiver;
    private byte status;
    private Timestamp dt_sent;

    public Friend_Request() {
    }

    public Friend_Request(Integer ID, Integer id_user_sender, Integer id_user_receiver, byte status, Timestamp dt_sent) {
        this.ID = ID;
        this.id_user_sender = id_user_sender;
        this.id_user_receiver = id_user_receiver;
        this.status = status;
        this.dt_sent = dt_sent;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {this.ID = ID;}

    public Integer getId_user_sender() {
        return id_user_sender;
    }

    public void setId_user_sender(Integer id_user_sender) {
        this.id_user_sender = id_user_sender;
    }

    public Integer getId_user_receiver() {
        return id_user_receiver;
    }

    public void setId_user_receiver(Integer id_user_receiver) {
        this.id_user_receiver = id_user_receiver;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Timestamp getDt_sent() {
        return dt_sent;
    }

    public void setDt_sent(Timestamp dt_sent) {
        this.dt_sent = dt_sent;
    }
}
