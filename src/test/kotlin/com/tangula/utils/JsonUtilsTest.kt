package com.tangula.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import junit.framework.TestCase
import org.junit.Test

open class D(open var id:Int, open var name:String)

class D1(id:Int, name:String):D(id,name)

open class L(var id:Int, val ds:List<D>)

open class X<T:D>(val ds:List<T>)

class Y(){
    var ds:List<D> = listOf()
}

class JsonUtilsTest{

    @Test
    fun testJsonStr2Object(){

        val json = """
            {
                "id":1,
                "ds":[
                    {
                        "id":2,
                        "name":"name"
                    }
                ]
            }
        """

        var res = Gson().fromJson<L>(json, object:TypeToken<L>(){}.type)

        TestCase.assertNotNull(res)
        TestCase.assertEquals(1, res.id)
        TestCase.assertTrue(res.ds is List)
        TestCase.assertNotNull(res.ds[0])
        TestCase.assertTrue(res.ds[0] is D)


        var res1  =  JsonUtils.fromJson<Y>("""
            {
                "ds":[
                    {
                        "id":2,
                        "name":"name"
                    }
                ]
            }
        """, Y::class.java)
        TestCase.assertNotNull(res1)

        TestCase.assertTrue(res1.ds is List)
        TestCase.assertNotNull(res1.ds[0])
        TestCase.assertTrue(res1.ds[0] is D)
        TestCase.assertEquals(res.ds[0].id, 2)
        TestCase.assertEquals(res.ds[0].name, "name")


    }

    @Test
    fun testJsonArrayStr2Object(){
        val json = """
            [
                    {
                        "id":2,
                        "name":"name"
                    }
            ]
        """
        var res = Gson().fromJson<List<D>>(json, object:TypeToken<List<D>>(){}.type)
        TestCase.assertNotNull(res)
        TestCase.assertTrue(res is List)
        TestCase.assertNotNull(res[0])

        res = JsonUtils.fromJson<List<D>>(json)
        TestCase.assertNotNull(res)
        TestCase.assertTrue(res is List)
        TestCase.assertNotNull(res[0])

    }

}