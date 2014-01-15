package cheatingessentials.mod.internal.ttf;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

public class FontHandler {
	private static volatile FontHandler instance;
    private boolean globalTTF = true;
    public static String fontName = "Segoe UI";
    public static int fontSize = 16;

    public static FontHandler getInstance() {
            if (instance == null) {
                    instance = new FontHandler();
            }
            return instance;
    }

    public String getFontName() {
    	return fontName;
    }

    public void setFontName(final String fontName) {
    	this.fontName = fontName;
    }

    public int getFontSize() {
    	return fontSize;
    }

    public void setFontSize(final int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isGlobalTTF() {
        return globalTTF;
    }

    public void setGlobalTTF(final boolean globalTTF) {
        this.globalTTF = globalTTF;
    }

    public void resetGlobalTTF(final boolean status) {
        globalTTF = status;
        initializeFontRenderer();
    }

    public void initializeFontRenderer() {
    	final Minecraft mc = Minecraft.getMinecraft();
    	mc.fontRenderer = new FontRenderer(mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), mc.renderEngine, false);
        mc.standardGalacticFontRenderer = new FontRenderer(mc.gameSettings, new ResourceLocation("textures/font/ascii.png"), mc.renderEngine, false);
    }
}
