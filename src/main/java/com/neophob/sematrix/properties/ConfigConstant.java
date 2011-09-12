/**
 * Copyright (C) 2011 Michael Vogt <michu@neophob.com>
 *
 * This file is part of PixelController.
 *
 * PixelController is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PixelController is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PixelController.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.neophob.sematrix.properties;

/**
 * The Class ConfigConstant.
 */
public final class ConfigConstant {

	private ConfigConstant() {
		//Utility Class
	}
	
	/** The Constant DELIM. */
	public static final String DELIM = ",";
	
	/** The Constant RAINBOWDUINO_ROW1. */
	public static final String RAINBOWDUINO_ROW1 = "layout.row1.i2c.addr";
	
	/** The Constant RAINBOWDUINO_ROW2. */
	public static final String RAINBOWDUINO_ROW2 = "layout.row2.i2c.addr";
	
	/** The Constant CFG_PANEL_COLOR_ORDER. */
	public static final String CFG_PANEL_COLOR_ORDER = "panel.color.order";

	/** The Constant NULLOUTPUT_ROW1. */
	public static final String NULLOUTPUT_ROW1 = "nulloutput.devices.row1";
	
	/** The Constant NULLOUTPUT_ROW2. */
	public static final String NULLOUTPUT_ROW2 = "nulloutput.devices.row2";
	
	/** The Constant ARTNET_IP. */
	public static final String ARTNET_IP = "artnet.ip";
	
	/** The Constant MINIDMX_RESOLUTION_X. */
	public static final String MINIDMX_RESOLUTION_X = "minidmx.resolution.x";
	
	/** The Constant MINIDMX_RESOLUTION_Y. */
	public static final String MINIDMX_RESOLUTION_Y = "minidmx.resolution.y";
	
	/** The Constant STARTUP_IN_RANDOM_MODE. */
	public static final String STARTUP_IN_RANDOM_MODE = "startup.in.randommode";
	
	/** The Constant CFG_PIXEL_SIZE. */
	public static final String CFG_PIXEL_SIZE = "led.pixel.size";
	
	/** The Constant PIXELINVADERS_ROW1. */
	public static final String PIXELINVADERS_ROW1 = "pixelinvaders.layout.row1";
	
	/** The Constant PIXELINVADERS_ROW2. */
	public static final String PIXELINVADERS_ROW2 = "pixelinvaders.layout.row2";
	
	/** The Constant NET_LISTENING_PORT. */
	public static final String NET_LISTENING_PORT = "3448";
	
	/** The Constant NET_SEND_PORT. */
	public static final String NET_SEND_PORT = "3449";
	
	/** The Constant NET_LISTENING_ADDR. */
	public static final String NET_LISTENING_ADDR = "127.0.0.1";
	
}