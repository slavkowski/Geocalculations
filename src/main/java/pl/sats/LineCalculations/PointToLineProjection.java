package pl.sats.LineCalculations;

import pl.sats.AzimuthDistanceCalculation;
import pl.sats.FieldObservationsObjects.LHD;
import pl.sats.FieldObservationsObjects.NEH;
import pl.sats.LSEstimations.LeastSquaresEstimation;

import java.util.ArrayList;
import java.util.List;

public class PointToLineProjection {


    private boolean error;


    public List<LHD> getLHD(List<NEH> xyhList) {
        List<LHD> lhList = new ArrayList<>();
        int lenghtOfList = xyhList.size();
        NEH firstPoint = xyhList.get(0);
        NEH lastPoint = xyhList.get(lenghtOfList - 1);
        double L[][] = new double[2][1];
        double A[][] = new double[2][2];
        double P[][] = new double[2][2];
        double resultLD [][];

        AzimuthDistanceCalculation azimuthDistanceCalculation = new AzimuthDistanceCalculation();
        double Az = azimuthDistanceCalculation.calculateAzimuth(firstPoint.getX(), firstPoint.getY(), lastPoint.getX(), lastPoint.getY());

        A[0][0] = Math.sin(Az);
        A[1][0] = Math.cos(Az);
        A[0][1] = Math.cos(Az);
        A[1][1] = -Math.sin(Az);

        P[0][0] = 1.0;
        P[1][0] = 0.0;
        P[0][1] = 0.0;
        P[1][1] = 1.0;




        for (NEH aXyhList : xyhList) {
            LeastSquaresEstimation dx = new LeastSquaresEstimation();
            L[0][0] = aXyhList.getY() - firstPoint.getY();
            L[1][0] = aXyhList.getX() - firstPoint.getX();
            dx.setA(A);
            dx.setP(P);
            dx.setL(L);
            resultLD = dx.getX();
            LHD lhd = new LHD(resultLD[0][0], aXyhList.getH(), resultLD[1][0]);
            lhList.add(lhd);
        }
        return lhList;

    }




}
