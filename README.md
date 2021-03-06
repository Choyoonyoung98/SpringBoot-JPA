# SpringBoot-JPA
scratch the server surface, 짬 날 때마다 서버 공부하는 repo. Kotlin은 언제 공부하지?  
`InteliJ`, `JAVA >= 11`, `Spring Boot`, `gradle`, `JPA`, `JUnitTest`

### dependecies
`Spring Web Starter`, `Thymeleaf`, `Spring Data JPA`, `H2 Database`

### Kotlin styleguide
- [코틀린 스타일가이드 공식문서](https://developer.android.com/kotlin/style-guide)
- [코틀린 컨밴션](https://kotlinlang.org/docs/coding-conventions.html#names-for-test-methods)
- [raywenderlich kotlin style Guide](https://github.com/raywenderlich/kotlin-style-guide)
- [코틀린 공식 사이트에서 제공하는 코드 컨밴션 InteliJ에 적용하는 법](https://velog.io/@lsb156/IntelliJ-Kotlin-Code-Style-%EC%84%A4%EC%A0%95%EB%B2%95)

### [H2 Database](http://localhost:8080/h2-console)
### 진도

**[Build RESTFUL APIS using Kotlin and Spring Boot](https://www.udemy.com/course/build-restful-apis-using-kotlin-and-spring-boot/learn/lecture/30033430#content)**    
> **04/10** 
> **04/13**
#### [코틀린](https://kotlinlang.org/docs/getting-started.html)이란?
- 코틀린은 OOP와 FP를 결합한 언어이다
- 코틀린은 자바와 같이 정적 타입 언어이다(컴파일 시 변수의 타입이 결정되는 언어. 즉 프로그래머가 변수에 들어갈 값의 형태에 따라 직접 변수의 타입을 명시해줘야 한다)    
  
**Kotlin을 사용 언어로 채택하게 된 이유?**
1) 이미 많은 기업들(Google, Amazon, Pivotal, Netflix..) 등이 서버 개발 언어로 Kotlin 채택
2) 최근 서버 개발 언어로 주목받기 시작하는 등 가벼운 이유로 채택

**Kotlin 사용 시 얻을 수 있는 장점**  
1) 코틀린은 표현언어(?)이며, 간결한 구문으로 표현 가능하다 -> 코드가 가독성 있으며 지속성 있다  
2) 불필요한 에러를 방지해준다는 점에서 안전한 언어이다(SWIFT의 안전성과 유사한 특징?)  
-> Nullable과 Non-Nullable타입을 사용함으로써 `NullPointerException`을 방지해준다
3) **JAVA와 상호운용 가능하다** -> Nice👍🏼

**Kotlin과 주로 사용하는 Framework**
- Spring
- Micronaut

**Kotlin, JVM 위에서 어떻게 동작할까?**  
- Java가 JVM 위에서 동작하는 방식과 유사   
- Kotlin Compiler 존재 이유: JVM은 오직 바이트코드만을 이해하기 때문에   
`*.java` -> Java Compiler -> `*.class` -> `.jar`  
`*.kt` -> Kotlin Compiler -> `*.class` -> `.jar`  

**val & var**
- 어떤 변수든 코틀린은 `val` 또는 `var`로 정의되어야 한다
- `val`: 불변하는 상수 변수를 선언한다(swift에서의 `let`)  
```
val name: String = "Dilp"
```
- `var`: 변경 가능한 변수를 선언한다  
```
var age: Int = 33
```
**if / else**
```
var position = 1
val medal = if(position == 1) {
    "GOLD"
} else if(position == 2) {
    "SILVER"
} else if(position == 3) {
    "BRONZE"
} else {
    "NO MEDAL"
}

println(medal)
```

**when**  
```
val medal2 = when (position) {
    1 -> "GOLD"
    2 -> "SILVER"
    3 -> "BRONZE"
    else -> "NO MEDAL"
}

println(medal2)
```

**Top Level Functions**
- Kotlin에서 클래스에 속해있지 않은 함수는 top-level 함수라고 부른다(클래스가 아닌, Kotlin file에 선언되어 있는 함수)
  - Java에서는, 함수는 오직 클래스의 일부여야만 한다
  - Java 앱에서는 앱의 전역에 걸쳐 사용되는 공통 로직을 담은 정적 메서드들만을 포함하고 있는 클래스를 찾을 수 있는데,    
  -> Kotlin은 top level 함수를 사용함으로써 위와 같은 상황을 방지할 수 있게 한다  

