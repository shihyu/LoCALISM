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

package com.cabrol.francois.localism.example.mouse.view;

import com.cabrol.francois.localism.calibration.view.CalibrationFrame;
import com.cabrol.francois.localism.example.mouse.MouseReplacement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: francois * Date: 2014-01-23
 */
public class ConfigPanel extends JPanel implements ActionListener {


    private JButton calibrate;
    private JToggleButton mouseOn;

    private CalibrationFrame calibrationFrame;

    public ConfigPanel() {
        createUIComponents();
        addUIComponents();
        addActionListener();
    }

    private void createUIComponents() {
        calibrate = new JButton("Calibrate the screen");
        mouseOn = new JToggleButton("Mouse On Off");
    }

    private void addUIComponents(){
        add(calibrate);
        add(mouseOn);
    }

    private void addActionListener(){
        calibrate.addActionListener(this);
        mouseOn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calibrate){
            calibrationFrame = new CalibrationFrame(MouseReplacement.getInstance().getAppScreenPosition());
        }
        else if(e.getSource() == mouseOn){
            if(mouseOn.isSelected())
                MouseReplacement.getInstance().setMouseOn(true);
            else
                MouseReplacement.getInstance().setMouseOn(false);
        }
    }


}
