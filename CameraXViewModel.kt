package Model

import android.app.Application
import android.util.Log
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.Exception

class CameraXViewModel(application: Application) : AndroidViewModel(application) {
    private var cameraProviderLiveData : MutableLiveData<ProcessCameraProvider>? = null

    val processCameraProvider: LiveData<ProcessCameraProvider>
        get() {
        if (cameraProviderLiveData == null) {
            cameraProviderLiveData = MutableLiveData()
            val cameraProviderFuture = ProcessCameraProvider.getInstance(getApplication())
            cameraProviderFuture.addListener(Runnable {
                try {
                    cameraProviderLiveData!!.value = cameraProviderFuture.get()
                }
                catch (e: Exception) {
                    Log.e(TAG, "Unhandled exception", e)
                }
                catch (e: InterruptedException) {
                    Log.e(TAG, "Unhanlded exceptin", e)
                }
            }, ContextCompat.getMainExecutor(getApplication()))
        }
        return cameraProviderLiveData!!
    }
    companion object {
        private const val TAG = "CameraXViewModel"
    }
}