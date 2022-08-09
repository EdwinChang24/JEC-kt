import java.io.IOException
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.createFile
import kotlin.io.path.deleteIfExists
import kotlin.io.path.exists

/**
 * Base class for config files and directories.
 *
 * @param pathString The path to the file or directory.
 */
open class ConfigBase(pathString: String) {
    /**
     * The path to the file or directory, represented as a [Path] object.
     */
    val path = Path(pathString)

    /**
     * Whether the file or directory exists.
     */
    val exists
        get() = path.exists()
}

/**
 * A configuration file class with utilities.
 *
 * @param pathString The path to the file.
 */
class ConfigFile(pathString: String) : ConfigBase(pathString) {
    companion object {
        /**
         * Constructs a [ConfigFile] object from the home directory and the given path.
         * For example, `ConfigFile.fromHome("my-config-dir/some-file")` might return a `ConfigFile`
         * with path `/home/jabacat/my-config-dir/some-file`.
         */
        fun fromHome(path: String) = Path(System.getProperty("user.home"), path)
    }

    /**
     * Creates this file.
     *
     * @return `true` if the file was successfully created,
     * `false` if the file already existed or another error occurred.
     */
    fun create(): Boolean {
        return try {
            path.createFile()
            true
        } catch (e: IOException) {
            false
        }
    }

    /**
     * Deletes this file.
     *
     * @return `true` if the file was successfully deleted,
     * `false` if the file did not exist or another error occurred.
     */
    fun remove() = path.deleteIfExists()
}

/**
 * A configuration directory class with utilities.
 *
 * @param pathString The path to the directory.
 */
class ConfigDir(pathString: String) : ConfigBase(pathString) {
    companion object {
        /**
         * Constructs a [ConfigDir] object from the home directory and the given path.
         * For example, `ConfigDir.fromHome("my-config-dir")` might return a `ConfigDir`
         * with path `/home/jabacat/my-config-dir`.
         */
        fun fromHome(path: String) = Path(System.getProperty("user.home"), path)
    }

    /**
     * Creates this directory.
     *
     * @return `true` if the directory was successfully created,
     * `false` if the directory already existed or another error occurred.
     */
    fun create(): Boolean {
        return try {
            path.createDirectory()
            true
        } catch (e: IOException) {
            false
        }
    }

    /**
     * Deletes this directory, recursively deleting all inner files and subdirectories.
     *
     * @return `true` if the directory was successfully deleted, `false` otherwise.
     */
    fun remove() = path.toFile().deleteRecursively()
}
