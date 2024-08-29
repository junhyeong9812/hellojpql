package hellojpql;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    //Team과 연관관계 생성
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    //패치타입을 레이지로 안두면 team도 같이 조인한다.

    @Enumerated(EnumType.STRING)
    private MemberType type;

    public MemberType getType() {
        return type;
    }

    public void setType(MemberType type) {
        this.type = type;
    }

    public void changeTeam(Team team){
        this.team=team;
        team.getMembers().add(this);
    }


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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
