package pokersite.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message extends BaseEntity {
    @Id @Column(name = "id_message") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    private Integer id_user_sender;
    private Integer id_user_receiver;
    private String message;
    private Timestamp dt_sent;

    @Override
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDt_sent() {
        return dt_sent;
    }

    public void setDt_sent(Timestamp dt_sent) {
        this.dt_sent = dt_sent;
    }
}
