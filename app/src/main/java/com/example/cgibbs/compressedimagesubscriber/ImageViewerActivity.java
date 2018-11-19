package com.example.cgibbs.compressedimagesubscriber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.ros.address.InetAddressFactory;
import org.ros.android.BitmapFromCompressedImage;
import org.ros.android.RosActivity;
import org.ros.android.view.RosImageView;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;

import java.net.URI;

public class ImageViewerActivity extends RosActivity {

    /*
     * Fields
     */

    private RosImageView<sensor_msgs.CompressedImage> image;

    /*
     * Constructors
     */

    public ImageViewerActivity() {
        super("CompressedImagesSubscriber",
                "CompressedImagesSubscriber",
                URI.create("http://172.16.32.218:11311/"));
    }

    /*
     * Protected Methods
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        // Get the strings from the previous activity's intent
        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity.EXTRA_URL);
        String topic = intent.getStringExtra(MainActivity.EXTRA_TOPIC);

        // Subscribe to the image stream
        image = (RosImageView<sensor_msgs.CompressedImage>) findViewById(R.id.image);
        image.setTopicName(topic);
        image.setMessageType(sensor_msgs.CompressedImage._TYPE);
        image.setMessageToBitmapCallable(new BitmapFromCompressedImage());
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        NodeConfiguration nodeConfiguration =
                NodeConfiguration.newPublic(InetAddressFactory.newNonLoopback().getHostAddress(),
                        getMasterUri());
        nodeMainExecutor.execute(image, nodeConfiguration.setNodeName("android/image_viewer"));
    }
}
