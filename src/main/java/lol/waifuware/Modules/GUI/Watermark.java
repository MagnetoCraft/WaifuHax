package lol.waifuware.Modules.GUI;

import lol.waifuware.Commands.MISC.Pronoun;
import lol.waifuware.Events.OnRenderScreen;
import lol.waifuware.Modules.AbstractModule;
import lol.waifuware.Modules.CATEGORY;
import lol.waifuware.Modules.Interfaces.Module;
import lol.waifuware.Settings.BooleanSetting;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.MinecraftClient;

import java.util.Objects;

@Module(name = "Watermark", key = 0, cat = CATEGORY.GUI)
public class Watermark extends AbstractModule
{

    public BooleanSetting ShowPronoun = new BooleanSetting("ShowPronoun", false, "Show your pronouns fetched from PronounDB");
    public BooleanSetting ShowVersion = new BooleanSetting("ShowVersion", true, "Show the version of WaifuHax you are using");
    public BooleanSetting ShowUsername = new BooleanSetting("ShowUsername", true, "Show your username");

    public Watermark()
    {
        super();
        addSettings(ShowVersion, ShowUsername, ShowPronoun);

        Create();
        desc[0] = "Fancy text on your screen";
    }

    @Override
    public String getDisplayName() {
        return name + " §c[" + (ShowPronoun.getEnabled() ? "§2P" : "§4P") + "§r, " + (ShowUsername.getEnabled() ? "§2U" : "§4U") + "§r, " + (ShowVersion.getEnabled() ? "§2V" : "§4V") + "§c]";
    }

    boolean marked;
    @EventHandler
    public void Render(OnRenderScreen event)
    {
        String name = MinecraftClient.getInstance().player.getEntityName();

        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§c[§dWelcome to §5WaifuHax" + (ShowVersion.getEnabled() ?" V2" : "") + "§d" + (ShowUsername.getEnabled() ? (", " + name) : "") + "§4 ♥§c] " + (ShowPronoun.getEnabled() ? (Pronoun.self_pronoun != null ? "§4Pronouns : " + Pronoun.self_pronoun : "") + "§r" : ""), 5, 5, 0xFFFFFF);
    }
}
