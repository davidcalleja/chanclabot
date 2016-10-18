package org.telegram.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.bot.service.MessageReaderService;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.logging.BotLogger;

@Slf4j
@Configuration
public class BootConfig {
    @Value("${boot.config.name}")
    String bootName;
    @Value("${boot.config.description}")
    String bootDescription;

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new MessageReaderService());
        } catch (TelegramApiException e) {
            BotLogger.error("tag", e);
        }

        return telegramBotsApi;
    }


}
