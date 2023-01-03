# jpa

### ORM(Object Relational Mapping)
   객체 진영과 RDB 진영을 자동으로 매핑하여 구조의 불일치를 개발자 대신 해결주는 기술의 총칭이다.<br>
   객체지향 구조에서 프로그래밍 언어를 사용하여 RDB의 데이터를 조작하는 방법이다. <br>
   ORM을 사용하면 개발자가 SQL문을 직접 작성하지 않아도 RDB와 상호작용할 수 있다.

### JPA(Java Persistence API)
   ORM을 사용하기 위한 설계도(틀)이다. <br>
   Java Application용 RDB 매핑 관리를 위한 인터페이스이며, DBMS 벤더사에 의존하지 않고 독립적으로 ORM을 사용할 수 있는 ORM 표준이다. <br>
   인터페이스이기 때문에 구현되어 있지 않은 틀만 제공하며, 자체적인 작업을 수행하지 않는다. <br>
   JPA에 설계된 구조에 맞춰서 각 메소드를 재정의하여 직접 ORM을 구현하여 사용해야 한다. <br>
   JPA는 ORM을 사용할 수 있는 JAVA 인터페이스를 제공하는 ORM 접근 방식이며, 구현되지 않은 JPA를 ORM이라고 말하기는 어렵다.

### Hibernate Framework
   모든 Java Application에 대해 객체 관계를 그대로 유지한 채 쿼리 서비스를 제공하는 오픈 소스(비용 없이 공개적으로 사용가능)의 경량 ORM이다. <br>
   JPA를 구현한 구현체이며, 여러 구현체 중 가장 대표적인 구현체이다. <br>
   객체 간 관계 구성을 지원하며, 상속, 지연성, 페이징 처리, 예외 처리 불필요를 지원한다. <br>
   예외 처리 불필요란, JPA만의 독자적인 예외를 생성하여 try catch 및 throws를 강제시키지 않고 <br>
   트랜잭션을 지원하는 Spring Framework가 추상화한 예외로 변환 시켜 커밋하지 않고 롤백시키도록 해준다. <br><br>

