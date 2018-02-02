package models;

import javax.persistence.*;

@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    private Long mId;

    private String mUsername;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }
}
