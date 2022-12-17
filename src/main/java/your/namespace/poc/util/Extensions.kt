package your.namespace.poc.util

import com.destroystokyo.paper.utils.PaperPluginLogger
import net.kyori.adventure.text.Component
import java.util.logging.Logger

// Kotlin' extensions to shorten code, re-usability, and code clarity.

// usage: val msg: Component = "hello".toComponent()
fun String.toComponent() = Component.text(this)

// usage:  event.entity.takeIfInstanceIs<Player> { player -> ..do stuff...  }
inline fun <reified T> Any?.takeIfInstanceIs(consumer: (T) -> Unit) {
    if (this != null && this is T) consumer(this as T)
}

// Help to instantiate a logger
// usage: val log = PocPlugin.logger()
//        log.info("something happens")
fun Any.logger(): Logger = PaperPluginLogger.getLogger(this::class.java.name)
