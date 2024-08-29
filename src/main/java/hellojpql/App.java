package hellojpql;

import jakarta.persistence.*;

import java.util.List;

public class App {
  public static void main(String[] args) {
    //동작 확인
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    //이후 엔티티 매니져를 가져와서 이걸 통해 쿼리 생성 가능

    //DB커넥션을 생성해서 트랜잭션을 호출해야 된다.
    EntityTransaction transaction = em.getTransaction();
    //트랜잭션 시작
    transaction.begin();

    try {
      //TypeQuery,Query
//      Member member = new Member();
//      member.setUsername("member1");
//      member.setAge(10);
//      em.persist(member);
//      em.flush();
//      em.clear();
//
//      TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//      //위와 같이 두번째에 엔티티 객체값을 지정할 수 있다.
//      //이처럼 타입정보를 명확하게 명시한 경우 타입 쿼리를 사용할 수 있다.
//      TypedQuery<String> query1=em.createQuery("select m.username from Member m",String.class);
//      //만약 String이나 int나 단일타입으로 가져온다면 그 타입으로 지정이 되지만
//
//      Query query2 = em.createQuery("select m.username,m.age from Member m");
//      //위 경우 String과 int값 두개를 가져오기 때문에 서로 다른 타입이기 때문에 타입쿼리가
//      //불가능하다.
//      //타입을 모르기 때문에 Query타입을 사용해서 값을 받아야 한다.

      //결과 조회
//      Member member = new Member();
//      member.setUsername("member1");
//      member.setAge(10);
//      em.persist(member);
//      em.flush();
//      em.clear();

      //반환값이 컬렉션일 경우
//      TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//      List<Member> resultList = query.getResultList();
      //이렇게 컬렉션을 반환할 수 있다.
//      for(Member member1 : resultList){
//        System.out.println("member = " + member1);
//      }
      //반환값이 없을 경우 빈 리스트를 반환해준다.

      //반환값이 단일 객체일 경우
//      TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.id=100", Member.class);
//      Member singleResult = query1.getSingleResult();
//      System.out.println("singleResult = " + singleResult);
      //이렇게 단일 객체를 할 수 있다.
      //하지만 단일 객체 결과일 경우
//      결과가 없으면 NoResultException
//      둘 이상일 경우 NonUniqueResultException에러가 나온다.
      //그렇기에 진짜 단일 결과일 경우에만 사용해야 된다.
      //결과가 없는데 익셉션이 터지면 try / catch를 해야되기 떄문에
      //스프링 데이터 jpa를 사용할 때 스프링에서는 그냥 null이나 옵셔널로 반환한다.
      //스프링 내부에서 한번 트라이캐치로 옵셔널이나 null을 반환하도록 해놓는다.

      //파라미터 바인딩
//      Member member = new Member();
//      member.setUsername("member1");
//      member.setAge(10);
//      em.persist(member);
//      em.flush();
//      em.clear();
//      //이름기준
//      TypedQuery<Member> query =
//              em.createQuery("select m from Member m where m.username=:username", Member.class);
//      query.setParameter("username","member1");
//      Member singleResult = query.getSingleResult();
//      System.out.println("singleResult = " + singleResult);
//
//      //보통은 위같이 안하고 체이닝 기법을 통해 엮는데
//      Member singleResult1 = em.createQuery("select m from Member m where m.username=:username", Member.class)
//              .setParameter("username", "member1")
//              .getSingleResult();
//      //이와 같이 묶어낸다.
//
//      //위치기반 파라미터 바인딩 >>위치기반 쓰지마라.
//      Member singleResult2 = em.createQuery("select m from Member m where m.username=?1", Member.class)
//              .setParameter(1, "member1")
//              .getSingleResult();
//      //이건 위치가 바뀌면 버그가 일어날 수 있다.

      //프로젝션
//      Member member = new Member();
//      member.setUsername("member1");
//      member.setAge(10);
//      em.persist(member);
//      em.flush();
//      em.clear();

//      //엔티티 프로젝션
//      List<Member> resultList =
//              em.createQuery("select m from Member m", Member.class).getResultList();
//      //이때 컬렉션 내부의 Member들은 영속성 컨텍스트에서 관리가 될까?
//      Member member1 = resultList.get(0);
//      member1.setAge(20);
//      //이때 업데이트 쿼리가 나가는데 age가 20으로 변경되어 있다.
////      엔티티 프로젝션을 하면 컬렉션 전부 영속성 컨텍스트에서 관리한다.
////      List<Team> resultTeamList =
////              em.createQuery("select m.team from Member m", Team.class).getResultList();
//      //이렇게 관련된 팀 정보도 받을 수 있다. 하지만 여기서 TEAM은 다른 테이블에 있어서
//      //Join쿼리가 나가는데
//      //실제 SQL은 조인 쿼리가 나간다 TEAM에서 조회하는 것이 아니다.
//      //이런 묵시적 조인은 좋지 않다.
//      //JPQL은 최대한 SQL과 같도록 해야 된다 그래서 이런 경우에는
//      List<Team> resultTeamList =
//              em.createQuery("select t from Member m join m.team t", Team.class).getResultList();
//      //이렇게 SQL과 최대한 유사하도록 해야 된다. 유지보수 차원에서도 이렇게 예측 가능하게 설계하는 게
//      //좋다.

      //임베디드 타입 프로젝션
//      List<Address> resultTeamList =
//              em.createQuery("select o.address from Order o", Address.class).getResultList();
      //address는 다른 엔티티에 소속되어 있기에 Address자체로 찾는 건 불가능하다.
      //소속되어 있는 엔티티를 지정해줘야한다.

      //스칼라타입 프로젝션
//      em.createQuery("select distinct m.username,m.age from Member m").getResultList();
      //일반 SQL과 유사하다. 타입이 두개인데 이걸 어떻게 가져올 수 있을까?
//      1.Query타입으로 조회
//      List resultList=em.
//              createQuery("select distinct m.username,m.age from Member m")
//              .getResultList();

//      Object o = resultList.get(0);
//      Object[] result =(Object[]) o;
//      //이렇게 오브젝트 타입이 들어가 있다. 결국 타입 케스팅을 해야된다.
//      System.out.println("result = " + result[0]);
//      System.out.println("result[1] = " + result[1]);
//      result = member1
//      result[1] = 10
//      이렇게 배열로 오브젝트 타입이 들어가있는 것을 알 수 있다.
//      타입명시가 안되기 때문에 오브젝트 타입으로 반환해주는 것

//      2.Object[]타입으로 조회
//      List<Object[]> resultList=em.
//              createQuery("select distinct m.username,m.age from Member m")
//              .getResultList();
//      Object[] result =resultList.get(0);
//      System.out.println("result = " + result[0]);
//      System.out.println("result[1] = " + result[1]);
      //타입 케스팅 과정을 생략해서 오브젝트 배열로 바로 받을 수 있다.\

//      3.new명령어로 조회
//      List<MemberDTO> resultList = em.createQuery("select new hellojpql.MemberDTO(m.username,m.age) from Member m", MemberDTO.class)
//              .getResultList();
      //엔티티가 아닌 다른 객체를 가져오고 싶은 경우 위와 같이 생성자를 통해 호출이 되도록한다.'
      //문자이기 때문에 패키지 명을 포함한 전체 클래스명 및 순서와 타입이 일치하는 생성자가 필요
//      MemberDTO memberDTO=resultList.get(0);
//      System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//      System.out.println("memberDTO.getAge() = " + memberDTO.getAge());


      //페이징API
      for (int i=0;i<100;i++){
        Member member = new Member();
        member.setUsername("member"+i);
        member.setAge(i);
        em.persist(member);
      }

      em.flush();
      em.clear();
      List<Member> resultList = em.createQuery("select m from Member m order by m.age desc", Member.class)
              .setFirstResult(0)
              .setMaxResults(10)
              .getResultList();
      //페이징할 때는 order by정렬이 필수>>소팅이 되면서 순서대로 가져와야되기 때문
      System.out.println("res = " + resultList);
      //desc로 했으니 역순으로 나오는데
      //이때 나오는 limit ? offset ?이라는 쿼리가 나오는데
      //지금 DB방언이 H2 db라서 위처럼 리밋트 오프셋이 나가는것

      transaction.commit();
    }catch (Exception e){
      transaction.rollback();
      System.out.println("e = " + e);
    }finally {
      //메니져와 팩토리 닫기
      em.close();
      //엔티티메니져가 내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 성능을 위해서는
      //호출 후 닫아줘야 한다.
    }
    entityManagerFactory.close();


  }
}

