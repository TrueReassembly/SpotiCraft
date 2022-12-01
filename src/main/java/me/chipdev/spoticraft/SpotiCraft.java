package me.chipdev.spoticraft;

import com.mashape.unirest.http.Unirest;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class SpotiCraft implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("spotifyauth")
                        .then(argument("code", StringArgumentType.string()))
                .executes(ctx -> {
                    if (ctx.getArgument("code", String.class) == null) {
                        ctx.getSource().getPlayer().sendMessage(Text.literal(
                                "https://accounts.spotify.com/authorize?client_id=13e3a03e59ba414496446ace33661b4e&response_type=code&redirect_uri=https%3A%2F%2Fspotify.chipdev.me%2F"

                        ));
                    }

                    return 1;
                }
        )));
    }
}
