package pl.sats;

import pl.sats.CurveCalculations.Catenary;
import pl.sats.CurveCalculations.Parabola;
import pl.sats.FieldObservationsObjects.XYH;
import pl.sats.LineCalculations.PointToLineProjection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        AngleConverter angleConverter = new AngleConverter();
//
//        double B = angleConverter.degToRad(54.0 + 50.0 / 60.0);
//        double L = angleConverter.degToRad(18.0 + 30.0 / 60.0);
//
//        GaussKrugerProjection gaussKrugerProjection = new GaussKrugerProjection();
//        gaussKrugerProjection.getUTM(B, L);

        ClassLoader loader = Main.class.getClassLoader();
//        File file = new File(loader.getResource("TxtFiles/Chain2.txt").getFile());
        File file = new File(loader.getResource("TxtFiles/Field1.txt").getFile());

        Catenary catenary = new Catenary(file);
        catenary.calculateCatenary();
        System.out.println(catenary.getMinH() + "dla" + catenary.getLminH());





    }
}
