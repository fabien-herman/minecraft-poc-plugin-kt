package your.namespace.poc

import your.namespace.poc.PocPlugin.Companion.pocPlugin
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerJoinEvent
import your.namespace.poc.util.logger
import your.namespace.poc.util.takeIfInstanceIs

class PlayerEventListener : Listener {

    companion object {
        @JvmStatic
        private val log = PlayerEventListener.logger()
    }

    @EventHandler
    fun on(event: PlayerJoinEvent) {
        log.info("PlayerJoinEvent")

        with (event.player) {
            pocPlugin.sendMessage("Hi $name !")
        }
    }

    @EventHandler
    fun on(event: EntityDamageEvent) {
        log.info("EntityDamageEvent")

        event.entity.takeIfInstanceIs<Player> {
            pocPlugin.sendMessage("Ouch !", it)
        }
    }
}