![2023-01-03 17;32;38](https://user-images.githubusercontent.com/114047532/210322727-74129c67-20e4-435a-888c-c3d14c6bf401.PNG)


### Spring Data JPA
   JPA를 추상화한 Repository 인터페이스를 제공하여 JPA를 쓰기 편하게 다양한 기능을 지원한다. <br>
   내부적으로는 JPA를 사용한다. 그래서 JPA를 모르면 내부 구조를 이해하기 힘들 수 있다. <br>
   
---

## 객체와 관계형 데이터베이스의 차이

### 상속

![123](https://user-images.githubusercontent.com/114047532/210322947-c0445b86-c0b0-449a-b425-ea1e96b6d250.PNG)

![1234](https://user-images.githubusercontent.com/114047532/210323087-af2b56ff-38de-494c-a3fb-5224e908276e.PNG)




   1:1 관계에서 INSERT를 하기 위해서는 쿼리를 2번 작성해야하는 불편함이 생긴다. <br>
   게다가 조회를 할 때에는 JOIN을 사용해야 하는데 쿼리가 굉장히 복잡해진다. <br>
   만약에 이런 RDB의 테이블 관계를 자바 컬렉션으로 바꿀 수 있다면, <br>

   Developer developer = list.get(developerId); <br>
   위와 같이 간단하게 조회할 수 있다. <br>


### 연관관계
   객체는 하위 연산자(.)를 사용하여 참조를 한다. <br><br>
   
   ▶ 객체 연관 관계: 단방향으로 흘러간다(Flower에서 Pot 접근은 가능하지만 Pot에서 Flower를 접근할 수 없다) <br>
![12345](https://user-images.githubusercontent.com/114047532/210323238-1371ea1e-39a4-4fb9-93c6-4fdf3131ecce.PNG)



   ▶ RDB 연관 관계: 양방향으로 흘러간다(FLOWER에서 POT을, POT에서 FLOWER를 접근할 수 있다)
![123456](https://user-images.githubusercontent.com/114047532/210323287-333ca708-b76b-46eb-a4bd-e2f73f82ba73.PNG)


   
   ▶ 객체를 테이블에 맞추어 설계

   Class Flower{ <br>
      String flowerId; <br>
      String flowerName; <br>
      String potId; // FK는 RDB방식에서의 연관관계이기 때문에 객체방식으로 바꿔야 함. <br>
   } <br><br><br>


   ▶ 테이블을 객체에 맞추어 설계 <br>

   Class Flower{ <br>
      String flowerId; <br>
      String flowerName; <br>
      Pot pot; // 참조로 연관관계를 맺도록 함. <br>
   } <br><br>

   위와 같이 RDB를 객체방식으로 설계하면, <br>
   조회 시 JOIN을 하여 FLOWER와 POT에서 각각 필요한 정보를 가져와 <br>
   각 객체에 담아준 뒤, flower.setPot(pot) 형태와 같이 복잡하게 작업해야 한다. <br><br>

   하지만 만약 자바 컬렉션으로 관리가 가능하다면, <br><br>

   list.add(꽃); <br>
   Flower flower = list.get(flowerId); <br>
   Pot pot = flower.getPot(); <br><br>

   훨씬 편하게 작업이 가능하다. <br><br><br>


### 그래프 탐색
   ![1234567](https://user-images.githubusercontent.com/114047532/210323545-efee392b-18d5-4aee-9876-6d8cff09ad10.PNG)



   객체는 모든 객체 그래프를 탐색할 수 있어야 한다. <br><br><br>


   market.getFlower(); <br>
   flower.getPot(); <br>
   ... <br><br>

   하지만 SQL 작성 시 이미 탐색 범위가 결정된다. <br>
   만약 Market과 Flower를 JOIN해서 조회를 한다면, <br><br>

   market.getFlower()는 사용 가능하지만 <br>
   market.getPot()는 null일 수 밖에 없다. <br><br>

   따라서 엔티티에 대한 신뢰가 무너질 수 밖에 없다. <br><br>
   
   Market market = marketDAO.find(marketId); <br>
   market.getFlower(); // null이 아니라고 확신할 수 없다. <br>
   market.getOrder().getClient(); // null이 아니라고 확실할 수 없다. <br><br>

   marketDAO에 있는 find()를 분석해보지 않는 이상 각 엔티티에 대해 신뢰할 수 없다. <br><br>

   따라서 상황에 따라 조회에 대한 메소드를 여러 개 선언해놓아야 한다. <br><br>
   
   marketDAO.getFlower(); <br>
   marketDAO.getMemberWithFlower(); <br>
   marketDAO.getMemberWithOrderWithClient(); <br>
   ... <br><br>

   하지만 위와 같은 방법은 사실상 불가능에 가깝다. <br>


### 값 비교
   SQL 실행 결과를 담은 뒤 생성자를 호출하여 객체에 담으면 매번 new가 사용되기 때문에 <br>
   동일한 조회 결과의 객체일지라도 주소가 모두 다르다. <br><br>

   하지만 만약 자바 컬렉션에서 객체 조회가 가능하다면 <br>
   list.get(memberId) == list.get(memberId) <br>
   같은 객체를 가져오기 때문에 주소가 같다. <br><br>

즉, 객체지향으로 설계할 수록 작업이 오히려 복잡해지고 늘어나기 때문에 RDB 중심으로 설계할 수 밖에 없다. <br>
RDB를 자바 컬렉션에 저장하듯 사용하면 굉장히 편해지고 많은 문제가 해결되는데, <br>
바로 이 기술을 JPA(Java Persistence API)라고 한다. <br>

---

### JPA를 사용해야 하는 이유 <br>
   1. SQL 중심 개발에서 객체 중심으로 개발 <br><br>

   2. 생산성 <br>
      저장 : jpa.persist(market); <br>
      조회 : jpa.find(marketId); <br>
      수정 : market.setMarketName("새로운 이름"); <br>
      삭제 : jpa.remove(market); <br><br>

   3. 유지보수 <br>
      클라이언트가 새로운 필드를 요청하여 새로운 필드 추가 시 <br>
      클래스 안에 필드만 한 개 추가하면 끝. SQL문을 수정할 필요 없음. <br><br>

   4. 패러다임의 불일치 해결 <br><br>

      ▶ JPA와 상속 <br><br>
      
![12345678](https://user-images.githubusercontent.com/114047532/210323764-d12864ab-739e-4c2c-a399-8a6448c3c4e8.PNG)




      ▶ JPA와 연관관계
      
![123456789](https://user-images.githubusercontent.com/114047532/210323897-a05d4e95-4bdb-4692-8489-b3819f3b0d52.PNG)
      

        
      ▶ JPA와 객체 그래프 탐색
      
![151](https://user-images.githubusercontent.com/114047532/210323977-95176598-8f7c-4d5c-b8c3-3c0bfe9e5c37.PNG)



      ▶ JPA와 값 비교 

![1511](https://user-images.githubusercontent.com/114047532/210324029-d623712d-d3c7-41d2-a7fd-2b0b08f36e6e.PNG)
