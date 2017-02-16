/**
    Copyright (C) <2016> <coolAlias>

    This file is part of coolAlias' Dynamic Sword Skills Minecraft Mod; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dynamicswordskills.network.server;

import static minefantasy.mf2.api.stamina.StaminaBar.modifyStaminaValue;
import jaredbgreat.combatmod.ConfigHandler;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import cpw.mods.fml.relauncher.Side;
import dynamicswordskills.network.AbstractMessage.AbstractServerMessage;

/**
 * 
 * Used for skills that activate client-side only and need to add exhaustion to the player.
 *
 */
public class AddExhaustionPacket extends AbstractServerMessage<AddExhaustionPacket>
{
	private float amount;

	public AddExhaustionPacket() {}

	public AddExhaustionPacket(float amount) {
		this.amount = amount;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.amount = buffer.readFloat();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeFloat(amount);
	}

	@Override
	protected void process(EntityPlayer player, Side side) {
		player.addExhaustion(amount);
		// Following line added for JaredBGreat
		modifyStaminaValue(player, ConfigHandler.DssFactor * amount);
	}
}
