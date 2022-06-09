package com.solvd.photostudio.patterns.builder;

public class VideoCamera {
    private static String name;
    private static String colour;
    private static String resolution;

    public static String getName() {
        return name;
    }

    public static String getColour() {
        return colour;
    }

    public static String getResolution() {
        return resolution;
    }

private VideoCamera(Builder builder) {
    this.name = builder.name;
    this.colour = builder.colour;
    this.resolution = builder.resolution;
}
    public static class Builder {
        private String name;
        private String colour;
        private String resolution;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder setResolution(String resolution) {
            this.resolution = resolution;
            return this;
        }

        public VideoCamera build() {
            return new VideoCamera(this);
        }
    }
}