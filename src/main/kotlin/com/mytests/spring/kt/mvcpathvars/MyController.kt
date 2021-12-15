package com.mytests.spring.kt.mvcpathvars

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class MyController {
     @GetMapping("/ok/{pv1}/{pv2}/{pv3}")
     //@GetMapping("/ok/{pv1}/{pv2}")  // no error is shown, but should https://youtrack.jetbrains.com/issue/IDEA-284989
    fun vars(params: VarParams):String = params.toString()

    data class VarParams(var pv1:String, var pv2:String, var pv3:String)
    
    @GetMapping("/error/{pv11}/{pv22}")
    fun vals(params: ValParams):String = params.toString()

    data class ValParams(val pv11:String, val pv22: String)

    @GetMapping("/test/{pv111}/{pv222}/{pv333}")
    //@GetMapping("/test/{pv111}/{pv222}")  // error is shown - ok
    fun normal(@PathVariable pv111: String, @PathVariable pv222: String,  @PathVariable pv333: String):String{
        return pv111+pv222+pv333
    }


}