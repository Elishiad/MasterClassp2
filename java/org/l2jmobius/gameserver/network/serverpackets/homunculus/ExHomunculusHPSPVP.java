/*
 * This file is part of the L2J Mobius project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jmobius.gameserver.network.serverpackets.homunculus;

import org.l2jmobius.commons.network.PacketWriter;
import org.l2jmobius.gameserver.model.actor.Player;
import org.l2jmobius.gameserver.network.OutgoingPackets;
import org.l2jmobius.gameserver.network.serverpackets.IClientOutgoingPacket;

/**
 * @author Mobius
 */
public class ExHomunculusHPSPVP implements IClientOutgoingPacket
{
	private final int _hp;
	private final long _sp;
	private final int _vp;
	
	public ExHomunculusHPSPVP(Player player)
	{
		_hp = (int) player.getCurrentHp();
		_sp = player.getSp();
		_vp = player.getVitalityPoints();
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.EX_HOMUNCULUS_HPSPVP.writeId(packet);
		packet.writeD(_hp);
		packet.writeQ(_sp);
		packet.writeD(_vp);
		return true;
	}
}