**Top Level Properties**
- Kotlin에서는 클래스에 속해있지 않은 top-level properties가 있다
  - JAVA에서는 클래스 또는 인터페이스 안에서만 properties를 정의할 수 있었다
  - 자바 앱에서는 앱의 전역에 걸쳐 사용되는 정적 상수를 클래스 파일 안에 정의한다.
  -> Kotlin은 top level properties를 사용함으로써 위와 같은 상황을 방지할 수 있게 한다  

**data class**
- 데이터만을 포함하고 있는 클래스는 data class라고 분류된다
- DTO, domain class, value object class는 모두 data class로 분류된다
- class 앞에 data 키워드를 선언할 경우 자동으로 `equals()`, `hashCode()`, `toString()` 메서드가 생성된다  
```
data class Course(
  val id: Int,
  val name: String,
  val author: String
)
```

- **(debugging advantages):** data class 인스턴스는 일반 class 인스턴스와 달리 print로도 내부 데이터가 찍힌다
> 일반 class를 print 찍으면 쓰레기 데이터가 찍힌다
```
Course(id=1, name=Good story, author=yoonyoung)
```
  
(용도 & 장점)  
1. data class는 주로 data container 역할을 할 클래스를 위한 것이다
2. 데이터 변경을 위한 많은 함수를 자동으로 생성해준다
3. `copy()` 메서드를 통해 객체를 클론하기 더 쉬워졌다


**Custom Getter/Setter 사용하는 경우?**  
 = property를 setting 하거나 getting해올 때 커스텀 로직을 상속받고싶을 경우 사용

**Inheritance(상속)**
- Kotlin에는 상속 개념이 지원된다
- `Any`는 Kotlin의 모든 클래스의 슈퍼클래스이다
- Kotlin에 있는 모든 클래스는 `final`이 기본 상속 변경자로 설정되어 있다
> final: 상속이 불가능한 변경자  
> open: 상속이 이루어질 수 있는 변경자  
> abstract class: 상속이 이루어져야만 하는 변경자  

- kotlin은 `open` 변경자로 설정해야 overriding이 가능하다
```
open class User(val name: String) {
  open val isLoggedIn: Boolean = true
  open fun login() {
   println("Inside user login")
  }
}

class Student(name: String): User(name, age) {
  override val isLoggedIn: Boolean = true
  override fun login() {
    super.login()
    println("Inside Student login")
  }
}
```

**final: 상속이 불가능한 클래스**  
- OOP의 관점에서는 객체가 있고 해당 객체에 대한 코드를 줄이기 위해 재사용 가능했다면 재사용하는 것이 좋지만, **이러한 사용 방식은 상속하는 기반 클래스가 변경이 없는 경우에만 유효하다**  
-> 기반 클래스가 변경이 잦은데 무분별하게 클래스를 상속하게 된다면, fragil base class 문제에 직면하게 되기 때문이다  
=> 이러한 문제를 해결하기 위해 Kotlin에서는 class의 기본 상속 변경자를 `final`로 설정하게 되었다.  
=> 따라서 특정 클래스가 상속되어도 되는 경우메나 `open`이라는 변경자를 이용해 상속 가능하다

**(⭐️)object keyword**
= 클래스와 클래스의 인스턴스를 동시간대에 생성해주는 키워드  
- Java의 singleton pattern과 유사하다
- (단점??)object 클래스에는 생성자를 주입할 수 없다
```
obejct Authenticate {
  fun authenticate(userName: String, password: String) {
    println("User Authenticated for userName: $userName")
  }
}
```

**companion object**
- Kotlin은 static에 대한 지원을 하지 않는다
- companion object는 class에 종속된 static 기능으로 소개되고는 한다
- class 내부에서 object를 사용하기 위해서는 companion keyword를 사용해야 한다

**Interface**
- OOP에서의 interface는 추상 메서드를 포함한 규약을 정의한다
- interface를 상속하고 있는 클래스는 interface를 구현해야 한다(?)
  - interface는 추상 메서드와 비추상 메서드 모두를 가질 수 있다
  - interface는 어떤 상태도 포함하지 않는다(?)

**Visibility Modifiers in Kotlin**
1) public: 기본 접근 연산자
2) protected: 함수 또는 변수에 대한 접근을 클래스 내에서만 가능
3) private: 클래스와 서브클래스에서 접근 가능
4) internal: 모듈로부터 private하다 (?)

**Type Checking & Casting**
- `is` 연산자: 특정 값을 명확한 타입인지 확인하는 type checking 연산자
```
val name = "yoonyoung"
val result = name is String //true or false 반환

if(a is String) {    
    // a is now treated as String
}
```

- `as` 연산자: 특정 값을 명확한 타입으로 선언하는 type casting 연산자 
-> 값이 선언한 타입이 아니라면, `java.lang.ClassCastException` 반환
```
val name = "yoonyoung" as String
```

