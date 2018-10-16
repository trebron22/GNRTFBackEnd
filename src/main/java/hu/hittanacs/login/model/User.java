package hu.hittanacs.login.model;

import hu.hittanacs.login.util.EncryptUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    public void setPassword(String password) {
        this.password = EncryptUtil.getEncryptedString(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
