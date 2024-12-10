package ca.codepet.gdz.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import ca.codepet.dodge.GameRoot;

public class Util {
    /**
     * Load all assets from the textures, music, and sounds folders.
     */
    public static void loadAllAssets(GameRoot game) {
        String texturePath = "assets/textures/";
        String musicPath = "assets/audio/music/";
        String soundsPath = "assets/audio/sounds/";

        loadAssetsFromFolder(game.assetManager, texturePath, Texture.class);
        loadAssetsFromFolder(game.assetManager, musicPath, Music.class);
        loadAssetsFromFolder(game.assetManager, soundsPath, Sound.class);
    }

    /**
     * Load all assets from a folder.
     *
     * @param folderPath The path to the folder containing the assets.
     * @param assetType  The type of asset to load.
     */
    private static void loadAssetsFromFolder(AssetManager assetManager, String folderPath, Class<?> assetType) {
        FileHandle folder = Gdx.files.internal(folderPath);

        // Ensure the folder exists and is a directory
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("The folder " + folderPath + " does not exist or is not a directory.");
        }

        for (FileHandle file : folder.list()) {
            if (file.isDirectory()) {
                // Recursively load assets from subdirectories
                loadAssetsFromFolder(assetManager, file.path(), assetType);
            } else {
                String extension = file.extension();
                if (isSupportedExtension(extension, assetType)) {
                    assetManager.load(file.path(), assetType);
                }
            }
        }
    }

    /**
     * Check if the extension is supported for the given asset type.
     *
     * @param extension The extension of the file.
     * @param assetType The type of asset to load.
     * @return True if the extension is supported, false otherwise.
     */
    private static boolean isSupportedExtension(String extension, Class<?> assetType) {
        if (assetType == Texture.class) {
            return extension.equals("png") || extension.equals("jpg");
        } else if (assetType == Sound.class) {
            return extension.equals("mp3") || extension.equals("ogg") || extension.equals("wav");
        } else if (assetType == Music.class) {
            return extension.equals("mp3");
        }
        return false;
    }
}
