package com.mytests.spring.kt.mvcpathvars

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class MyController {
     @GetMapping("/ok/{pv1}/{pv2}")
    fun ok(params: OkParams):String = params.toString();

    data class OkParams(var pv1:String, var pv2:String)
    
    @GetMapping("/error/{pv1}/{pv2}")
    fun notOk(params: NotOkParams):String = params.toString();

    data class NotOkParams(val pv1:String, val pv2: String)
}