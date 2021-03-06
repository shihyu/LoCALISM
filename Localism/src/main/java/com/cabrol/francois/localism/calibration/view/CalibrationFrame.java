/*
 * Copyright (c) 2014 Francois Cabrol.
 *
 *  This file is part of LoCALISM.
 *
 *     LoCALISM is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     LoCALISM is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with LoCALISM.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cabrol.francois.localism.calibration.view;

import com.cabrol.francois.localism.calibration.screen.AppScreenPlan;

import javax.swing.*;
import java.awt.*;

/**
 * The frame that contains the calibration panel
 * @author Francois Cabrol <francois.cabrol@live.fr>
 * @since 2014-01-23
 */
public class CalibrationFrame extends JFrame {

    public CalibrationFrame(AppScreenPlan appScreenPlan) throws HeadlessException {
        super("Leap screen calibration window" );
        getContentPane().add( new CalibrationPanel(appScreenPlan) );
        initFramePosition();
        setVisible(true);
    }

    /**
     * Place the frame in the center of the screen
     */
    private void initFramePosition() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)dimension.getWidth()/2, (int)dimension.getHeight()/2);
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

}
