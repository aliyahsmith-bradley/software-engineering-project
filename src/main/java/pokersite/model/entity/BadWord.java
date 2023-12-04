package pokersite.model.entity;

import javax.persistence.*;

@Entity
public class BadWord extends BaseEntity {
    @Id @Column(name = "id_badword") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;
    private String badword;

    public BadWord() {

    }

    public BadWord(Integer ID, String badword) {
        this.ID = ID;
        this.badword = badword;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getBadword() {
        return badword;
    }

    public void setBadword(String badword) {
        this.badword = badword;
    }
}
