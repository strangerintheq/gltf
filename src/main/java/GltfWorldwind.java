import de.javagl.jgltf.model.GltfModel;
import de.javagl.jgltf.model.io.GltfModelReader;
import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.CrosshairLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;

import javax.swing.*;
import java.io.File;
import java.net.URI;

public class GltfWorldwind {

    public static void main(String[] args) throws Exception {
        URI gltfDuck = new URI("https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Duck/glTF/Duck.gltf");
        GltfModelReader r = new GltfModelReader();
        URI b3dm = new File("target/classes/tiles/Data/a.b3dm").toURI();
        GltfModel gltfModel = r.read(gltfDuck);

        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
        wwd.setModel(new BasicModel());
        GltfLayer layer = new GltfLayer(wwd);
        layer.addGltfModel(gltfModel);
//        layer.setExternalCamera(new WWCamera(wwd));
        wwd.getModel().getLayers().add(  layer);


        JFrame f = new JFrame();
        f.setTitle("gltf ww");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

    }
}