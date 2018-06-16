package com.applitools.eyes;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Encapsulates step information data received by the tests results.
 */
public class StepInfo {
    public static class AppUrls {
        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        private String step;
    }

    public static class ApiUrls {
        private String baselineImage;
        private String currentImage;
        private String diffImage;

        public String getBaselineImage() {
            return baselineImage;
        }

        public void setBaselineImage(String baselineImage) {
            this.baselineImage = baselineImage;
        }

        public String getCurrentImage() {
            return currentImage;
        }

        public void setCurrentImage(String currentImage) {
            this.currentImage = currentImage;
        }

        public String getDiffImage() {
            return diffImage;
        }

        public void setDiffImage(String diffImage) {
            this.diffImage = diffImage;
        }
    }

    private String name;
    private boolean isDifferent;
    private boolean hasBaselineImage;
    private boolean hasCurrentImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("different")
    public boolean isDifferent() {
        return isDifferent;
    }

    @JsonSetter("different")
    public void setDifferent(boolean different) {
        isDifferent = different;
    }

    public boolean HasBaselineImage() {
        return hasBaselineImage;
    }

    public void setHasBaselineImage(boolean hasBaselineImage) {
        this.hasBaselineImage = hasBaselineImage;
    }

    public boolean HasCurrentImage() {
        return hasCurrentImage;
    }

    public void setHasCurrentImage(boolean hasCurrentImage) {
        this.hasCurrentImage = hasCurrentImage;
    }
}
