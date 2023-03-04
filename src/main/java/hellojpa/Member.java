package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private Long id;
    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // jpa는 내부적으로 리플렉션을 함 --> 동적으로 객체를 생성해야 하기 때문에 기본 생성자가 존재해야함.
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
