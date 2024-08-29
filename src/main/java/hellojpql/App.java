package hellojpql;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
//      for (int i=0;i<100;i++){
//        Member member = new Member();
//        member.setUsername("member"+i);
//        member.setAge(i);
//        em.persist(member);
//      }

//      em.flush();
//      em.clear();
//      List<Member> resultList = em.createQuery("select m from Member m order by m.age desc", Member.class)
//              .setFirstResult(0)
//              .setMaxResults(10)
//              .getResultList();
      //페이징할 때는 order by정렬이 필수>>소팅이 되면서 순서대로 가져와야되기 때문
//      System.out.println("res = " + resultList);
      //desc로 했으니 역순으로 나오는데
      //이때 나오는 limit ? offset ?이라는 쿼리가 나오는데
      //지금 DB방언이 H2 db라서 위처럼 리밋트 오프셋이 나가는것

      //조인
//      Team team= new Team();
//      team.setName("TeamA");
//      em.persist(team);
//
//      Member member = new Member();
//        member.setUsername("member1");
//        member.setAge(10);
//        member.setTeam(team);
//        member.setType(MemberType.ADMIN);
//        //원래는 양방향 연관관계로 세팅해야 된다.
//        em.persist(member);

//        String joinQuery="select m from Member m inner join m.team t";
//        //inner는 생략 가능
//      List<Member> resultList = em.createQuery(joinQuery, Member.class)
//              .getResultList();
//      //이너조인으로 나가는 것을 볼 수 있다.
//      System.out.println("resultList = " + resultList);

//      //left outer join
//      String joinQuery="select m from Member m left outer join m.team t";
//      //outer는 생략 가능
//      List<Member> resultList = em.createQuery(joinQuery, Member.class)
//              .getResultList();
//      //이너조인으로 나가는 것을 볼 수 있다.
//      System.out.println("resultList = " + resultList);

//      //Setter조인
//      String joinQuery="select m from Member m,Team t where m.username=t.name";
//      //outer는 생략 가능
//      List<Member> resultList = em.createQuery(joinQuery, Member.class)
//              .getResultList();
//      //이너조인으로 나가는 것을 볼 수 있다.
//      System.out.println("resultList = " + resultList);

//      //조인대상 필터링
//      String joinQuery="select m from Member m left join Team t on t.name='teamA'";
//      //outer는 생략 가능
//      List<Member> resultList = em.createQuery(joinQuery, Member.class)
//              .getResultList();
//      //이너조인으로 나가는 것을 볼 수 있다.
//      System.out.println("resultList = " + resultList);

//      //연관관계 없는 엔티티 외부 조인
//      String joinQuery="select m from Member m left join Team t on m.username=t.name";
//      //outer는 생략 가능
//      List<Member> resultList = em.createQuery(joinQuery, Member.class)
//              .getResultList();
//      System.out.println("resultList = " + resultList);

      //서브쿼리
      //where절 서브쿼리
//      String joinQuery="select m from Member m " +
//              "where m.age >= (select avg(m2.age) from Member m2)";
      //팀A에 속한 회원 검색(exists)
//      String joinQuery="select m from Member m " +
//              "where exists (select t from m.team t where t.name = 'TeamA')";
//      //Any쿼리
//      String joinQuery="select m from Member m " +
//              "where m.team = ANY (select t from Team t)";
//      //All쿼리
//      String joinQuery="select m from Member m " +
//              "where m.team = ALL (select t from Team t)";
//
//      List<Member> resultList = em.createQuery(joinQuery, Member.class)
//              .getResultList();
//      System.out.println("resultList = " + resultList);

      //스트링 타입

//      String Query="select m.username,'HELLO',TRUE from Member m " +
//              "where m.type= hellojpql.MemberType.ADMIN";
      //이렇게 이넘타입은 직접 패키지를 전부 기입해줘야 한다.
//      String Query="select m.username,'HELLO',TRUE from Member m " +
//              "where m.type= :userType";
//      List<Object[]> resultList = em.createQuery(Query)
//              .setParameter("userType",MemberType.ADMIN)
//              .getResultList();
//      for (Object[] row : resultList) {
//        System.out.println("row[0] = " + row[0]);
//        System.out.println("row[1] = " + row[1]);
//        System.out.println("row[2] = " + row[2]);
//      }
//      System.out.println("resultList = " + resultList);
      
      //기본 CASE식
//      String query =
//              "select " +
//                      "case when m.age <= 10 then '학생요금' " +
//                      "     when m.age >= 60 then '경로요금' " +
//                      "     else '일반요금' end " +
//              "from Member m ";
//      List<String> result = em.createQuery(query, String.class).getResultList();
//      for(String s : result){
//        System.out.println("s = " + s);
//      }

//      //조건 CASE식
//      String query =
//              "select " +
//                      "case t.name " +
//                      "when 'TeamA' then '인센티브110%' " +
//                      "when 'TeamB' then '인센티브120%' " +
//                      "else '인센티브105%' " +
//                      "end " +
//                      "from Team t ";
//      List<String> result = em.createQuery(query, String.class).getResultList();
//      for(String s : result){
//        System.out.println("s = " + s);
//      }
//      //s = 인센티브110%

