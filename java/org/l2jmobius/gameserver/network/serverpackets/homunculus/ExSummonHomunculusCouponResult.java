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
import org.l2jmobius.gameserver.network.OutgoingPackets;
import org.l2jmobius.gameserver.network.serverpackets.IClientOutgoingPacket;

/**
 * @author `NasSeKa`
 */
public class ExSummonHomunculusCouponResult implements IClientOutgoingPacket
{
	private final int _slot;
	private final int _success;
	
	public ExSummonHomunculusCouponResult(int success, int slot)
	{
		_success = success;
		_slot = slot;
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.EX_SUMMON_HOMUNCULUS_COUPON_RESULT.writeId(packet);
		packet.writeD(_success);
		packet.writeD(_slot); // homunculus slot
		packet.writeD(0); // keep or delete
		return true;
	}
}
