package com.dqu.simplerauth;

import com.dqu.simplerauth.commands.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthMod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static PlayerManager playerManager = new PlayerManager();

    @Override
    public void onInitialize() {
        DbManager.loadDatabase(); // Loads password database
        LangManager.loadTranslations("en"); // Loads translations
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            LoginCommand.registerCommand(dispatcher);
            RegisterCommand.registerCommand(dispatcher);
            ChangePasswordCommand.registerCommand(dispatcher);
        }));
    }
}
