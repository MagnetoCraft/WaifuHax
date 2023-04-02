package lol.waifuware.ClickGUI.SettingPanel;

import lol.waifuware.ClickGUI.ModuleButton;
import lol.waifuware.Settings.IntSetting;
import lol.waifuware.Settings.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class SliderPanel extends SettingPanelBase
{

    public IntSetting integer = (IntSetting) setting;

    public SliderPanel(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        integer = (IntSetting) setting;

        if(setting.getName().toLowerCase().contains("color")){
            setting.setVisible(false);
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        if(setting.getVisible()) {
            MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices, integer.getName() + " : ", parent.parent.xSet.getValueInt() + 5, parent.parent.ySet.getValueInt() + parent.offset + offset + 4, -1);
            MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices, String.valueOf(integer.getValueFloat()), parent.parent.xSet.getValueInt() + 5, parent.parent.ySet.getValueInt() + parent.offset + (offset + 18) + 4, -1);
        }
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button)
    {
        if(isHovered(mouseX, mouseY)) {
            if (button == 1 && integer.getValue() > integer.getMin()) {
                integer.setValue(integer.getValue() - integer.getIncrement());
                parent.mod.Save();
            } else if (button == 0 && integer.getValue() < integer.getMax()) {
                integer.setValue(integer.getValue() + integer.getIncrement());
                parent.mod.Save();
            }
        }
    }

    @Override
    public void mouseRelease(double mouseX, double mouseY, int button) {
        super.mouseRelease(mouseX, mouseY, button);
    }
}
