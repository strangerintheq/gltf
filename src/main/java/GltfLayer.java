import gltf.GltfViewerJogl;
import gov.nasa.worldwind.avlist.AVList;
import gov.nasa.worldwind.event.Message;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.render.DrawContext;
import gov.nasa.worldwind.util.OGLStackHandler;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL3;
import javax.media.opengl.awt.GLCanvas;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GltfLayer extends GltfViewerJogl implements Layer {
    /**
     * Creates a new GltfViewerJogl
     *
     * @param glComponent
     */
    public GltfLayer(GLCanvas glComponent) {
        super(glComponent);
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void setEnabled(boolean b) { }

    @Override
    public String getName() {
        return "GLTF";
    }

    @Override
    public void setName(String s) { }

    @Override
    public double getOpacity() {
        return 1;
    }

    @Override
    public void setOpacity(double v) { }

    @Override
    public boolean isPickEnabled() {
        return false;
    }

    @Override
    public void setPickEnabled(boolean b) { }

    @Override
    public void preRender(DrawContext drawContext) {
        prepareRender();
    }

    @Override
    public void render(DrawContext drawContext) {
        OGLStackHandler ogsh = new OGLStackHandler();
        GL2 gl = (GL2) drawContext.getGL();
        ogsh.pushAttrib(gl, GL2.GL_ALL_ATTRIB_BITS);
        ogsh.pushModelview(gl);
        ogsh.pushProjection(gl);
        ogsh.pushTexture(gl);
        gl.glPushClientAttrib(GL2.GL_CLIENT_PIXEL_STORE_BIT);
        IntBuffer buf = IntBuffer.allocate(1);
        gl.glGetIntegerv(GL2.GL_CURRENT_PROGRAM, buf);
        doRender();
        gl.glPushClientAttrib(GL2.GL_CLIENT_PIXEL_STORE_BIT);
        System.out.println("buf = " + buf.get());
        gl.glUseProgram(buf.get());
        ogsh.pop(gl);
//
//         drawContext.restoreDefaultBlending();
//         drawContext.restoreDefaultCurrentColor();
//         drawContext.restoreDefaultDepthTesting();

    }

    @Override
    public void pick(DrawContext drawContext, Point point) { }

    @Override
    public boolean isAtMaxResolution() {
        return false;
    }

    @Override
    public boolean isMultiResolution() {
        return false;
    }

    @Override
    public double getScale() {
        return 1;
    }

    @Override
    public boolean isNetworkRetrievalEnabled() {
        return false;
    }

    @Override
    public void setNetworkRetrievalEnabled(boolean b) { }

    @Override
    public void setExpiryTime(long l) { }

    @Override
    public long getExpiryTime() {
        return 0;
    }

    @Override
    public double getMinActiveAltitude() {
        return 0;
    }

    @Override
    public void setMinActiveAltitude(double v) { }

    @Override
    public double getMaxActiveAltitude() {
        return 0;
    }

    @Override
    public void setMaxActiveAltitude(double v) { }

    @Override
    public boolean isLayerInView(DrawContext drawContext) {
        return true;
    }

    @Override
    public boolean isLayerActive(DrawContext drawContext) {
        return true;
    }

    @Override
    public Double getMaxEffectiveAltitude(Double aDouble) {
        return null;
    }

    @Override
    public Double getMinEffectiveAltitude(Double aDouble) {
        return null;
    }

    @Override
    public void dispose() { }

    @Override
    public String getRestorableState() {
        return null;
    }

    @Override
    public void restoreState(String s) { }

    @Override
    public Object setValue(String s, Object o) {
        return null;
    }

    @Override
    public AVList setValues(AVList avList) {
        return null;
    }

    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public Collection<Object> getValues() {
        return null;
    }

    @Override
    public String getStringValue(String s) {
        return null;
    }

    @Override
    public Set<Map.Entry<String, Object>> getEntries() {
        return null;
    }

    @Override
    public boolean hasKey(String s) {
        return false;
    }

    @Override
    public Object removeKey(String s) {
        return null;
    }

    @Override
    public void addPropertyChangeListener(String s, PropertyChangeListener propertyChangeListener) { }

    @Override
    public void removePropertyChangeListener(String s, PropertyChangeListener propertyChangeListener) { }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) { }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) { }

    @Override
    public void firePropertyChange(String s, Object o, Object o1) { }

    @Override
    public void firePropertyChange(PropertyChangeEvent propertyChangeEvent) { }

    @Override
    public AVList copy() {
        return null;
    }

    @Override
    public AVList clearList() {
        return null;
    }

    @Override
    public void onMessage(Message message) { }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { }
}
