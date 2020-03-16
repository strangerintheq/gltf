import gltf.ExternalCamera;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

public class WWCamera implements ExternalCamera {
    private double[] viewMatrixD = new double[16];
    private float[] viewMatrixF = new float[16];
    private double[] projectionMatrixD = new double[16];
    private float[] projectionMatrixF = new float[16];
    private WorldWindowGLCanvas wwd;

    public WWCamera(WorldWindowGLCanvas wwd) {
        this.wwd = wwd;
    }

    @Override
    public float[] getViewMatrix() {
        double[] doubles = wwd.getView().getModelviewMatrix().toArray(viewMatrixD, 0, false);
        for (int i = 0; i < 16; i++) {
            viewMatrixF[i] = (float) doubles[i];
        }
        return viewMatrixF;
    }

    @Override
    public float[] getProjectionMatrix() {
        double[] doubles = wwd.getView().getProjectionMatrix().toArray(projectionMatrixD, 0, false);
        for (int i = 0; i < 16; i++) {
            projectionMatrixF[i] = (float) doubles[i];
        }
        return projectionMatrixF;
    }
}
