package cc.unilock.translationkeytestmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranslationKeyTestMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("TranslationKeyTestMod");

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("testcmd").executes(ctx -> {
				ServerCommandSource source = ctx.getSource();

				LOGGER.info("Sending chat messages.");
				source.sendMessage(Text.translatable("key.with.no.args"));
				source.sendMessage(Text.translatable("key.with.one.arg", Text.translatable("key.with.no.args.again")));
				LOGGER.info("Chat messages sent.");

				LOGGER.info("Sending log messages.");
				LOGGER.info(Text.translatable("key.with.no.args").getString());
				LOGGER.info(Text.translatable("key.with.one.arg", Text.translatable("key.with.no.args.again")).getString());
				LOGGER.info("Log messages sent.");

				return 0;
			}));
		});
	}
}
