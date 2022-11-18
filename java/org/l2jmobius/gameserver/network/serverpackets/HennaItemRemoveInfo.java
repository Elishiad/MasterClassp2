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
package org.l2jmobius.gameserver.network.serverpackets;

import org.l2jmobius.commons.network.PacketWriter;
import org.l2jmobius.gameserver.model.actor.Player;
import org.l2jmobius.gameserver.model.item.Henna;
import org.l2jmobius.gameserver.model.stats.BaseStat;
import org.l2jmobius.gameserver.network.OutgoingPackets;

/**
 * @author Zoey76
 */
public class HennaItemRemoveInfo implements IClientOutgoingPacket
{
	private final Player _player;
	private final Henna _henna;
	
	public HennaItemRemoveInfo(Henna henna, Player player)
	{
		_henna = henna;
		_player = player;
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.HENNA_UNEQUIP_INFO.writeId(packet);
		packet.writeD(_henna.getDyeId()); // symbol Id
		packet.writeD(_henna.getDyeItemId()); // item id of dye
		packet.writeQ(_henna.getCancelCount()); // total amount of dye require
		packet.writeQ(_henna.getCancelFee()); // total amount of Adena require to remove symbol
		packet.writeD(_henna.isAllowedClass(_player.getClassId()) ? 1 : 0); // able to remove or not
		packet.writeQ(_player.getAdena());
		packet.writeD(_player.getINT()); // current INT
		packet.writeH(_player.getINT() - _player.getHennaValue(BaseStat.INT)); // equip INT
		packet.writeD(_player.getSTR()); // current STR
		packet.writeH(_player.getSTR() - _player.getHennaValue(BaseStat.STR)); // equip STR
		packet.writeD(_player.getCON()); // current CON
		packet.writeH(_player.getCON() - _player.getHennaValue(BaseStat.CON)); // equip CON
		packet.writeD(_player.getMEN()); // current MEN
		packet.writeH(_player.getMEN() - _player.getHennaValue(BaseStat.MEN)); // equip MEN
		packet.writeD(_player.getDEX()); // current DEX
		packet.writeH(_player.getDEX() - _player.getHennaValue(BaseStat.DEX)); // equip DEX
		packet.writeD(_player.getWIT()); // current WIT
		packet.writeH(_player.getWIT() - _player.getHennaValue(BaseStat.WIT)); // equip WIT
		packet.writeD(_player.getLUC()); // current LUC
		packet.writeH(_player.getLUC() - _player.getHennaValue(BaseStat.LUC)); // equip LUC
		packet.writeD(_player.getCHA()); // current CHA
		packet.writeH(_player.getCHA() - _player.getHennaValue(BaseStat.CHA)); // equip CHA
		packet.writeD(0);
		return true;
	}
}
