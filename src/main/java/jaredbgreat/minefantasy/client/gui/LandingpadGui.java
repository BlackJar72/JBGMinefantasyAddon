package jaredbgreat.minefantasy.client.gui;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jaredbgreat.minefantasy.blocks.container.LandingpadContainer;
import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class LandingpadGui extends GuiContainer {
	    private LandingpadContainer container;
	    private GuiTextField textField;
	    private InventoryPlayer player;

	public LandingpadGui(InventoryPlayer player, LandingpadLogic pad) {
		super(new LandingpadContainer(player, pad));
		this.player = player;
		container = (LandingpadContainer)inventorySlots;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}
	
	
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        textField = new GuiTextField(fontRendererObj, i + 32, j + 24, 128, 12);
        textField.setTextColor(-1);
        textField.setDisabledTextColour(-1);
        textField.setEnableBackgroundDrawing(false);
        textField.setMaxStringLength(64);
    }

    
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

}
