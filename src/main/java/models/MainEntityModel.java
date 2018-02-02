package models;

import javax.persistence.*;

@Entity
@Table(name = "main_entity")
public class MainEntityModel {

    @Id
    private Long mId;

    private Long mZipCode;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User mUser;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Long getmZipCode() {
        return mZipCode;
    }

    public void setmZipCode(Long mZipCode) {
        this.mZipCode = mZipCode;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }
}
