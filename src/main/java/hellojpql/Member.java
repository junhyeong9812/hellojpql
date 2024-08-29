package hellojpql;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    //Team과 연관관계 생성
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
    //투스트링 만들 때 양방향 되면 순환구조 나오고 ㅈㄴ큰일난다.


}
