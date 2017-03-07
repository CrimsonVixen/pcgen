/*
 * Copyright 2002, 2003 (C) B. K. Oxley (binkley) <binkley@alumni.rice.edu>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */
package gmgen.gui;


import java.awt.event.InputEvent;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Utility Code for manipulating the GUI
 */
final class Utilities
{

	private Utilities()
	{
	}


	private static final String RESOURE_PREFIX = "resources/";

	/**
	 * Fetch an {@code ImageIcon} relative to the calling
	 * location.
	 *
	 * @param location {@code String}, the path to the {@code IconImage} source
	 *
	 * @return {@code ImageIcon}, the icon or {@code null} on failure
	 */
	static ImageIcon getImageIcon(final String location)
	{
		return getImageIcon(location, null);
	}

	/**
	 * {@code isShiftLeftMouseButton} detects SHIFT-BUTTON1
	 * events for flipping pane shortcuts.
	 *
	 * @param e {@code MouseEvent}, the event
	 *
	 * @return {@code boolean}, the condition
	 */
	static boolean isShiftLeftMouseButton(InputEvent e)
	{
		return ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) && e.isShiftDown();
	}

	/**
	 * Fetch an {@code ImageIcon} relative to the calling
	 * location and using a description.
	 *
	 * @param location {@code String}, the path to the
	 * {@code IconImage} source
	 * @param description {@code String}, the description
	 *
	 * @return {@code ImageIcon}, the icon or {@code null}
	 * on failure
	 */
	private static ImageIcon getImageIcon(String location, final String description)
	{

		if (location.startsWith(RESOURE_PREFIX))
		{
			location = location.substring(RESOURE_PREFIX.length());
		}

		final URL iconURL = Utilities.class.getResource(location);

		if (iconURL == null)
		{
			return null;
		}

		return new ImageIcon(iconURL, description);
	}

}
