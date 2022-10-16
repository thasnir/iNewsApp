package com.cba.core_domain

/**
 * Data mapper interface for transforming object type into another
 */
interface Mapper<Request,Result> {
    fun convert(request: Request): Result
}