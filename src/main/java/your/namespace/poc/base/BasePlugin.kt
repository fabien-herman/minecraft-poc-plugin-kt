package your.namespace.poc.base

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import your.namespace.poc.util.toComponent

abstract class BasePlugin : JavaPlugin() {

    /**
     * Run asynchronous task
     */
    fun runTaskAsync(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTaskAsynchronously(this, runnable)
    }

    /**
     * Run synchronous task
     */
    fun runTask(runnable: Runnable): BukkitTask {
        return Bukkit.getScheduler().runTask(this, runnable)
    }

    /**
     * Send a text mesage to all, or only specified players
     */
    fun sendMessage(message: String, vararg player: Player) {
        val msg = message.toComponent()
        if (player.isEmpty()) Bukkit.broadcast(msg)
        else player.forEach { it.sendMessage(msg) }
    }
}