**Nulls in Kotlin**
```
val length = nameNullable?.length //safe call operator
val length = nameNullable?.length ?: 0 //Elvis operator
println(length!!) //not null assertion
```

**이쯤되면 궁금해지는 Kotlin 메모리 관리 방법**
https://medium.com/@kimtaesoo188/kotlin-android-vs-swift-ios-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B4%80%EB%A6%AC-%EB%B0%A9%EB%B2%95-1c0144d4243a

**kotlin+JPA 실습환경**


```
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.6.7"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
  kotlin("plugin.jpa") version "1.6.21"
}

group = "com.kotlinspring"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  runtimeOnly("com.h2database:h2")
  runtimeOnly("org.postgresql:postgresql")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
``` 

**Automatic Testing**
1) Integration Test  
= 어플리케이션의 처음부터 끝까지 테스트하는 통합 테스트
`Controller` -> `Service` -> `Repository`

2) Unit Test
= 관심있는 클래스와 메서드, 그리고 다음 단계의 코드에 대한 mock을 테스트하는 단위테스트

**프로젝트 구조**
1) **View**에서 전송한 정보를 **Controller**에서 수신. 받은 정보를 **Service**에게 넘김
2) **Service**에서 핵심 비즈니스 로직을 수행 후 DB 접근이 필요하면 **Repository**에게 요청
3) **Repository**는 DB와 접근하기 위해 필요한 친구인데, 서비스로부터 DB에 insert 요청이 오면 DTO 객체들은 영속성 컨테이너라는 곳에 넣어뒀다가 로직이 끝나면 한번에 DB로 커밋하게 된다

다른 관점에서 보면?  
1) Client가 Request를 보낸다
2) Request URL에 알맞은 Controller가 수신한다
3) Controller는 넘어온 요청을 처리하기 위해 Service 호출
4) Service는 알맞은 정보를 가공하여 Contoller에게 데이터를 넘긴다
5) Controller는 Service의 결과물을 Client에게 전달해준다

1) CONTROLLER
- @RestController
= @Controller + @ResponseBody 
= Spring MVC Controller + @ResponseBody

- @RequestBody = HTTP body 안에 JSON을 DTO에 맵핑하는 스프링 어노테이션
- @ResponseStatus = 응답 상태 코드(default: 200 OK)
  - 200: HTTPStatus.OK
  - 201: HTTPStatus.CREATED
  - 204: HTTPStatus.NO_CONTENT
  - 400: HTTPStatus.BAD_REQUEST
  - 401: HTTPStatus.UNAUTHORIZED

2) DTO(Data Transfer Object)
= 계층 간 데이터 교환을 하기 위해 사용하는 객체로, DTO는 로직을 가지지 않는 순수한 데이터 객체(getter & setter만을 가진 클래스)
+) VO(Value Object) = 값 오브젝트로써 값을 위해 사용. read-only 특징을 가진다.  

**DTO를 사용하는 이유?**  
- Domain에 특정 파라미터가 모든 request, response에 필요하지 않음에도 불필요하게 사용될 수 있으며, 만약 각 API의 request와 response에 맞추기 위해 domain이 수정되어서는 안된다.   
-> 따라서 각 DTO에 필요한 데이터만 정의도어야하며, 필수 값에 대한 조건 체크하는 것이나 DTO에서 Domain으로 변환하거나, Domain에서 DTO로 변환하는 로직은 Domain이 아닌, DTO에 담겨야 한다   
- 테스트를 추가할 때에도 각 DTO를 분리하게 되면 각각의 request에 따라 테스트 코드를 추가해줄 수 있기 때문에 요청을 모두 검증할 수 있어 테스트 코드에 대한 커버리지가 높아질 수 있다

- Bean Validation Annotation
  - @NotNull = Null만을 허용하지 않음
  - @NotEmpty = NULL, "" 둘다 허용하지 않음(" "은 허용됨)
  - @NotBlank = NULL, "", " " 모두 허용하지 않음 

4) ENTITY  
JPA는 데이터베이스 스키마를 자동으로 생성하는 기능을 지원한다  
- @Entity = 테이블과의 매핑
- @Table = Entity와 매핑할 테이블 지정
- 연관관계
  - @OneToMany / @ManyToOne = 일대다 / 다대일 관계
    - fetchType.Lazy = 지연 로딩
  - @JoinColumn = 외래 키 매핑

5) REPOSITORY
= JPA에서의 DB Layer 접근자
= Entity에 의해 생성된 DB에 접근하는 메서드들을 사용하기 위한 인터페이스이다. (EX.`findAll()`)

6) SERVICE
Controller가 Request에 대해 **어떻게** 처리할까라면, 
Service는 Request에 대해 어떤 처리를 할까에 대해 다루고 있다.