//      //COALESCE : 하나씩 조회
//      String query =
//              "select coalesce(m.username, '이름 없는 회원') from Member m";
//      //이름 없는 회원이 나오면 이름없는 회원 아니면 이름이 나온다.
//      List<String> result = em.createQuery(query, String.class).getResultList();
//      for(String s : result){
//        System.out.println("s = " + s);
//      }
//
      //nullIF :두 값이 같으면 null 아니면 처음 값
//      String query =
//              "select nullif(m.username, 'member1') from Member m";
//      //이름 없는 회원이 나오면 이름없는 회원 아니면 이름이 나온다.
//      List<String> result = em.createQuery(query, String.class).getResultList();
//      for(String s : result){
//        System.out.println("s = " + s);
//      }
      //s = null
      //이름이 같아서 null이 나오는데 이건 보통 관리자의 이름을 숨길 때 사용하게 된다.
      //이 함수들은 표줌함수라 어떤 함수든 적용 가능


//      - CONCAT : 문자열 연결
//      String query =
//              "select concat('a','b') from Member m";
//              "select 'a'||'b' from Member m";
      //||로도 사용 가능 (저건 하이버네이트 구현체가 지원하는 기능)

//      - SUBSTRING : 문자열의 일부분을 추출
//      String query =
//              "select substring(m.username,2,3) from Member m";
////      - TRIM : 문자열의 앞 뒤 공백을 제거
//      String query =
//              "select trim(m.username) from Member m";
////      - LOWER, : LOWER는 소문자로 변환
//      String query =
//              "select lower(m.username) from Member m";
////      -UPPER : UPPER는 대문자로 변환
//      String query =
//              "select upper(m.username) from Member m";
////      - LENGTH : 문자열의 길이를 반환
//      String query =
//              "select length(m.username) from Member m";
////      - LOCATE : 특정 문자열이 다른 문자열 내에서 처음 나타나는 위치를 반환
//      String query =
//              "select locate('de','abcdefg') from Member m";
////      - ABS: ABS는 숫자의 절대값 반환/
//      String query =
//              "select abs(5) from Member m";
////      - SQRT: SQRT는 숫자의 제곱근을 반환 /
//      String query =
//              "select sqrt(10) from Member m";
////      -MOD: MOD는 두 숫자 간의 나머지를 반환
//      String query =
//              "select mod(20,10) from Member m";
////      - SIZE: SIZE 컬렉션의 크기(항목 수)를 반환
//      String query =
//              "select size(t.members) from Team t";
////      - INDEX(JPA 용도) : `INDEX` 함수는 `@OrderColumn`이 지정된 리스트에서 요소의 인덱스를 반환
//      String query =
//              "select index('a','b') from Member m";
    //@OrderColumn을 사용할 때 리스트 타입의 값타입 컬렉션에서 사용하는데
    //그 컬렉션의 위치값을 구할 때 쓰는데 굳이 안쓰고 엔티티로 사용하는 게 좋다.

//      List<Integer> result = em.createQuery(query, Integer.class).getResultList();
////      List<String> result = em.createQuery(query, String.class).getResultList();
////      for(String s : result){
////        System.out.println("s = " + s);
////      }
//      for(Integer s : result){
//        System.out.println("s = " + s);
//      }

//      //사용자 정의 함수
//      String query =
//      "select function('group_concat', i.name) from Item i";
//      List<String> result = em.createQuery(query, String.class).getResultList();
//      for(String s : result){
//        System.out.println("s = " + s);
//      }

      //경로 표현식
      Team team= new Team();
      team.setName("TeamA");
      em.persist(team);

      Member member = new Member();
      member.setUsername("member1");
      member.setAge(10);
      member.setTeam(team);
      member.setType(MemberType.ADMIN);
      //원래는 양방향 연관관계로 세팅해야 된다.
      em.persist(member);
      
      //상태 필드
//      String query = "select m.username from member m";
      //m.username같이 상태 필드를 만나게 되면 경로 탐색은 끝난다.
      
      //단일 값 연관 경로
//      String query = "select m.team.name from member m";
      //이때 .team을 하게 되면 team으로 묵시적 내부 조인이 발생하여 team을 탐색한다.
      //그리고 그 team에서 name까지 탐색할 수 있고 name을 만나면 상태 필드이기 때문에 그대로 탐색을
      //멈춘다.

      //컬렉션 값 연관 경로
//      String query = "select t.members from Team t";
      //이렇게 쿼리하면 컬렉션은 1대다 형식이라 매핑이 불가능해서 더이상 탐색이 불가능하다.
      //핵심은 여기서 탐색 자체가 불가능

      //FROM 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통
      //해 탐색 가능
      String query = "select m.username from Team t join t.members m";
      //from절에서 명시적 조인을 해서 별칭을 얻는다는게 이런 듯

      Collection result =em.createQuery(query,Collection.class).getResultList();
      for(Object o : result){
        System.out.println("o = " + o);
      }



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

