package lol.waifuware.ClickGUI.SettingPanel;

import lol.waifuware.ClickGUI.ModuleButton;
import lol.waifuware.Settings.ModeSetting;
import lol.waifuware.Settings.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class ModePanel extends SettingPanelBase
{

    public ModeSetting mode = (ModeSetting)setting;

    public ModePanel(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.mode = (ModeSetting)setting;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices, mode.getName(), parent.parent.xSet.getValueInt() + 5, parent.parent.ySet.getValueInt() + parent.offset + offset + 4, -1);
        MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices, mode.getModes().get(mode.getIndex()), (float) (parent.parent.xSet.getValueInt() - (MinecraftClient.getInstance().textRenderer.getWidth(mode.getModes().get(mode.getIndex())))  + (int)(parent.parent.width - 5)), parent.parent.ySet.getValueInt()+ parent.offset + offset + 4, -1);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button)
    {
        if(isHovered(mouseX, mouseY))
        {
            mode.cycle();
            parent.mod.Save();
        }
    }
}
