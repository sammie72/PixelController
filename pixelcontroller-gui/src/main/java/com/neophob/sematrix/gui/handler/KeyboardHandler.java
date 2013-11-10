/**
 * Copyright (C) 2011-2013 Michael Vogt <michu@neophob.com>
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
package com.neophob.sematrix.gui.handler;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.neophob.sematrix.color.ColorSet;
import com.neophob.sematrix.generator.Generator;
import com.neophob.sematrix.glue.Collector;
import com.neophob.sematrix.glue.Visual;
import com.neophob.sematrix.gui.GuiCallbackAction;
import com.neophob.sematrix.listener.MessageProcessor;
import com.neophob.sematrix.properties.ValidCommands;

/**
 * 
 * PixelController Keyboard handler
 * 
 * @author mvogt
 *
 */
public abstract class KeyboardHandler {

	private static final Logger LOG = Logger.getLogger(KeyboardHandler.class.getName());

	private static GuiCallbackAction registerGuiClass;
    
    /**
     * 
     * @param key
     */
    public static void keyboardHandler(char key, int keyCode) {
    	
    	//if a user press a key during the setup - ignore it!
    	if (registerGuiClass==null) {    		
    		return;
    	}
    	
    	//if we edit a textfield, ignore keyboard shortcuts
    	if (registerGuiClass.isTextfieldInEditMode()) {
    		return;
    	}
    	
        Collector col = Collector.getInstance();
        Visual v = col.getVisual(col.getCurrentVisual());
        
        switch (key) {
        
        //change current Colorset
        case 'C':            
            if (v!=null) {
            	String colorSetName = v.getColorSet().getName();
                
                boolean takeNext = false;
                ColorSet nextColorSet = col.getColorSets().get(0);
                for (ColorSet cs : col.getColorSets()) {
                	if (takeNext) {
                		nextColorSet = cs;
                		break;
                	}
                	
                	if (cs.getName().equals(colorSetName)) {
                		takeNext = true;
                	}
                }

                v.setColorSet(nextColorSet.getName());
                registerGuiClass.refreshGui();
            }
            break;

        //change current generator 1
        case 'F':
        	if (v!=null) {            	
        		int currentGenerator = v.getGenerator1Idx();
        		int nrOfGenerators = 1+col.getPixelControllerGenerator().getSize();

        		int count=nrOfGenerators;
        		Generator g=null;
        		while (count>=0 && g==null) {
        			currentGenerator++;
        			g = col.getPixelControllerGenerator().getGenerator(currentGenerator%nrOfGenerators);
        		}

        		if (g!=null && g.getName() != null) {
        			v.setGenerator1(currentGenerator%nrOfGenerators);
        			registerGuiClass.refreshGui();            			
        		} else {
        			LOG.log(Level.INFO, "Could not find new Generator!");
        		}
        	}
        	break;

        //change current generator 2
        case 'G':
        	if (v!=null) {				
        		int currentGenerator = v.getGenerator2Idx();
        		int nrOfGenerators = 1+col.getPixelControllerGenerator().getSize();

        		int count=nrOfGenerators;
        		Generator g=null;
        		while (count>=0 && g==null) {
        			currentGenerator++;
        			g = col.getPixelControllerGenerator().getGenerator(currentGenerator%nrOfGenerators);
        		}

        		if (g!=null && g.getName() != null) {
        			v.setGenerator2(currentGenerator%nrOfGenerators);
        			registerGuiClass.refreshGui();            			
        		} else {
        			LOG.log(Level.INFO, "Could not find new Generator!");
        		}
        	}
            break;

        //change current effect 1
        case 'W':
            if (v!=null) {
                int currentEffect = v.getEffect1Idx();
                int nrOfEffects = col.getPixelControllerEffect().getSize();
                currentEffect++;
                v.setEffect1(currentEffect%nrOfEffects);
                registerGuiClass.refreshGui();
            }
            break;

        //change current effect 2
        case 'E':
            if (v!=null) {
                int currentEffect = v.getEffect2Idx();
                int nrOfEffects = col.getPixelControllerEffect().getSize();
                currentEffect++;
                v.setEffect2(currentEffect%nrOfEffects);
                registerGuiClass.refreshGui();
            }
            break;

        //change current mixer
        case 'M':
            if (v!=null) {
                int currentMixer = v.getMixerIdx();
                int nrOfMixerss = col.getPixelControllerMixer().getSize();
                currentMixer++;
                v.setMixer(currentMixer%nrOfMixerss);
                registerGuiClass.refreshGui();
            }
            break;
            
        //randomize
        case 'R':
            String msg[] = new String[1];		
            msg[0] = ""+ValidCommands.RANDOMIZE;
            MessageProcessor.processMsg(msg, false, null);            
            break;
            
        default:
            break;
        }   

        //select previous/next tab
        switch (keyCode) {
        	case KeyEvent.VK_LEFT:
        		registerGuiClass.selectPreviousTab();
        		break;                  
        	case KeyEvent.VK_RIGHT:
        		registerGuiClass.selectNextTab();
        		break;                  
        }
        
        if(key>='1' && key<'9') {
            if (registerGuiClass!=null) {
                // convert a key-number (48-52) to an int between 0 and 4
                int n = (int)key-49;
                registerGuiClass.activeVisual(n);
            }
        }           
    }



    /**
     * @param registerGuiClass the registerGuiClass to set
     */
    public static void setRegisterGuiClass(GuiCallbackAction registerGuiClass) {
        KeyboardHandler.registerGuiClass = registerGuiClass;
    }
    
    
}
