/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;

/**
 *
 * @author djmbritt
 */
public interface ParentControllerContext {

    public void notifyCloseChild();

    public void notifyChildHasUpdated();

    public void displayStatusMessage(String message);
    
    public void deleteLastElement();

    public void transferObject(Object o);
}
