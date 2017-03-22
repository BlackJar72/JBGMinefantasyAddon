package jaredbgreat.minefantasy.herbs;

/*
 * Based on a suggestion by Sirse and modified from code 
 * provided by Sirse on GitHub.  This reduces the number
 * of classes for herbs a bit and consolidates some code.
 */

import jaredbgreat.minefantasy.ConfigHandler;
import jaredbgreat.minefantasy.Info;
import minefantasy.mf2.api.stamina.StaminaBar;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHerb extends ItemFood {
	public final EHerbs type;
	
	private static PotionEffect heal = new PotionEffect(10, 60, 0);

	public ItemHerb(EHerbs herb) {
		super(herb.hunger, herb.saturation, false);
		type = herb;
		String herbName = herb.toString().toLowerCase();
		setPotionEffect(herb.potion);
		setUnlocalizedName(Info.ID + "-" + herbName);
		setTextureName(Info.ID + ":Herb/" + herbName);
		setCreativeTab(CreativeTabs.tabBrewing);
	}
	
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(type == EHerbs.GINSENG && StaminaBar.isSystemActive) {
			StaminaBar.modifyStaminaValue(player, ConfigHandler.ginsengStamina);
		}
		if(ConfigHandler.herbEffects) {
			switch(type) {
			case ALOE: // Same as camomile, so fall through
			case CAMOMILE:
				player.addPotionEffect(new PotionEffect(10, 60, 0));
				break;
			case COHOSH:
				player.addPotionEffect(new PotionEffect(5, 60, 0));
				break;
			case HORSETAIL:
				player.addPotionEffect(new PotionEffect(12, 60, 0));
				break;
			case GINSENG:     // Nothing!
			case MARSHMALLOW: // Nothing!
			default:          // Nothing!
				break;		
			}
		}
		return super.onEaten(stack, world, player);
	}
	
	
}