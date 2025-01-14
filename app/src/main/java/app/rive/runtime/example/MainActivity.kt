package app.rive.runtime.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import app.rive.runtime.kotlin.core.Rive


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Rive.init()
        setContentView(R.layout.example_selection)

        findViewById<Button>(R.id.go_simple).setOnClickListener {
            startActivity(
                Intent(this, SimpleActivity::class.java)
            )
        }

        findViewById<Button>(R.id.go_multiple_artboards).setOnClickListener {
            startActivity(
                Intent(this, MultipleArtboardsActivity::class.java)
            )
        }

        findViewById<Button>(R.id.go_android_player).setOnClickListener {
            startActivity(
                Intent(this, AndroidPlayerActivity::class.java)
            )
        }

        findViewById<Button>(R.id.go_loop_mode).setOnClickListener {
            startActivity(
                Intent(this, LoopModeActivity::class.java)
            )
        }

        findViewById<Button>(R.id.go_layout).setOnClickListener {
            startActivity(
                Intent(this, LayoutActivity::class.java)
            )
        }
    }
}
