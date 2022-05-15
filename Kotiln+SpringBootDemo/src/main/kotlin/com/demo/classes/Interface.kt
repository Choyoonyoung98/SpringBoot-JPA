package com.demo.classes

interface CourseRepository {
    val isCoursePersisted: Boolean
    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("course: $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): Any
}

class SqlCourseRepository: CourseRepository, Repository {
    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
        return Course(1, "Good story", "yoonyoung")
    }

    override fun save(course: Course): Int {
        isCoursePersisted = true
        return super.save(course)
    }

    override fun getAll(): Any {
        return 1
    }
}

class NoSqlCourseRepository: CourseRepository {
    override val isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
        return Course(1, "Good story", "yoonyoung")
    }

    override fun save(course: Course): Int {
        println("course in NpSqlCourseRepository: $course")
        return course.id
    }
}

interface A {
    fun doSomething() {
        println("doSomething in A")
    }
}

interface B {
    fun doSomething() {
        println("doSomething in A")
    }
}

class AB: A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("do something in AB")
    }
}
fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    print("Course is $course")

    val courseId = sqlCourseRepository.save(Course(5, "Good story", "yoonyoung"))
    println("Course persisted value is ${sqlCourseRepository.isCoursePersisted}")
    println("Saved Course Id is $courseId")

    val nosqlCourseRepository = NoSqlCourseRepository()
    val course1 = nosqlCourseRepository.getById(2)
    print("Course is $course1")
    val savedCourseId = nosqlCourseRepository.save(Course(6, "Good story", "yoonyoung"))
    println("Saved Course Id in nosqlCourseRepository: $savedCourseId")

    val ab = AB()
    ab.doSomething()
}