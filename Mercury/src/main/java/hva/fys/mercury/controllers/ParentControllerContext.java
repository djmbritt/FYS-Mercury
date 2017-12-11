package hva.fys.mercury.controllers;

/**
 * interface die ervoor zorgt dat de children taken in de parent uit kunnen
 * voeren
 *
 * @author David Britt
 */
public interface ParentControllerContext {

    public void notifyCloseChild();

    public void notifyChildHasUpdated();

    public void displayStatusMessage(String message);

    public void deleteLastElement();

    public void transferObject(Object o);
}
