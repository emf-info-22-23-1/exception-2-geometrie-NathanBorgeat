package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {

        refIhm.afficheMessage("");
        refIhm.afficheResultatCircle("");

        try {
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du cercle");
        }

    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {

        refIhm.afficheMessage("");
        refIhm.afficheResultatRectangle("");

        boolean areaValide = false;

        try {
            double valueAreaDouble = Double.parseDouble(valueArea);
            areaValide = true;
            double valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
        } catch (ArithmeticException e) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour la longueur");
        } catch (NumberFormatException e) {

            if (areaValide) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour la longueur du rectangle");
            } else {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle");
            }

        }
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
