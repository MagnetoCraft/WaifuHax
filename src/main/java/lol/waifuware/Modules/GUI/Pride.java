package lol.waifuware.Modules.GUI;

import lol.waifuware.Events.OnRenderScreen;
import lol.waifuware.Modules.AbstractModule;
import lol.waifuware.Modules.CATEGORY;
import lol.waifuware.Modules.Interfaces.Module;
import lol.waifuware.Settings.ModeSetting;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.MinecraftClient;
import java.util.Calendar;
import java.util.Date;
@Module(name = "Pride", key = 0, cat = CATEGORY.GUI)
public class Pride extends AbstractModule 
{

    public ModeSetting Flag = new ModeSetting("Pride flag", "rainbow", "what prideflag to display", "pf", "rainbow", "bisexual", "trans", "lesbian");

    public Pride()
    {
        super();
        desc[0] = "show a nice pride flag on your screen";
        addSettings(Flag);
        Create();

        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        if(month == Calendar.JUNE)
        {
            Toggle(true);
        }
    }
    
    @EventHandler
    void OnRenderEvent(OnRenderScreen event)
    {
        int w = MinecraftClient.getInstance().textRenderer.getWidth("§l||||||||||||||||||||||||||||||||||||||||||||||||");
        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§l||||||||||||||||||||||||||||||||||||||||||||||||", MinecraftClient.getInstance().getWindow().getScaledWidth() - w, 0, getPrideColor(0));
        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§l||||||||||||||||||||||||||||||||||||||||||||||||", MinecraftClient.getInstance().getWindow().getScaledWidth() - w, 8, getPrideColor(1));
        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§l||||||||||||||||||||||||||||||||||||||||||||||||", MinecraftClient.getInstance().getWindow().getScaledWidth() - w, 16, getPrideColor(2));
        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§l||||||||||||||||||||||||||||||||||||||||||||||||", MinecraftClient.getInstance().getWindow().getScaledWidth() - w, 24, getPrideColor(3));
        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§l||||||||||||||||||||||||||||||||||||||||||||||||", MinecraftClient.getInstance().getWindow().getScaledWidth() - w, 32, getPrideColor(4));
        MinecraftClient.getInstance().textRenderer.drawWithShadow(event.getMatrices(), "§l||||||||||||||||||||||||||||||||||||||||||||||||", MinecraftClient.getInstance().getWindow().getScaledWidth() - w, 40, getPrideColor(5));
    }

    int getPrideColor(int index)
    {
        switch (Flag.getIndex())
        {
            default:
                return 0x000000;
            case 0:
                // rainbow
                if(index == 0)
                {
                    return     0xE40303;
                }else if(index == 1)
                {
                    return     0xFF8C00;
                }else if(index == 2)
                {
                    return     0xFFED00;
                }else if(index == 3)
                {
                    return     0x008026;
                }else if(index == 4)
                {
                    return     0x24408E;
                }else if(index == 5)
                {
                    return     0x732982;
                }
                break;
            case 1:
                if(index == 0)
                {
                    return     0xD60270;
                }else if(index == 1)
                {
                    return     0xD60270;
                }else if(index == 2)
                {
                    return     0x9B4F96;
                }else if(index == 3)
                {
                    return     0x9B4F96;
                }else if(index == 4)
                {
                    return     0x0038A8;
                }else if(index == 5)
                {
                    return     0x0038A8;
                }
                break;
            case 2:
                if(index == 0)
                {
                    return     0x5BCEFA;
                }else if(index == 1)
                {
                    return     0xF5A9B8;
                }else if(index == 2)
                {
                    return     0xFFFFFF;
                }else if(index == 3)
                {
                    return     0xFFFFFF;
                }else if(index == 4)
                {
                    return     0xF5A9B8;
                }else if(index == 5)
                {
                    return     0x5BCEFA;
                }
                break;
            case 3:
                if(index == 0)
                {
                    return     0xEF7627;
                }else if(index == 1)
                {
                    return     0xFF9A56;
                }else if(index == 2)
                {
                    return     0xFFFFFF;
                }else if(index == 3)
                {
                    return     0xD162A4;
                }else if(index == 4)
                {
                    return     0xB55690;
                }else if(index == 5)
                {
                    return     0xA30262;
                }
                break;
        }
        return 0x000000;
    }

    @Override
    public void onDisable()
    {
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        if(month == Calendar.JUNE)
        {
            Toggle(true);
        }
    }
}
