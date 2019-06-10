package com.oldsenior.ella.core_ui.error

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.orhanobut.logger.Logger
import com.oldsenior.ella.core_ui.alert.Alert
import com.oldsenior.ella.core_ui.alert.AlertType
import com.oldsenior.ella.core_ui.alert.getDescription

class DialogHelper {

    companion object {
        private const val DIALOG_TAG = "AlertDialogFragment"
    }

    fun showError(activity: FragmentActivity, alert: Alert) {
        when (alert.type) {
            AlertType.TOAST -> showToast(activity, alert)
            AlertType.DIALOG -> showDialog(activity, alert)
        }
    }


    private fun showDialog(activity: FragmentActivity, alert: Alert) {
        val fragmentManager = activity.supportFragmentManager
        if (fragmentManager.findFragmentByTag(DIALOG_TAG) == null) {
            val errorDialogFragment = AlertDialogFragment.newInstance(alert)
            try {
                fragmentManager.beginTransaction()
                    .add(errorDialogFragment, DIALOG_TAG)
                    .commitNowAllowingStateLoss()
            } catch (e: IllegalStateException) {
                Logger.e(e, e.localizedMessage)
            }
        }
    }

    private fun showToast(context: Context, alert: Alert) {
        Toast.makeText(context, alert.getDescription(context), Toast.LENGTH_LONG).show()
    }
}