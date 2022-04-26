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



> Q. kotlin object keyword constructor



