package com.kotlex.system.android

import android.Manifest
import android.content.res.AssetManager
import android.net.Uri
import android.os.Environment
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import junit.framework.TestCase.*
import org.junit.Rule

import org.junit.Test
import java.io.File

class AssetManagerKtTest {

    @Rule
    @JvmField
    var runtimePermissionRule = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE)!!

    private val testContext = InstrumentationRegistry.getInstrumentation().context
    private val assets: AssetManager = testContext.assets
    private val testDir = File(Environment.getExternalStorageDirectory(), "KOTLEX_TEST")

    @Test
    fun isAssetAvailablePath() {
        assertTrue(assets.isAssetFileAvailable("test_file_one.txt"))
        assertFalse(assets.isAssetFileAvailable("test_fail.txt"))
        assertFalse(assets.isAssetFileAvailable("test_dir_one"))
    }

    @Test
    fun isAssetAvailableUri() {
        val uriValidFile = Uri.parse("file:///android_asset/test_file_one.txt")
        val uriInvalidFile = Uri.parse("file:///android_asset/test_invalid.txt")
        val uriDirFile = Uri.parse("file:///android_asset/test_dir_one")

        assertTrue(assets.isAssetFileAvailable(uriValidFile))
        assertFalse(assets.isAssetFileAvailable(uriInvalidFile))
        assertFalse(assets.isAssetFileAvailable(uriDirFile))
    }

    @Test
    fun copyPath() {
        testDir.deleteRecursively()
        val targetFile = File(testDir, "test_one.txt")

        assets.copyFile("test_file_one.txt", targetFile)

        assertTrue(targetFile.exists())
        assertTrue(targetFile.length() > 0)
    }

    @Test
    fun copyUri() {
        testDir.delete()
        val targetFile = File(testDir, "test_one.txt")

        assets.copy(Uri.parse("file:///android_asset/test_file_one.txt"), targetFile)

        assertTrue(targetFile.exists())
        assertTrue(targetFile.length() > 0)
    }

    @Test
    fun listUris() {
        val uris = assets.listUris("test_dir_one")
        assertEquals(2, uris.size)
        assertEquals(uris[0].toString(), "file:///android_asset/test_dir_one/dir_one_file_one.txt")
        assertEquals(uris[1].toString(), "file:///android_asset/test_dir_one/dir_one_file_two.txt")
    }


    @Test
    fun copyDir() {
        testDir.delete()
        val targetDir = File(testDir, "test_dir")

        assets.copy("test_dir_one", targetDir)

        assertTrue(targetDir.exists())
        assertTrue(targetDir.isDirectory)
        assertEquals(2, targetDir.list().size)
    }


}