package models;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class User {

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    @JoinColumn(name="mId")
    private UserEntity mData;

    public UserEntity getData() {
        return mData;
    }

    public void setmData(UserEntity mData) {
        this.mData = mData;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public User() {
    }
}
