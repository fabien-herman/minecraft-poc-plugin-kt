package your.namespace.poc

import your.namespace.poc.base.BasePlugin
import your.namespace.poc.util.logger

class PocPlugin : BasePlugin() {

    companion object {
        @JvmStatic
        private val log = PocPlugin.logger()

        @JvmStatic
        lateinit var pocPlugin: PocPlugin
            private set
    }

    /**
     * This init call the first on plugin "construction". (see Kotlin init)
     * So, here we assign this plugin instance into a static variable 'pocPlugin',
     * it can be accessed from anywhere
     */
    init { pocPlugin = this }


    override fun onEnable() {
        log.info("Enable Ofmine Authentication Plugin")
        server.pluginManager.registerEvents(PlayerEventListener(), this)
    }


    override fun onDisable() {
        log.info("Disable Ofmine Authentication Plugin")
        // Plugin shutdown logic
    }
}
