package functional

import org.junit.Test
import kotlin.test.assertEquals

class FunctionalTest {

    @Test
    fun testLambdaFunctionalTypeSpecified() {
        testFunctions(LambdaFunctionalTypeSpecified())
    }

    @Test
    fun testLambdaFunctionalTypeInferred() {
        testFunctions(LambdaFunctionalTypeInferred())
    }

    @Test
    fun testAnonymousFunctionalTypeSpecified() {
        testFunctions(AnonymousFunctionalTypeSpecified())
    }

    @Test
    fun testAnonymousFunctionalTypeInferred() {
        testFunctions(AnonymousFunctionalTypeInferred())
    }

    @Test
    fun testFunctionReference() {
        testFunctions(FunctionReference())
    }

    @Test
    fun testFunctionMemberReference() {
        testFunctions(FunctionMemberReference())
    }

    @Test
    fun testBoundedFunctionReference() {
        testFunctions(BoundedFunctionReference())
    }

    fun testFunctions(obj: FunctionsFunctional) {
        assertEquals(3, (obj.add as (Int, Int)->Int)(1, 2))
        assertEquals(6, (obj.triple as (Int)->Int)(2))
        assertEquals("BBB", (obj.longestOf as (String, String, String)->String)("AA", "BBB", "CC"))
        assertEquals("AA", (obj.longestOf as (String, String, String)->String)("AA", "B", "C"))
    }
}
