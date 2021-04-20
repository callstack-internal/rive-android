package app.rive.runtime.kotlin

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import app.rive.runtime.kotlin.test.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RiveAnimationLoadTest {

    @Test
    fun loadAnimationFirstAnimation () {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.rive.runtime.kotlin.test", appContext.packageName)

        Rive.init()
        var file = File(appContext.resources.openRawResource(R.raw.multipleartboards).readBytes())
        var artboard = file.artboard("artboard1")

        var animationAlt = artboard.animation(0)
        var animation = artboard.animation("artboard1animation1")
        assertEquals(animation.nativePointer, animationAlt.nativePointer)
    }

    @Test
    fun loadAnimationSecondAnimation () {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.rive.runtime.kotlin.test", appContext.packageName)

        Rive.init()
        var file = File(appContext.resources.openRawResource(R.raw.multipleartboards).readBytes())
        var artboard = file.artboard("artboard2")
        var artboard2animation1 = artboard.animation(0)
        var artboard2animation1Alt = artboard.animation("artboard2animation1")
        assertEquals(artboard2animation1.nativePointer, artboard2animation1Alt.nativePointer)

        var artboard2animation2 = artboard.animation(1)
        var artboard2animation2Alt = artboard.animation("artboard2animation2")
        assertEquals(artboard2animation2.nativePointer, artboard2animation2Alt.nativePointer)

    }

    @Test
    fun artboardHasNoAnimations () {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.rive.runtime.kotlin.test", appContext.packageName)

        Rive.init()
        var file = File(appContext.resources.openRawResource(R.raw.noanimation).readBytes())
        var artboard = file.artboard()
        assertEquals(artboard.animationCount(),0)
    }

    @Test(expected = RiveException::class)
    fun loadFirstAnimationNoExists () {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.rive.runtime.kotlin.test", appContext.packageName)

        Rive.init()
        var file = File(appContext.resources.openRawResource(R.raw.noanimation).readBytes())
        var artboard = file.artboard()
        artboard.firstAnimation()
    }

    @Test(expected = RiveException::class)
    fun loadAnimationByIndexDoesntExist () {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.rive.runtime.kotlin.test", appContext.packageName)

        Rive.init()
        var file = File(appContext.resources.openRawResource(R.raw.noanimation).readBytes())
        var artboard = file.artboard()
        artboard.animation(1)
    }

    @Test(expected = RiveException::class)
    fun loadAnimationByNameDoesntExist () {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("app.rive.runtime.kotlin.test", appContext.packageName)

        Rive.init()
        var file = File(appContext.resources.openRawResource(R.raw.noanimation).readBytes())
        var artboard = file.artboard()
        artboard.animation("foo")
    }
}