package com.solvd.photostudio.patterns;
import com.solvd.photostudio.patterns.builder.VideoCamera;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuilderExecutor {
    private static final Logger LOGGER = LogManager.getLogger(BuilderExecutor.class);
    public static void main(String[] args) {
        VideoCamera videoCamera = new VideoCamera.Builder("Panasonic").setColour("black").setResolution("4K").build();
        LOGGER.info(VideoCamera.getName());
        LOGGER.info(VideoCamera.getColour());
        LOGGER.info(VideoCamera.getResolution());
    }
}
