package gonzalvo.dpsm.cas.upm.edu.ph.mem2speech.recognizer;

import android.content.res.AssetManager;

public class RecognizerConfigBuilder {
    private AssetManager assetManager;
    private String modelFilename;
    private String charsetFile;
    private int imageWidth;
    private int imageHeight;

    public RecognizerConfigBuilder setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
        return this;
    }

    public RecognizerConfigBuilder setModelFilename(String modelFilename) {
        this.modelFilename = modelFilename;
        return this;
    }

    public RecognizerConfigBuilder setCharsetFile(String labelFilename) {
        this.charsetFile = labelFilename;
        return this;
    }

    public RecognizerConfigBuilder setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    public RecognizerConfigBuilder setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    public RecognizerConfig build() {
        return new RecognizerConfig(assetManager, modelFilename, charsetFile, imageWidth, imageHeight);
    }
}