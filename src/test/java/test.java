import com.google.common.geometry.*;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {

        S2RegionCoverer coverer = new S2RegionCoverer();

            coverer.setMinLevel(12);
            coverer.setMaxLevel(12);
        coverer.setMaxCells(10000);


        S2LatLng startS2 = S2LatLng.fromDegrees(0.8293, 72.004); //左下角
        S2LatLng endS2 = S2LatLng.fromDegrees(55.8271, 137.8347); //右上角
        S2LatLngRect rect  = new S2LatLngRect(startS2, endS2);


        //val s2CellUnion = coverer.getInteriorCovering(polygon)
        S2CellUnion s2CellUnion = coverer.getCovering(rect);
        s2CellUnion.normalize();


        ArrayList<S2CellId>  list = s2CellUnion.cellIds();
        for (S2CellId cellId : list ) {
            System.out.println(cellId.toLatLng().lngDegrees() + "," + cellId.toLatLng().latDegrees());
        }
    }
}
