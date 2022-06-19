package com.kotlinspring.dto

import javax.validation.constraints.NotBlank

data class CourseDTO (
    val id: Int?,
    @get:NotBlank(message = "courseDTO.name must not be blank")
    val name: String,
    @get:NotBlank(message = "courseDTO.name must not be blank")
    val category: String
)