/**
 * Sample download manager program.
 * Interface is used to provide a port to unknown implementation.
 *
 * @author L.Gobinath
 */
public class DownloadManager {
    private OnDownloadListener listener;

    public void setListener(OnDownloadListener listener) {
        this.listener = listener;
    }

    public void start() {
        boolean completed = false;
        double percent = 0.0;
        while (!completed) {
            // download the file
            // increase the completed percentage
            if (listener != null) {
                listener.onDownload(percent);
            }
        }
    }
}

interface OnDownloadListener {
    void onDownload(double percent);
}