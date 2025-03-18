package com.example.noparticlespam;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class NoParticleSpamPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Устанавливаем фильтр для логов
        Logger logger = getServer().getLogger();
        logger.setFilter(new ParticleSpamFilter());

        // Сообщение о запуске плагина
        getLogger().info("NoParticleSpamPlugin включен! Спам о частицах будет отфильтрован.");
    }

    @Override
    public void onDisable() {
        // Сообщение о выключении плагина
        getLogger().info("NoParticleSpamPlugin выключен.");
    }

    // Фильтр для логов
    private static class ParticleSpamFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            // Игнорируем сообщения, содержащие "Displaying particle"
            return !record.getMessage().contains("Displaying particle");
        }
    }
}
